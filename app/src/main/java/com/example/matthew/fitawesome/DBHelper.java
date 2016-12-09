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
   //debug statement only works in debug mode
    private static final String helperTAG = DBHelper.class.getSimpleName();

    //private SQLiteDatabase db;
    // create DB name
    private static final String DATABASE_NAME = "FitnessAppUser.db";
    // DB version
    private static final int DATABASE_VERSION = 1;
    // create table name
    private static final String TABLE_NAME = "user_table";
    // Below are the data columns
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
     *      This creates the database. The line of code is a commandline that will run in the
     * database it will also autocrement and add 1 row as you add in records. Note this function
     * is set up the same as the onCreate in ExerciseDBHelper, read that description for more
     * details.
     *
     * @param db
     *
     */
    public void onCreate(SQLiteDatabase db) {
        // see function description
        db.execSQL("create table user_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT, USERNAME TEXT, PASSWORD TEXT)");
        //this.db = db;
    }

    @Override
     /**
     * onUpgrade
     *    Helps with Version control
     *    This is used if we wanted to upgrade the database, this will be used everytime
     * there is a new user on the same device, but NOT on different phones since this is
     * not stored on the server.  Used when a new version of the DB needs to be called
     * @param db   (the database itself)
      * @param i    (the new version)
      * @param i1   (the older version)
      * Note these are the same as the onUpgrade for the exerciseDBHelper, the order or
      * which is new and which is old doesn't matter
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

    /**
     * Name:  searchPassword
     *      Searches for the users saved password and returns that password from the database
     * @param checkUser
     * @return password
     */
    public String searchPassword(String checkUser){
        //this lets
        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "select USERNAME, PASSWORD from " + TABLE_NAME;

        // cursor goes by rows and will search only the specified colums (green)
        Cursor cursor = db.rawQuery(("select USERNAME, PASSWORD from " + TABLE_NAME), null);
        String searchUname, returnPWD;

        returnPWD = "not found";
        // if the row exists it goes to the first one
        if(cursor.moveToFirst()){
            do{ // checking to see if the value in the 1st column
                searchUname = cursor.getString(0);
                // if the column matches the entered login in name
                if(searchUname.equals(checkUser)){
                    returnPWD = cursor.getString(1);
                    break;
                }
            // if there is an option to continue, go to the next row
            }while(cursor.moveToNext());
        }

        cursor.close();

        return returnPWD;
    }
}
