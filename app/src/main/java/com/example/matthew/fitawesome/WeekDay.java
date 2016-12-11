package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Class Week Day
 *
 * Sets up the Week days and allows the user to choose which day of the week
 * they want to access. Once a day button is implemented it then accesses the enterWorkout Activity
 */

public class WeekDay extends AppCompatActivity {

    private String weekNumSTR;
/*    private Button sunday;
    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;
 */
    private EditText weekNum;

    /**
     * name: onCreate
     *    This sets up the various links as well as accepts the weekNum that will be eventually
     *    passed into the database, at this point though it has not been.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_day);
        //
        weekNumSTR = getIntent().getStringExtra("exerciseLogWeek#");
        weekNum = (EditText) findViewById(R.id.weekNumber);
        weekNum.setText(weekNumSTR);

        // link the buttons to the variables
 /*       sunday = (Button) findViewById(R.id.sun_btn);
        monday = (Button) findViewById(R.id.mon_btn);
        tuesday = (Button) findViewById(R.id.tues_btn);
        wednesday = (Button) findViewById(R.id.wed_btn);
        thursday = (Button) findViewById(R.id.thurs_btn);
        friday = (Button) findViewById(R.id.fri_btn);
        saturday = (Button) findViewById(R.id.sat_btn);

        // set up the buttons for activity
        sunday.setOnClickListener(this);
        monday.setOnClickListener(this);
        tuesday.setOnClickListener(this);
        wednesday.setOnClickListener(this);
        thursday.setOnClickListener(this);
        friday.setOnClickListener(this);
        saturday.setOnClickListener(this);
  */
    }

    /**
     * name:  onClick
     *
     * This sets up the various days which the user will choose from and pass off both the week day
     * they selected as well as the previously selected week number.
     * @param view
     */
        //@Override
        public void onClick (View view){
           String selectedDay ="";

            if ((view.getId() == R.id.sun_btn) || (view.getId() == R.id.mon_btn) ||
                    (view.getId() == R.id.tues_btn) || (view.getId() == R.id.wed_btn)
                    || (view.getId() == R.id.thurs_btn) || (view.getId() == R.id.fri_btn) ||
                    (view.getId() == R.id.sat_btn)) {
                // get the day that has been selected
                selectedDay = view.toString();
                // pass the value to the next screen
                Intent nextActivityEnterWOUT = new Intent(WeekDay.this, enterWorkout.class);
                // to handoff the variable to the next activity, need to pass a unique string value
                nextActivityEnterWOUT.putExtra("weekDayNum",selectedDay);

                // also need to handoff the weekNumber  they selected on the last activity
                nextActivityEnterWOUT.putExtra("weekNUMMM",weekNumSTR);
                startActivity(nextActivityEnterWOUT);
            }
        }
}
