package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numb1, numb2, ress;
    Button btnadd, btnsub, btnmul, btndiv;
    float n1,n2,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numb1 = (EditText) findViewById(R.id.num1);
        numb2 = (EditText) findViewById(R.id.num2);
        ress = (EditText) findViewById(R.id.res);
        btnadd = (Button) findViewById(R.id.addbtn);
        btnsub = (Button) findViewById(R.id.subbtn);
        btnmul = (Button) findViewById(R.id.mulbtn);
        btndiv = (Button) findViewById(R.id.divbtn);
    }
    public void add(View view){
        n1 = Float.parseFloat(String.valueOf(numb1.getText()));
        n2 = Float.parseFloat(String.valueOf(numb2.getText()));
        result = n1+n2;
        ress.setText(Float.toString(result));
        
    }
    public void sub(View view){
        n1 = Float.parseFloat(String.valueOf(numb1.getText()));
        n2 = Float.parseFloat(String.valueOf(numb2.getText()));
        result = n1-n2;
        ress.setText(Float.toString(result));
    }
    public void mul(View view){
        n1 = Float.parseFloat(String.valueOf(numb1.getText()));
        n2 = Float.parseFloat(String.valueOf(numb2.getText()));
        result = n1*n2;
        ress.setText(Float.toString(result));
    }
    public void div(View view){
        n1 = Float.parseFloat(String.valueOf(numb1.getText()));
        n2 = Float.parseFloat(String.valueOf(numb2.getText()));
        result = n1/n2;
        ress.setText(Float.toString(result));
    }
    public void reset(View view){
        numb1.setText("");
        numb2.setText("");
        ress.setText("");
    }
}