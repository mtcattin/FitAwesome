package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
*  enterWorkout Class
*
*  This class links the enterWorkout UI to the DB and the variables that are used
*  to save the information to the DB.
*
*/
public class enterWorkout extends AppCompatActivity implements OnClickListener {

    private Button createNewEx;
    private Button viewWorkout;
    private SearchView exerciseDatabase;

    @Override
    /*
    * Name: onCreate
    *
    * This instantiates the variables and allows for the interactive elements to be set up
    *
    * @param savedInstanceState
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_workout);

        createNewEx = (Button) findViewById(R.id.createNewEx_btn);
        viewWorkout = (Button) findViewById(R.id.btn_week2);
        //exerciseDatabase = (SearchView) findViewById(R.id.srchExData);

        //
        createNewEx.setOnClickListener(this);
        viewWorkout.setOnClickListener(this);
    }

    @Override
    /*
    * onClick
    *
    * This function takes uses the variables from above and sets up the actions
    * involved with the various interactive elements.
    *
    * specifically this one sets up either option to the activities they are linked to.
    * @param view
    */
    public void onClick(View view) {
        if(view == createNewEx) {
            // take to the exerciseDetails activity
            startActivity(new Intent(enterWorkout.this, exerciseDetails.class));
        }
        if(view == viewWorkout) {
            // take to the workout view Activity
            startActivity(new Intent(enterWorkout.this, workoutView.class));
        // IF select one of the scrollView items then open the exerciseDetails page
            // also set the exerciseName of that exercise to be the DB value of the "name"

        }
    }
}
