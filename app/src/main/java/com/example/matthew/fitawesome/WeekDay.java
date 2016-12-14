package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Class Week Day
 *
 * Sets up the Week days and allows the user to choose which day of the week
 * they want to access. Once a day button is implemented it then accesses the enterWorkout Activity
 */

public class WeekDay extends AppCompatActivity implements OnClickListener {

    // this is what the debugger string is looking for(see below)
    private static final String wDTAG = WeekDay.class.getSimpleName();

    // to receive strings from exercise log
    private String userLoginWD;
    String weekNumSTR;
    private EditText weekNumWD;

    // for buttons displayed in this activity
    private Button sunday;
    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;



    /**
     * name: onCreate
     *    This sets up the various links as well as accepts the weekNum that will be eventually
     *    passed into the database, at this point though it has not been.
     *
     * @param savedInstanceState no clue
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_day);

        // receive string from exercise log
        weekNumSTR = getIntent().getStringExtra("exerciseLogWeek");
        userLoginWD = getIntent().getStringExtra("userLoginEL");

        weekNumWD = (EditText) findViewById(R.id.weekNumber);
        weekNumSTR = "Week " + weekNumSTR;
        weekNumWD.setText(weekNumSTR);

        // link the buttons to the variables
        sunday = (Button) findViewById(R.id.sun_btn);
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
    }

    /**
     * name:  onClick
     *
     * This sets up the various days which the user will choose from and pass off both the week day
     * they selected as well as the previously selected week number.
     * @param view based on button clicked String is given the value of the button label
     */
        @Override
        public void onClick (View view){
           String selectedDay ="";

            if (view == sunday){
                selectedDay ="sunday" ;
            }
            if (view == monday){
                selectedDay = "monday";
            }
            if (view == tuesday){
                selectedDay = "tuesday" ;
            }
            if(view == wednesday) {
                selectedDay ="wednesday" ;
            }
            if (view == thursday) {
                selectedDay = "thursday";
            }
            if (view == friday) {
                selectedDay ="friday" ;
            }
            if(view == saturday){
                selectedDay = "saturday";
            }


            Log.i(wDTAG,"set WDay selectedDayWD = " + selectedDay ) ;
            Log.i(wDTAG,"Rcvd from Ex Log weekNumWD = " + weekNumWD.getText().toString() ) ;
            Log.i(wDTAG,"Rcvd userloginWD = " + userLoginWD ) ;
            // pass the value to the next screen
            Intent nextActivityEnterWOUT = new Intent(WeekDay.this, enterWorkout.class);

            // to handoff the variable to the next activity, need to pass a unique string value
            nextActivityEnterWOUT.putExtra("selectedDayWD",selectedDay);
            nextActivityEnterWOUT.putExtra("weekNumWD",weekNumWD.getText().toString());
            nextActivityEnterWOUT.putExtra("userloginWD",userLoginWD);

            startActivity(nextActivityEnterWOUT);
        }
}
