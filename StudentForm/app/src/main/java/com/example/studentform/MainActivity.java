package com.example.studentform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText name, number, date;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editTextText4);
        number = (EditText) findViewById(R.id.editTextText5);
        date = (EditText) findViewById(R.id.editTextText6);
        btn = (Button) findViewById(R.id.buttonSub);
    }
    public void subFunc(View view){
        if(name.getText().toString().isEmpty()){
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if(name.getText().toString().contains("!@#$%^&*()1234567890_+-=")){
            Toast.makeText(this, "Cannot contain special character in name", Toast.LENGTH_SHORT).show();
        }
        if(number.getText().toString().isEmpty()){
            Toast.makeText(this, "Number cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if(date.getText().toString().isEmpty()){
            Toast.makeText(this, "DOB cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }

}