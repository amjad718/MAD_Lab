package com.example.db_connection_final;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    // Database information
    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    private static final String TABLE_NAME = "my_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    // Add more columns as needed

    // Create table query
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT" +
                    // Add more columns as needed
                    ")";

    // Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create the database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    // Upgrade the database if the version is increased
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop existing table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create table again
        onCreate(db);
    }

    // CRUD operations

    // Insert a new record
    public long insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        // Add more values as needed

        // Insert the new row
        long id = db.insert(TABLE_NAME, null, values);

        // Close the database connection
        db.close();

        // Return the id of the inserted row
        return id;
    }
    public List<Pair<Integer, String>> getAllData() {
        List<Pair<Integer, String>> nameList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                nameList.add(new Pair<>(id, name));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return nameList;
    }

    // Update a record
    public int updateData(long id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        // Add more values as needed

        // Update the row
        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});

        // Close the database connection
        db.close();

        // Return the number of rows affected
        return rowsAffected;
    }

    // Delete a record
    public int deleteData(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete the row
        int rowsAffected = db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});

        // Close the database connection
        db.close();

        // Return the number of rows affected
        return rowsAffected;
    }
}