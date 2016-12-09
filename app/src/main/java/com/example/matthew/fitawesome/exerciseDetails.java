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

    /**
     * Name: onCreate
     *
     * This sets it up so that the variables are linked to the XML, and the various buttons,
     * editTexts, etc. are all linked up as well. We also create an instance of the Database here.
     *
     * @param savedInstanceState
     */
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

        //set up for buttons
        addExercise.setOnClickListener(this);
        viewWorkout.setOnClickListener(this);
        saveExercise.setOnClickListener(this);

        //create instance of the DB
        ExerciseDB = new DBHelper(this);
    }

    /**
     * Name:  onClick
     *
     * Set up the buttons to do what we wanted them to do, most of these will send data
     * to the database.
     * @param view
     */
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
                // toast statement
        }
    }
}
