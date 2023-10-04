package com.example.studentform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText name, number, date;
    Button btn;
    RadioButton male, female;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editTextText4);
        number = (EditText) findViewById(R.id.editTextText5);
        date = (EditText) findViewById(R.id.editTextText6);
        btn = (Button) findViewById(R.id.buttonSub);
        male = (RadioButton) findViewById(R.id.radioButton3);
        female = (RadioButton) findViewById(R.id.radioButton4);
    }
    public void subFunc(View view){
//        if(name.getText().toString().isEmpty()){
//            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
//        }
//        if (name.getText().toString().matches(".*[!@#\\$%^&*()1234567890_+\\-=].*")) {
//            Toast.makeText(this, "Cannot contain special character in name", Toast.LENGTH_SHORT).show();
//        }
//        if(number.getText().toString().isEmpty()){
//            Toast.makeText(this, "Number cannot be empty", Toast.LENGTH_SHORT).show();
//        }
        if(number.length()<10 || number.length()>10){
            Toast.makeText(this, "Please enter correct number", Toast.LENGTH_SHORT).show();
        }
//        if(date.getText().toString().isEmpty()){
//            Toast.makeText(this, "DOB cannot be empty", Toast.LENGTH_SHORT).show();
//        }
//        if (!male.isSelected() && !female.isSelected()){
//            Toast.makeText(this, "Atleast one gender should be specified", Toast.LENGTH_SHORT).show();
//        }
    }

}