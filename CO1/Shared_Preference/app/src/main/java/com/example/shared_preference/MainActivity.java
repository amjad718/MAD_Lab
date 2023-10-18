package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText name, number, DOB;
    RadioButton male, female;
    CheckBox English, Malayalam;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.nameid);
        number = (EditText) findViewById(R.id.numberid);
        DOB = (EditText) findViewById(R.id.dobid);
        male = (RadioButton) findViewById(R.id.radioButton3);
        female = (RadioButton) findViewById((R.id.radioButton4));
        English = (CheckBox) findViewById(R.id.checkBox);
        Malayalam = (CheckBox) findViewById(R.id.checkBox2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", name.getText().toString());
        myEdit.putString("number", number.getText().toString());
        myEdit.putString("DOB", DOB.getText().toString());
        myEdit.putString("male",male.getText().toString());
        myEdit.putString("female",male.getText().toString());
        myEdit.putString("English",male.getText().toString());
        myEdit.putString("Malayalam",male.getText().toString());
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        String s2 = sh.getString("number", "");
        String s3 = sh.getString("DOB","");
        String s4 = sh.getString("male","");
        String s5 = sh.getString("female","");
        String s6 = sh.getString("English","");
        String s7 = sh.getString("Malayalam","");
        name.setText(s1);
        number.setText(s2);
        DOB.setText(s3);
    }
}