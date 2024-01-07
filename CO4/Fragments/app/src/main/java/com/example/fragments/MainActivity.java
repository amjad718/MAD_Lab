package com.example.fragments;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    Button fragA, fragB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.framelayout);
        fragA = findViewById(R.id.fragA);
        fragB = findViewById(R.id.fragB);
//        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new FragmentA()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new FragmentA()).commit();
        fragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new FragmentA()).commit();
            }
        });
        fragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new FragmentB()).commit();
            }
        });
    }
}