package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * ExerciseLog
 *
 * This shows the user a set of buttons each cooresponding to different weeks (1-12). Once
 * selected it will direct them to the Week Day activity.
 */
public class ExerciseLog extends AppCompatActivity implements OnClickListener {

    private Button week1;
    private Button week2;
    private Button week3;
    private Button week4;
    private Button week5;
    private Button week6;
    private Button week7;
    private Button week8;
    private Button week9;
    private Button week10;
    private Button week11;
    private Button week12;
    String usernameEL;
    /**
     *  Name: onCreate
     *    This is the initial set up of all the variables and thier buttons.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log);

        // receive user name
        usernameEL = getIntent().getStringExtra("userLoginMO");

        // link the variables to the buttons
        week1 = (Button) findViewById(R.id.btn_week1);
        week2 = (Button) findViewById(R.id.btn_View_Wout);
        week3 = (Button) findViewById(R.id.btn_week3);
        week4 = (Button) findViewById(R.id.btn_week4);
        week5 = (Button) findViewById(R.id.btn_week5);
        week6 = (Button) findViewById(R.id.btn_week6);
        week7 = (Button) findViewById(R.id.btn_week7);
        week8 = (Button) findViewById(R.id.btn_week8);
        week9 = (Button) findViewById(R.id.btn_week9);
        week10 = (Button) findViewById(R.id.btn_week10);
        week11 = (Button) findViewById(R.id.btn_week11);
        week12 = (Button) findViewById(R.id.btn_week12);

        // set up the buttons  - same Q's for this class as there were for the days...
        week1.setOnClickListener(this);
        week2.setOnClickListener(this);
        week3.setOnClickListener(this);
        week4.setOnClickListener(this);
        week5.setOnClickListener(this);
        week6.setOnClickListener(this);
        week7.setOnClickListener(this);
        week8.setOnClickListener(this);
        week9.setOnClickListener(this);
        week10.setOnClickListener(this);
        week11.setOnClickListener(this);
        week12.setOnClickListener(this);
    }

    //submit the selection into the database

    /**
     * Name: onClick
     *
     * Depending on the week selected than this will take the selected week and save that for the
     * next activity to pass on until it can be stored in the database. It will also direct the
     * user to the next activity.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        String selectedWeek ="";
        // depending on the week selected open that week's content in the database
        // then go to the weekday Activity
        if(view == week1){
            selectedWeek = "1";
        }

        if(view == week2){
            selectedWeek = "2";
        }
        if(view == week3){
            selectedWeek = "3";
        }
        if(view == week4){
            selectedWeek = "4";
        }
        if(view == week5){
            selectedWeek = "5";
        }
        if(view == week6){
            selectedWeek = "6";
        }
        if(view == week7){
            selectedWeek = "7";
        }
        if(view == week8){
            selectedWeek = "8";
        }
        if(view == week9){
            selectedWeek = "9";
        }
        if(view == week10){
            selectedWeek = "10";
        }
        if(view == week11){
            selectedWeek = "11";
        }
        if(view == week12){
            selectedWeek = "12";
        }
        // pass the value to the next screen
        Intent nextActivityDays = new Intent(ExerciseLog.this, WeekDay.class);

        // to handoff the variable to the next activity, need to pass a unique string value
        nextActivityDays.putExtra("exerciseLogWeek",selectedWeek);
        nextActivityDays.putExtra("userLoginEL",usernameEL);

        startActivity(nextActivityDays);
    }


}
