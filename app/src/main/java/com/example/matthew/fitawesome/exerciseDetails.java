package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    ExerciseDBHelper ExerciseDB;


    // to capture details from previous activity
    String edexName;
    String edweek_Number;
    String edweekDay;

    // get strings from dislpayed values
    String ed_sets;
    String ed_reps;
    String ed_lb;

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
        // set up text fill in link similar to the weeks/days set up finish when Nikhit is done!!
        edexName= getIntent().getStringExtra("ewExercise_Name");
        edweek_Number= getIntent().getStringExtra("ewWeekNumber");
        edweekDay = getIntent().getStringExtra("ewWeekDay");

        nameExercise.setText(edexName);
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
        ExerciseDB = new ExerciseDBHelper(this);
    }

    /**
     * Name:  onClick
     *
     * Set up the buttons to do what we wanted them to do, most of these will send data
     * to the database.
     * @param view onclick options
     */
    @Override
    public void onClick(View view) {
        ed_sets= sets.getText().toString();
        ed_reps = reps.getText().toString();
        ed_lb = lb.getText().toString();

        Intent get2nextActivity;

        if(view == addExercise) {
            // add another new exercise to the day workout --> back to previous activity
            get2nextActivity = new Intent(exerciseDetails.this, enterWorkout.class);

            get2nextActivity.putExtra("weekNUMMM",edweek_Number);
            get2nextActivity.putExtra("weekDayNum",edweekDay);

            startActivity(get2nextActivity);
        }
        if(view == viewWorkout) {
            //takes to workoutView activity that will display the workout
            get2nextActivity = new Intent(exerciseDetails.this, workoutView.class);
            startActivity(get2nextActivity);
        }
        if(view == saveExercise) {
            Boolean isInserted;
            isInserted=ExerciseDB.updateExerciseData(edweek_Number,edweekDay,edexName,ed_sets,ed_reps,ed_lb);
            //update & insert the database
            // display  pop up if it saved to database
            if(isInserted){
                Toast.makeText(exerciseDetails.this, "Exercise saved", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(exerciseDetails.this, "Error saving exercise", Toast.LENGTH_LONG).show();
            }
        }
    }

}
