package com.example.matthew.fitawesome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * DBHelper Class
 *
 * This class sets up the initial database that deals with the login information
 * This also stores the users information and sets it up so that each user
 * has a unique login.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String helperTAG = DBHelper.class.getSimpleName();

    // create DB name
    //private SQLiteDatabase db;
    private static final String DATABASE_NAME = "FitnessAppUser.db";
    private static final int DATABASE_VERSION = 1;
    // create table name
    private static final String TABLE_NAME = "user_table";
    //private static final String COL_1 = "ID";
    private static final String COL_2 = "FIRST_NAME";
    private static final String COL_3 = "LAST_NAME";
    private static final String COL_4 = "EMAIL";
    private static final String COL_5 = "USERNAME";
    private static final String COL_6 = "PASSWORD";

  //  private static  final String TABLE_CREATE = "create table " + TABLE_NAME + "(ID INTEGER " +
   //         "PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, " +
   //         "EMAIL TEXT, PASSWORD TEXT";


    // Non-default Constructor for DBHelper
    public DBHelper(Context context) {
        // 1 is version of the database
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    /**
     * onCreate
     *      This creates the database.
     * @param db
     *
     */
    public void onCreate(SQLiteDatabase db) {
        // creates the database. the below is the commandline, this will run in the database itself.
        // Autocrement adds 1 row as you add records
        db.execSQL("create table user_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT, USERNAME TEXT, PASSWORD TEXT)");
        //this.db = db;
    }

    // onUpgrade helps with the version control of Database
    @Override
    /**
    * onUpgrade
    *    This is used if we wanted to upgrade the database, this will be used everytime
     *    there is a new user on the same device, but NOT on different phones since this is
     *    not stored on the server.
     *
    */
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // if the previous table exists & want to create new delete it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // create new table
        onCreate(db);
    }

    /**
     * Name:  InsertData
     *      This function passes in all the variables for the table of the database. It opens the database,
     *      creates a container to store data and then creates values to store inside the container to
     *      be stored in the DB.
     * @param fName first name
     * @param lName last name
     * @param emailID email
     * @param newPassword password
     * @return true or false
     */
    // Functions we can do with Databases : insert to add data, deleteData, updateData
    public boolean insertData(String fName, String lName, String emailID, String newUser, String newPassword){
        // 1st open the database & then specify what you are going to do with the database
        // can getRead (use when you want to display) OR getWrite
        // to create a db by default only (it is only for checking)
        Log.i(helperTAG," b4 db writable!" ) ;
        SQLiteDatabase db = this.getWritableDatabase();

        Log.i(helperTAG,"after db writable!" ) ;
        // create a container to store the data
        ContentValues contentValues = new ContentValues();

        // check id numbers before assigning an id
    /*    String id_query = "select * from " + TABLE_NAME;
        Cursor id_cursor = db.rawQuery(id_query, null);
        int count = id_cursor.getCount();
*/
        // creating "values" to store inside the container to be stored to DB
        //contentValues.put(COL_1, count);
        contentValues.put(COL_2, fName);
        Log.i(helperTAG," after col_2 inserted!" ) ;
        contentValues.put(COL_3, lName);
        contentValues.put(COL_4, emailID);
        contentValues.put(COL_5, newUser);
        Log.i(helperTAG," Username = " + newUser ) ;
        contentValues.put(COL_6, newPassword);
        Log.i(helperTAG," password = " + newPassword) ;

        // store the new container to the DB, this will return T or F depending if we inserted or not
        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.i(helperTAG," After Result = " + result ) ;

        //this.db = db;
       // id_cursor.close();
        // this will specify if it inserted or not
        if (result == -1)
            return false;
        else
            return true;
    }

    public String searchPassword(String checkUser){

        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "select USERNAME, PASSWORD from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(("select USERNAME, PASSWORD from " + TABLE_NAME), null);
        String searchUname, returnPWD;

        returnPWD = "not found";

        if(cursor.moveToFirst()){
            do{
                searchUname = cursor.getString(0);

                if(searchUname.equals(checkUser)){
                    returnPWD = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }

        cursor.close();

        return returnPWD;
    }
}
