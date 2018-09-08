package com.example.denchiklut.todo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.denchiklut.todo.db.NotesContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert();
        select();
    }

    private void insert() {
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NotesContract.Notes.COLUMN_TITLE, "First title");
        contentValues.put(NotesContract.Notes.COLUMN_NOTE, "Some text..");
        contentValues.put(NotesContract.Notes.COLUMN_CREATED_TS, System.currentTimeMillis());
        contentValues.put(NotesContract.Notes.COLUMN_UPDATED_TS, System.currentTimeMillis());

        Uri uri = contentResolver.insert(NotesContract.Notes.URI, contentValues);
        Log.i("Test", "URI: " + uri);
    }

    private void select() {
        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(
                NotesContract.Notes.URI,
                NotesContract.Notes.LIST_PROJECTION,
                null,
                null,
                null
        );

        Log.i("Test", "Count: " + cursor.getCount());
        cursor.close();


    }
}
