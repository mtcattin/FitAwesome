package com.example.matthew.fitawesome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * ExerciseDBHelper Class
 *
 * This class sets up the initial database that deals with the exercises and the content of the
 * Users workout that will be stored within the database, this information will be unique for
 * each user.
 */

public class ExerciseDBHelper extends SQLiteOpenHelper {

    private static final String helperExerciseTAG = ExerciseDBHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "UserExercise_log.db";
    public static final String TABLE_NAME = "UserExercise_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "WeekNumber";
    public static final String COL_3 = "WeekDay";
    public static final String COL_4 = "Exercise";
    public static final String COL_5 = "SetNumber";
    public static final String COL_6 = "RepsPerSet";
    public static final String COL_7 = "WeightPerSet";


    // Constructor for DBHelper
    public ExerciseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * Name:  onCreate
     *       This creates the database by using a query statement (exdb.execSQL().
     * This query accepts a list of items (the green items) there are all the columns we want, and
     * have already defined above. It is passed as one large string and each column is identified
     * by the name of the column and the content in the column (Ie:  INTEGER, TEXT, etc.)
     *
     * @param exdb
     */
    @Override
    public void onCreate(SQLiteDatabase exdb) {
        //see function description
        exdb.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, WeekNumber INTEGER, " +
                "WeekDay TEXT, Exercise TEXT, SetNumber INTEGER, RepsPerSet INTEGER, WeightPerSet INTEGER)");
    }

    /**
     * Name: onUpgrade
     *        This does the same thing as the DBHelper onUpgrade
     * @param exdb  (exercise database)
     * @param i     (# of the version)
     * @param i1    (# of the new version)
     */
    @Override
    public void onUpgrade(SQLiteDatabase exdb, int i, int i1) {
        exdb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(exdb);
    }

    /**
     *    Name: updateExerciseData
     *
     *    This inserts data for every row of the database.
     * @param WeekNum
     * @param dayOfWeek
     * @param eX_Name
     * @param newSet
     * @param newRepsPerSet
     * @param newWeightPerSet
     *
     * @return T or F, depending if it was able to insert the data or not
     */
    public boolean updateExerciseData( String WeekNum, String dayOfWeek, String eX_Name,
                                       String newSet, String newRepsPerSet,String newWeightPerSet){
        String identity = "";
        // to create a db by default only (it is only for checnewRepsPerSetking), make sure database is writable
        SQLiteDatabase exdb = this.getWritableDatabase();
        // Create a content value to insert data into each row.
        ContentValues contentValues4x = new ContentValues();
        /* .put inserts specified value in each row. variable name, value in the column(params
        * from above) these should already be available through the table we've created
        */
        contentValues4x.put(COL_1, identity);
        contentValues4x.put(COL_2, WeekNum);
        contentValues4x.put(COL_3, dayOfWeek);
        contentValues4x.put(COL_4, eX_Name);
        contentValues4x.put(COL_5, newSet);
        contentValues4x.put(COL_6, newRepsPerSet);
        contentValues4x.put(COL_7, newWeightPerSet);
        // giving the row a specific ID
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


    public Cursor getFirstRow(){
        SQLiteDatabase exdb = this.getWritableDatabase();
        Cursor res = exdb.rawQuery("select Exercise from "+TABLE_NAME,null);
        return res;
    }
    // Create one to get just the list of exercise names (independent of the week)

    // Create one to get just the weekNum

    // create one to get the day WITHIN the current weekNum

    /**
     * Name: deleteExData
     *
     *    Delete a value from the database, this is intended to allow the user to detele
     *    a specified exercise when they wish to.
     * @param id
     * @return T or F, if it deleted or not
     *
     */
    // deletes an exercise by the ID
    public Integer deleteExData (String id) {
        SQLiteDatabase exdb = this.getWritableDatabase();
        return exdb.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    // get the count of rows in the DB
    public int countRowsInDB(){
        SQLiteDatabase exdb = this.getReadableDatabase();

        Cursor cursor = exdb.rawQuery(("select * from " + TABLE_NAME), null);
        int countRows = cursor.getCount();
        cursor.close();
        return countRows;
    }
} // end of the class



