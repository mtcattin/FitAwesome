package com.example.matthew.fitawesome;

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
    private EditText editFirst, editLast, editEmail, editPWD, verifyPWD;
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

        editFirst = (EditText) findViewById(R.id.First_Name);
        editLast = (EditText) findViewById(R.id.Last_Name);
        editEmail = (EditText) findViewById(R.id.email);
        editPWD = (EditText) findViewById(R.id.password);
        verifyPWD = (EditText) findViewById(R.id.Verify_password);
        btn_CreateAccount = (Button) findViewById(R.id.btn_week4);
        AddData();
    }

    /*
    * Name: AddData
    *
    * This function attempts to input the data into the DB and will display an error if
    * it succeeds or fails to do so. 
    */
    public void AddData(){
        btn_CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted = mydb.insertData(editFirst.getText().toString(), editLast.getText().toString(), editEmail.getText().toString(), editPWD.getText().toString());
            if(isInserted == true){
                Toast.makeText(CreateAnAccount.this, "Data inserted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(CreateAnAccount.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
            }
        });
    }

}
