package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log);

        // link the variables to the buttons
        week1 = (Button) findViewById(R.id.btn_week1);
        week2 = (Button) findViewById(R.id.btn_week2);
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

    // open the activity
    @Override
    public void onClick(View view) {

        // depending on the week selected open that week's content in the database

        // then go to the weekday Activity
        if((view == week1) || (view == week2) || (view == week3) || (view == week4)
                || (view == week5) || (view == week6) || (view == week7) || (view ==week8)
                || (view == week9) || (view == week10) || (view == week11) || (view == week12)) {
            // link to the weekDay activity
            startActivity(new Intent(ExerciseLog.this, WeekDay.class));
        }
    }
}
