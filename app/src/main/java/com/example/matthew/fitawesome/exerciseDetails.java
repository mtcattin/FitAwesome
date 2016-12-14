package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class exerciseDetails extends AppCompatActivity implements View.OnClickListener {

    private static final String edTAG = exerciseDetails.class.getSimpleName();

    // variables
    private EditText sets;
    private EditText reps;
    private EditText lb;
    private EditText nameExercise;
    private Button addExercise;
    private Button viewWorkout;
    private Button saveExercise;
    private String userNameED;
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
     * @param savedInstanceState no clue
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        // link the variables to the buttons in the XML
        nameExercise =(EditText) findViewById(R.id.input_exNameED);

        // set up text fill in link similar to the weeks/days set up finish when Nikhit is done!!
        edexName= getIntent().getStringExtra("ewExercise_Name");
        Log.i(edTAG,"edexName is " + edexName);

        edweek_Number= getIntent().getStringExtra("ewWeekNumber");
        Log.i(edTAG,"edweek_Number is " + edweek_Number);

        edweekDay = getIntent().getStringExtra("ewWeekDay");
        Log.i(edTAG,"edweek_Number " + edweekDay);

        userNameED = getIntent().getStringExtra("ewUserName");
        Log.i(edTAG,"eduserName " + userNameED);

        nameExercise.setText(edexName);
        sets = (EditText) findViewById(R.id.input_sets);
        reps = (EditText) findViewById(R.id.input_repsED);
        lb = (EditText) findViewById(R.id.input_lbED);

        addExercise = (Button) findViewById(R.id.addEx_btnED);
        viewWorkout = (Button) findViewById(R.id.view_wout_btnED);
        saveExercise = (Button) findViewById(R.id.save_ex_btnED);

        //set up for buttons
        addExercise.setOnClickListener(this);
        viewWorkout.setOnClickListener( this);
        saveExercise.setOnClickListener( this);

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


        if(view == addExercise) {
            // add another new exercise to the day workout --> back to previous activity
            Intent get2nextActivity = new Intent(exerciseDetails.this, enterWorkout.class);

            // String identity matches that of WeedDay to avoid creating more variables
            get2nextActivity.putExtra("weekNumWD",edweek_Number);
            get2nextActivity.putExtra("selectedDayWD",edweekDay);
            get2nextActivity.putExtra("userloginWD",userNameED);
            startActivity(get2nextActivity);
        }
        if(view == viewWorkout) {
            //takes to workoutView activity that will display the day's workout list
            Intent get2nextActivity = new Intent(exerciseDetails.this, workoutView.class);
            get2nextActivity.putExtra("weekNumWD",edweek_Number);
            get2nextActivity.putExtra("selectedDayWD",edweekDay);
            get2nextActivity.putExtra("userloginWD",userNameED);
            startActivity(get2nextActivity);

        }
        if(view == saveExercise) {
            Boolean isInserted;
            edexName = nameExercise.getText().toString();
            Log.i(edTAG,"In Save Ex edweek_Number is " + edweek_Number);
            Log.i(edTAG,"In Save Ex edweekDay is " + edweekDay);
            Log.i(edTAG,"In Save Ex edexName is " + edexName);

            isInserted=ExerciseDB.updateExerciseData(edweek_Number,edweekDay,edexName,ed_sets,ed_reps,ed_lb);
            //update & insert the database
            // display  pop up if it saved to database
            if(isInserted){
                Toast.makeText(exerciseDetails.this, "Exercise saved", Toast.LENGTH_LONG).show();
                clearInputText();
            } else {
                Toast.makeText(exerciseDetails.this, "Error saving exercise", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Private function that resets display values
     */
    private void clearInputText(){
        nameExercise.setText("");
        sets.setText("");
        reps.setText("");
        lb.setText("");
    }

}
