package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Class Main Menu
 *
 * This is the main page. This class handles mostly the login in but also directs the user
 *  to be able to create an account as well.
 */

public class MainMenu extends AppCompatActivity {
// this is what the debugger string is looking for(see below)
    private static final String TAG = MainMenu.class.getSimpleName();

    private EditText userName;
    private EditText password;
    private DBHelper myDB;



    /**
     * Name: onCreate
     *
     *     This deals with creating an instance of the database and also sets up the
     *     edit Text fields.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // calls the constructor class (creates an instance and the database)
        myDB = new DBHelper(this);

        userName = (EditText) findViewById(R.id.userNameMM);
        password = (EditText) findViewById(R.id.passwordMM);
        // debug statement   i = information, look for all other Log.i statements
        Log.i(TAG,"OnCreate username " + userName.getText().toString() ) ;
    }
    // predefined function by android studio
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }
    // predefined function by android studio
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Name:  onButtonClick
     *
     *    This set ups the main screen buttons (login & create an account).
     * It also deals with converting the username and password to a string so it can be matched in
     * the DB. It also checks that an entered password matches the password that has been stored
     * within the database.
     * @param view
     */
    public void onButtonClick(View view){
        if (view.getId()== R.id.BtnSignIn){
            //converts the username into a string
            String userLogin = userName.getText().toString();
            //error statement to see if user values are correct or wrong (all Log.i comments)
            Log.i(TAG," MM Username = " + userName ) ;
            // convert password to string
            String userPassword = password.getText().toString();
            Log.i(TAG," MM User Password = " + userPassword ) ;
            // searchPassword returns the correct username password from the DB
            String passwordReturned = myDB.searchPassword(userLogin);
            Log.i(TAG," MM Received Password = " + passwordReturned ) ;
            // Checks if the entered password matches the DB password, otherwise it won't proceed
            if(userPassword.equals(passwordReturned)) {
                Log.i(TAG," When passwords equal in loop") ;
                // open the next activity
                Intent nextActivity1 = new Intent(MainMenu.this, menuoption.class);
                nextActivity1.putExtra("usernamefromMM", userLogin);
                startActivity(nextActivity1);
            }
            else{ // display message
                Toast.makeText(MainMenu.this, "username or password does not match", Toast.LENGTH_LONG).show();
            }
        }
        if (view.getId()== R.id.BtnCreateAccount) {
            Intent nextActivity = new Intent(MainMenu.this, CreateAnAccount.class);
            startActivity(nextActivity);
        }
    }

}
