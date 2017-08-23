/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.attendence.android.attendanceapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.attendence.android.attendanceapp.data.StudentContract.StudentEntry;


public class StudentDbHelper extends SQLiteOpenHelper {

    // The name of the database
    private static final String DATABASE_NAME = "studentsDb.db";

    // If you change the database schema, you must increment the database version
    private static final int VERSION = 1;


    // Constructor
    StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    /**
     * Called when the students database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create students table (careful to follow SQL formatting rules)
        final String CREATE_TABLE = "CREATE TABLE "  + StudentEntry.TABLE_NAME + " (" +
                        StudentEntry._ID                + " INTEGER PRIMARY KEY, " +
                        StudentEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                        StudentEntry.COLUMN_PRIORITY    + " INTEGER NOT NULL);";

        db.execSQL(CREATE_TABLE);
    }


    /**
     * This method discards the old table of data and calls onCreate to recreate a new one.
     * This only occurs when the version number for this database (DATABASE_VERSION) is incremented.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StudentEntry.TABLE_NAME);
        onCreate(db);
    }
}
