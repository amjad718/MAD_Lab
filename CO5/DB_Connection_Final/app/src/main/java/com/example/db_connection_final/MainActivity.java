package com.example.db_connection_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ListView listView;
    DBHelper dbHelper;
    ArrayAdapter<String> adapter;
    ArrayList<String> dataList;
    List<Pair<Integer, String>> dataPairList;
    private int selectedPosition = -1;
    String selectedItem = "";

    public enum Fn {
        INSERT, UPDATE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        listView = findViewById(R.id.list_view);
        dbHelper = new DBHelper(this);
        dataList = new ArrayList<>();

        displayData();

        fab.setOnClickListener( View -> {
            showAlertDialogWithEditText(null, Fn.INSERT);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            selectedItem = (String) parent.getItemAtPosition(position);
            registerForContextMenu(listView);
            openContextMenu(listView);
            return true;
        });

    }

    private void displayData() {
        dataList.clear();
        dataPairList = dbHelper.getAllData();

        for (Pair<Integer, String> pair : dataPairList) {
            dataList.add(pair.second);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
    }

    private void showAlertDialogWithEditText(String name, Fn fn) {
        // Create an EditText programmatically
        final EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);

        if (!TextUtils.isEmpty(name)) {
            editText.setText(selectedItem);
        }

        // Create MaterialAlertDialogBuilder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Enter Text");
        builder.setView(editText);
        builder.setPositiveButton("OK", (dialog, which) -> {
            // Handle positive button click
            switch(fn) {
                case INSERT: {
                    String enteredText = editText.getText().toString();
                    dbHelper.insertData(enteredText);
                    displayData();
                    Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    break;
                }
                case UPDATE: {
                    String enteredText = editText.getText().toString();
                    dbHelper.updateData(dataPairList.get(selectedPosition).first, enteredText);
//                    dataList.set(selectedPosition, enteredText);
                    displayData();
                    Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Handle negative button click or simply dismiss the dialog
            dialog.dismiss();
        });

        // Show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Integer n_id = dataPairList.get(selectedPosition).first;
        String selectedName = dataPairList.get(selectedPosition).second;
        if (item.getItemId() == R.id.item_edit) {
            showAlertDialogWithEditText(selectedName, Fn.UPDATE);
            return true;
        } else if (item.getItemId() == R.id.item_delete) {
            dbHelper.deleteData(n_id);
            dataList.remove(selectedPosition);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}