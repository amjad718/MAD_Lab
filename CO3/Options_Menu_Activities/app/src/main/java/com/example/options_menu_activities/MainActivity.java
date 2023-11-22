package com.example.options_menu_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.message) {
            Toast.makeText(getApplicationContext(), "Shows share icon", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.picture) {
            Toast.makeText(getApplicationContext(), "Shows image icon", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.mode) {
            Toast.makeText(getApplicationContext(), "Shows call icon", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.about) {
//            Toast.makeText(getApplicationContext(), "calculator menu", Toast.LENGTH_SHORT).show();
            Intent i2 = new Intent(this, MainActivity2.class);
            startActivity(i2);
            return true;
        } else if (itemId == R.id.exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}