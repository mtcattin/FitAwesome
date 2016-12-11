package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    private EditText editFirst, editLast, editEmail, PWD1, PWD2, usernameET;
    private Button btn_CreateAccount;

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
        editFirst = (EditText) findViewById(R.id.First_Name);
        editLast = (EditText) findViewById(R.id.Last_Name);
        editEmail = (EditText) findViewById(R.id.email);
        PWD1 = (EditText) findViewById(R.id.password1ET);
        PWD2 = (EditText) findViewById(R.id.password2ET);
        usernameET = (EditText) findViewById(R.id.UserNameIDET);
        btn_CreateAccount = (Button) findViewById(R.id.btn_CAA);
        // insert the details into database
        AddData();
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
    public void AddData(){
        btn_CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password1 = PWD1.getText().toString();
                String password2 = PWD2.getText().toString();

                // check password match
                if((password1.equals(""))||(password2.equals(""))){
                    Toast.makeText(CreateAnAccount.this, "passwords are empty", Toast.LENGTH_LONG).show();
                  // clearPasswords();
                  // startActivity(new Intent(CreateAnAccount.this, MainMenu.class));
                }
                else if (!password1.equals(password2)){
                    Toast.makeText(CreateAnAccount.this, "passwords do not match!", Toast.LENGTH_LONG).show();
                }

                boolean isInserted = mydb.insertData(editFirst.getText().toString(),
                        editLast.getText().toString(), editEmail.getText().toString(),
                        usernameET.getText().toString(), PWD1.getText().toString());
            if(isInserted == true){
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

    /*
   * Name: clearPasswords
   *
   * This function Clears passwords that do not matched when entered
   *
   *  @param none
   */
    private void clearPasswords(){
        PWD1.setText("");
        PWD2.setText("");
    }
}
