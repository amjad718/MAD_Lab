package com.example.new_facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText user,pass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

    }

    public void subBtn(View view){
        Intent send = new Intent(MainActivity.this, MainActivity2.class);
        String str= user.getText().toString();
        if(!pass.getText().toString().equals("Admin")){
            Toast.makeText(this, "There is no account with this username and password", Toast.LENGTH_SHORT).show();
        }
        else{
            send.putExtra("username",str);
            startActivity(send);
        }
    }
}