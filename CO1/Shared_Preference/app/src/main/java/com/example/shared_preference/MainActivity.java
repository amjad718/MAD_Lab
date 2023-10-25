package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText name, number, DOB;
    RadioGroup gender;
    CheckBox english, malayalam;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.nameid);
        number = (EditText) findViewById(R.id.numberid);
        DOB = (EditText) findViewById(R.id.dobid);
        gender = (RadioGroup) findViewById(R.id.radioGroup);
        english = (CheckBox) findViewById(R.id.checkBox);
        malayalam = (CheckBox) findViewById(R.id.checkBox2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", name.getText().toString());
        myEdit.putString("number", number.getText().toString());
        myEdit.putString("DOB", DOB.getText().toString());
        myEdit.putInt("gender", gender.getCheckedRadioButtonId());
        myEdit.putBoolean("English", english.isChecked());
        myEdit.putBoolean("malayalam", malayalam.isChecked());
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        name.setText(sh.getString("name",""));
        number.setText(sh.getString("number", ""));
        DOB.setText(sh.getString("DOB", ""));
        gender.check(sh.getInt("gender", -1));
        english.setChecked(sh.getBoolean("English", false));
        malayalam.setChecked(sh.getBoolean("malayalam", false));
    }
}