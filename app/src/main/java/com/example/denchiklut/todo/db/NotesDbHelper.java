package com.example.denchiklut.todo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDbHelper extends SQLiteOpenHelper {

    public NotesDbHelper(Context context) {
        super(context, NotesContract.DB_NAME, null, NotesContract.DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String query: NotesContract.CREATE_DATABASE_QUARES) {
            sqLiteDatabase.execSQL(query);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
