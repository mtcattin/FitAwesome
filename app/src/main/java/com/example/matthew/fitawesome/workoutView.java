package com.example.matthew.fitawesome;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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

    // Debugger
    private static final String wvTAG = menuoption.class.getSimpleName();

    ExerciseDBHelper exDB;

    Button completeWorkout;

    String usernameWV;
    String weekDayWV;
    String weekNumWV;

    //private ScrollView workoutDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        completeWorkout = (Button) findViewById(R.id.completeWout_btn);
        //clearWorkout = (Button) findViewById(R.id.clrWout_btn);
        //  workoutDisplay = (ScrollView) findViewById(R.id.list_woutContents);

        // receive Strings from WeekDay or Exercise Details
        usernameWV = getIntent().getStringExtra("userloginWD");
        weekDayWV = getIntent().getStringExtra("selectedDayWD");
        weekNumWV = getIntent().getStringExtra("weekNumWD");

        Log.i(wvTAG,"WV username RCVD" + usernameWV);
        Log.i(wvTAG,"WV weekday RCVD" + weekDayWV);
        Log.i(wvTAG,"WV week# RCVD" + weekNumWV);

        // set up the buttons
        completeWorkout.setOnClickListener(this);

        //Uses the database
        exDB = new ExerciseDBHelper(this);

        viewAllExercises4day();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.completeWout_btn) {
            // Go back to the menu Options page
            startActivity(new Intent(workoutView.this, menuoption.class).putExtra("usernamefromMM", usernameWV));
        }

    }

    /**
     * Name:  viewAllExercises
     */
    public void viewAllExercises4day() {
        TableLayout wvTableLayout = (TableLayout) findViewById(R.id.wv_tl_scrollview);
        wvTableLayout.setStretchAllColumns(true);
        int count = exDB.countRowsInDB();

        Cursor cursordb = exDB.getRowValues(weekNumWV, weekDayWV);

        Log.i(wvTAG,"In WV count is " + count);
        String temp, temp2, temp3, temp4;

        // display number of buttons based on the rows of data in the DB
        cursordb.moveToFirst();

        for (int row = 0; row < count; row++) {

            TableRow wVtableRow = new TableRow(this);

            wVtableRow.setGravity(Gravity.LEFT);

            // setting up properties
            wVtableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT, 1.0f));

            // adds new row inside table
            wvTableLayout.addView(wVtableRow);

            // converting cursor to string values
            temp = cursordb.getString(0);
            temp2 = cursordb.getString(1);
            temp3 = cursordb.getString(2);
            temp4 = cursordb.getString(3);

            // create a new TextView for exercise name
            TextView wVtextView1 = new TextView(this);
            wVtextView1.setGravity(Gravity.LEFT);
            //wVtextView1.setMaxWidth(20);
            wVtextView1.setText(temp);

            // create a new TextView for set number
            TextView wVtextView2 = new TextView(this);
            wVtextView2.setGravity(Gravity.LEFT);
            wVtextView2.setText(temp2);

            // create a new TextView for Reps
            TextView wVtextView3 = new TextView(this);
            wVtextView3.setGravity(Gravity.LEFT);
            wVtextView3.setText(temp3);

            // create a new TextView for Weight used
            TextView wVtextView4 = new TextView(this);
            wVtextView4.setGravity(Gravity.LEFT);
            wVtextView4.setText(temp4);

            Log.i(wvTAG,"In WV for loop row value is  temp1 count is " + temp);
            Log.i(wvTAG,"In WV for loop row value is  temp2 count is " + temp2);
            Log.i(wvTAG,"In WV for loop row value is  temp3 count is " + temp3);
            Log.i(wvTAG,"In WV for loop row value is  temp4 count is " + temp4);

            //check text view display
            temp = temp+" " + temp2+" " + temp3+" " + temp4;
            Log.i(wvTAG,"In WV for loop new LINE value is  temp4 count is " + temp);

            wVtextView1.setTextSize(25);
            wVtextView2.setTextSize(25);
            wVtextView3.setTextSize(25);
            wVtextView4.setTextSize(25);


            wVtableRow.addView(wVtextView1);
            wVtableRow.addView(wVtextView2);
            wVtableRow.addView(wVtextView3);
            wVtableRow.addView(wVtextView4);

            // go to next row
            cursordb.moveToNext();

        }
        cursordb.close();
    }
}
