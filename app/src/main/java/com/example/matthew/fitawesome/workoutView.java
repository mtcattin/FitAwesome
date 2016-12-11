package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Class WorkoutView
 *
 * This class displays the workout that is currently stored for the selected day to the user.
 * It also allows the user to delete the workout that is currently entered, or to say they are done
 *  editing the workout.
 */
public class workoutView extends AppCompatActivity implements OnClickListener {

    ExerciseDBHelper exDB;
    private Button completeWorkout;
    private Button clearWorkout;
    private ScrollView workoutDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        completeWorkout = (Button) findViewById(R.id.completeWout_btn);
        clearWorkout = (Button) findViewById(R.id.clrWout_btn);
        workoutDisplay = (ScrollView) findViewById(R.id.list_woutContents);

        // set up the buttons
        completeWorkout.setOnClickListener(this);
        clearWorkout.setOnClickListener(this);

        //Uses the database
        exDB = new ExerciseDBHelper(this);

        viewAllExercises4day();
    }

    @Override
    public void onClick(View view) {
        if(view == completeWorkout) {
            // Go back to the menu Options page
            startActivity(new Intent(workoutView.this, menuoption.class));
        }
        if(view == clearWorkout) {
            // delete currect days workout from the database
        }

    }

    /**
     * Name:  viewAllExercises
     *
     *
     */
    public void viewAllExercises4day(){
        TableLayout wvTableLayout = (TableLayout)findViewById(R.id.wv_tl_scrollview);
        //int count = sameDB.countRowsInDB();
        int count = 10;
        String temp;
        // display number of buttons based on the ros of data in the DB
        for (int row = 0; row < count; row++){
            TableRow wVtableRow = new TableRow(this);
            // setting up properties
            wVtableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            // adds new row inside table
            wvTableLayout.addView(wVtableRow);

            // create a new TextView
            TextView wVtextView = new TextView(this);

            // set text parameters
            wVtextView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT, 3.0f));
            //set text view display
            temp = "text " + row;
            wVtextView.setText(temp);
            wVtableRow.addView(wVtextView);
        }
    }

}
