package com.example.denchiklut.todo.db;

import android.provider.BaseColumns;

public final class NotesContract {

    public NotesContract() {
    }

    public static final String DB_NAME = "notepad.db";
    public static final int DB_VERSION = 1;

    public static final String[] CREATE_DATABASE_QUARES = {
            Notes.CREATE_TABLE,
            Notes.CREATE_UPDATED_TS_INDEX
    };

    public static abstract class Notes implements BaseColumns {

        public static final String TABLE_NAME =  "notes";

        public static final String COLUMN_TITLE =  "title";
        public static final String COLUMN_NOTE =  "note";
        public static final String COLUMN_CREATED_TS =  "created_ts";
        public static final String COLUMN_UPDATED_TS =  "updatedTs";

        public static final String CREATE_TABLE = String.format("CREATE TABLE %s" +
                            "(%s INTEGER PRIMARY KEY, " +
                            "%s TEXT NOT NULL " +
                            "%s TEXT NOT NULL " +
                            "%s INTEGER " +
                            "%s INTEGER);",
                TABLE_NAME,
                COLUMN_TITLE,
                COLUMN_NOTE,
                COLUMN_CREATED_TS,
                COLUMN_UPDATED_TS);

        public static final String CREATE_UPDATED_TS_INDEX = String.format("CREATE INDEX updated_ts_index ON %s (%s);",
                TABLE_NAME, COLUMN_UPDATED_TS);

    }

}
