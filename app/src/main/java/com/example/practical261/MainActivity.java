package com.example.practical261;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edt1);
        post = findViewById(R.id.edt2);

        MySqliteDemo database = new MySqliteDemo(MainActivity.this);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(name.getText().toString().equals(" ") && post.getText().toString().equals(" ")) {
                    Toast.makeText(getApplicationContext(), "Please Enter value in every Field",Toast.LENGTH_SHORT).show();
                }
                else{
                    long val = database.insert(name.getText().toString(),post.getText().toString());
                    if (val > 0) {
                        Toast.makeText(getApplicationContext(), val + " Values is inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), val + " insertion is not  successfully", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }
}