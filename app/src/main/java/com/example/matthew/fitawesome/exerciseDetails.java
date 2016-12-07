package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class exerciseDetails extends AppCompatActivity implements OnClickListener {
    // variables
    private EditText sets;
    private EditText reps;
    private EditText lb;
    private EditText nameExercise;
    private Button addExercise;
    private Button viewWorkout;
    private Button saveExercise;
    // create the DB
    DBHelper ExerciseDB;
        // Menu Options button
    private Button menuhomepageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        // link the variables to the buttons in the XML
        nameExercise =(EditText) findViewById(R.id.input_exName);
        sets = (EditText) findViewById(R.id.input_sets);
        reps = (EditText) findViewById(R.id.input_reps);
        lb = (EditText) findViewById(R.id.input_lb);

        addExercise = (Button) findViewById(R.id.addEx_btn);
        viewWorkout = (Button) findViewById(R.id.view_wout_btn);
        saveExercise = (Button) findViewById(R.id.save_ex_btn);

        // Link to Home Page View (Menu Option Activity)
        menuhomepageview = (Button) findViewById(R.id.menu_option_btn4);

        //set up for buttons
        addExercise.setOnClickListener(this);
        viewWorkout.setOnClickListener(this);
        saveExercise.setOnClickListener(this);

        //create instance of the DB
        ExerciseDB = new DBHelper(this);
    }

    // these functions will send data to the database

    @Override
    public void onClick(View view) {
        if(view == addExercise) {
            // add another new exercise to the day workout --> back to previous activity
            startActivity(new Intent(exerciseDetails.this, enterWorkout.class));
        }
        if(view == viewWorkout) {
            //takes to another activity that will display the workout
            startActivity(new Intent(exerciseDetails.this, workoutView.class));
        }
        if(view == saveExercise) {
            //update & insert the database
            // display  pop up if it saved
        }
        //If selected Return To Home Page button then go to menuoption activity
        if(view == menuhomepageview) {
        // send to exerciseLog activity
        startActivity(new Intent(exerciseDetails.this, menuoption.class));
        }




    }
}
