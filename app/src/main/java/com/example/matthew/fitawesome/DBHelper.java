package com.example.matthew.fitawesome;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nix on 11/2/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    // create DB name
    public static final String DATABASE_NAME = "FitnessAppUser.db";
    // create table name
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "LAST_NAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PASSWORD";

    // Non-default Constructor for DBHelper
    public DBHelper(Context context) {
        // 1 is version of the database
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creates the database. the below is the commandline, this will run in the database itself.
        // Autocrement adds 1 row as you add records
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT, PASSWORD TEXT");
    }

    // onUpgrade helps with the version control of Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // if the previous table exists & want to create new delete it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // create new table
        onCreate(db);
    }


    // Functions we can do with Databases : insert to add data, deleteData, updateData
    // pass all the variables for the table (See above)
    public boolean insertData(String fName, String lName, String emailID, String newPassword ){
        // 1st open the database & then specify what you are going to do with the database
        // can getRead (use when you want to display) OR getWrite
        // to create a db by default only (it is only for checking)
        SQLiteDatabase db = this.getWritableDatabase();
        // create a container to store the data
        ContentValues contentValues = new ContentValues();
        // creating "values" to store inside the container to be stored to DB
        contentValues.put(COL_2, fName);
        contentValues.put(COL_3, lName);
        contentValues.put(COL_4, emailID);
        contentValues.put(COL_5, newPassword);
        // store the new container to the DB, this will return T or F depending if we inserted or not
        long result = db.insert(TABLE_NAME, null, contentValues);
        // this will specify if it inserted or not
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
