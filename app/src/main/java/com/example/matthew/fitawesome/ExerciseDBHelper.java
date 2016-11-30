package com.example.matthew.fitawesome;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nix on 11/14/2016.
 */

 /* In this class it sets up the SQLite database for the application
 */
public class ExerciseDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserExercise_log.db";
    public static final String TABLE_NAME = "UserExercise_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Week";
    public static final String COL_3 = "WeekDay";
    public static final String COL_4 = "Exercise";
    public static final String COL_5 = "Set1";
    public static final String COL_6 = "Set2";
    public static final String COL_7 = "Set3";
    public static final String COL_8 = "RepsPerSet1";
    public static final String COL_9 = "RepsPerSet2";
    public static final String COL_10 = "RepsPerSet3";
    public static final String COL_11 = "Weight1";
    public static final String COL_12 = "Weight2";
    public static final String COL_13 = "Wegiht3";

    // Constructor for DBHelper
    public ExerciseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase exdb) {
        exdb.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Week INTEGER, " +
                "WeekDay TEXT, Exercise TEXT, SET1 INTEGER, SET2 INTEGER, SET3 INTEGER, RepsPerSet1 " +
                "INTEGER, RepsPerSet2 INTEGER, RepsPerSet3 INTEGER, Weight1 INTEGER, Weight2 " +
                "INTEGER, Weight3 INTEGER");
    }

    @Override
    public void onUpgrade(SQLiteDatabase exdb, int i, int i1) {
        exdb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(exdb);
    }

    public boolean updateExerciseData(String identity, String WeekNum, String dayOfWeek, String eX_Name, String newSet1,
                              String newSet2, String newSet3, String newRepsPerSet1, String
                              newRepsPerSet2, String newRepsPerSet3, String newWeight1,
                              String newWeight2, String newWeight3){

        // to create a db by default only (it is only for checking)
        SQLiteDatabase exdb = this.getWritableDatabase();
        ContentValues contentValues4x = new ContentValues();
        contentValues4x.put(COL_1, identity);
        contentValues4x.put(COL_2, WeekNum);
        contentValues4x.put(COL_3, dayOfWeek);
        contentValues4x.put(COL_4, eX_Name);
        contentValues4x.put(COL_5, newSet1);
        contentValues4x.put(COL_6, newSet2);
        contentValues4x.put(COL_7, newSet3);
        contentValues4x.put(COL_8, newRepsPerSet1);
        contentValues4x.put(COL_9, newRepsPerSet2);
        contentValues4x.put(COL_10, newRepsPerSet3);
        contentValues4x.put(COL_11, newWeight1);
        contentValues4x.put(COL_12, newWeight2);
        contentValues4x.put(COL_13, newWeight3);
        exdb.update(TABLE_NAME, contentValues4x, "ID = ?", new String[] { identity });
        return true;
    }

// displays everything in the DB
/*    public Cursor getAllExData() {
        SQLiteDatabase exdb = this.getWritableDatabase();
        Cursor res = exdb.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
*/

    // Create one to get just the list of exercise names (independent of the week)

    // Create one to get just the weekNum

    // create one to get the day WITHIN the current weekNum

    // deletes an exercise
    public Integer deleteExData (String id) {
        SQLiteDatabase exdb = this.getWritableDatabase();
        return exdb.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
} // end of the class



