package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
*   CreateAnAccount
*
*   This class sets up the data that will be stored for each user on the database
*
*/
public class CreateAnAccount extends AppCompatActivity {
    DBHelper mydb;

    @Override
    /*
    * Name: onCreate
    *
    * This function links the UI for the account creation to the interactive elements
    *  instaniating the variables in the createAnAccount class.
    *
    *  @param savedInstanceState
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);

        mydb = new DBHelper(this);

        //btn_CreateAccount = (Button) findViewById(R.id.btn_CAA);


    }

    /*
    * Name: AddData
    *
    * This function attempts sets up the create an account. This function checks to make sure the
    * user has entered a correct password. It checks to see if passwords are empty, if they
    * don't match and also checks to make sure that the data is entered into the database if they
    * do enter the data correctly. Once they have successfully set up an account it will also
    * redirect the user back to the Login page.
    *
    * @param view
    */
 /*   public void AddData(){
        btn_CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password1 = PWD1.getText().toString();
                String password2 = PWD2.getText().toString();

                // check password match
                do {
                    if ((password1.equals("")) || (password2.equals(""))) {
                        Toast.makeText(CreateAnAccount.this, "passwords are empty", Toast.LENGTH_LONG).show();

                        // startActivity(new Intent(CreateAnAccount.this, MainMenu.class));
                    }
                    else {
                        Toast.makeText(CreateAnAccount.this, "passwords do not match!", Toast.LENGTH_LONG).show();
                    }
                    //clearPasswords();
                }while (!password1.equals(password2));


                boolean isInserted = mydb.insertData(editFirst.getText().toString(),
                        editLast.getText().toString(), editEmail.getText().toString(),
                        usernameET.getText().toString(), PWD1.getText().toString());
            if(isInserted){
                Toast.makeText(CreateAnAccount.this, "Data inserted", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(CreateAnAccount.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
                //mydb.close();

                // Go back to main menu
                startActivity(new Intent(CreateAnAccount.this, MainMenu.class));
            }
        });
    }
*/

    public void onCreateButtonClick(View view){
        boolean isInserted;

        EditText editFirst = (EditText) findViewById(R.id.First_Name);
        EditText editLast = (EditText) findViewById(R.id.Last_Name);
        EditText editEmail = (EditText) findViewById(R.id.email);
        EditText PWD1 = (EditText) findViewById(R.id.password1ET);
        EditText PWD2 = (EditText) findViewById(R.id.password2ET);
        EditText usernameET = (EditText) findViewById(R.id.UserNameIDET);

        if (view.getId() == R.id.btn_CAA){

            String password1 = PWD1.getText().toString();
            String password2 = PWD2.getText().toString();

            // check password match
            if (!password1.equals(password2) || (password1.equals("")) || (password2.equals(""))){

                    Toast.makeText(CreateAnAccount.this, "Passwords do not match!", Toast.LENGTH_LONG).show();
                }
            else {
                isInserted = mydb.insertData(editFirst.getText().toString(),
                        editLast.getText().toString(), editEmail.getText().toString(),
                        usernameET.getText().toString(), PWD1.getText().toString());
                if(isInserted){
                    Toast.makeText(CreateAnAccount.this, "Data inserted", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(CreateAnAccount.this, MainMenu.class));

                } else {
                    Toast.makeText(CreateAnAccount.this, "Data not inserted", Toast.LENGTH_LONG).show();
                }
            }
        }

    }


    /*
   * Name: clearPasswords
   *
   * This function Clears passwords that do not matched when entered
   *
   *  @param none
   */
 /*   private void clearPasswords(){
        PWD1.setText("");
        PWD2.setText("");
    }
 */
}
