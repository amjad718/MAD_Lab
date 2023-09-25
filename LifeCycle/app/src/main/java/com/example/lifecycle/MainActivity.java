package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CREATE", "onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("START","onStart Invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOP","onStop Invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DESTROY","onDestroy Invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PAUSE","onPause Invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("RESUME","onResume Invoked");
    }
}