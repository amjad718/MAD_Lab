package com.example.spinner_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] subject = {"Select Subject","English","Maths","Arabic","Tamil","Malayalam"};
    EditText username,dobvar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editTextText4);
        dobvar = (EditText) findViewById(R.id.editTextText5);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, subject);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
    }

    public void onItemSelected(AdapterView<?> adapterView,View view, int i, long l){
        TextView txt = (TextView) view;
        String text = txt.getText().toString();
//        Toast.makeText(this, subject[0], Toast.LENGTH_SHORT).show();

        if (!(text == subject[0])){
            Toast.makeText(this, "You have selected "+text, Toast.LENGTH_SHORT).show();
        }
    }

    public void subFunc(View view){
        TextView txt = (TextView) view;
        String text = txt.getText().toString();
        String user = username.getText().toString();
        String dob = dobvar.getText().toString();
//        if (!text.equals(subject[0])) {
//            Intent send = new Intent(MainActivity.this, MainActivity2.class);
//            send.putExtra("course",text);
//            send.putExtra("username",user);
//            send.putExtra("date",dob);
//            startActivity(send);
//        }
//        else if(text.equals("Select Subject")){
//            Toast.makeText(this, "Select a valid course", Toast.LENGTH_SHORT).show();
//        }
        if (!(text == subject[0])){
//            Intent send = new Intent(MainActivity.this, MainActivity2.class);
//            send.putExtra("course",text);
//            send.putExtra("username",user);
//            send.putExtra("date",dob);
//            startActivity(send);
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            Log.e("toast",text);
        }
        else{
            Toast.makeText(this, "Select a valid course", Toast.LENGTH_SHORT).show();
        }
    }

    public void onNothingSelected(AdapterView<?> parent){

    }
}