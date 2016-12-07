package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/* WeekDay class sets up the Week days and allows the user to choose which day of the week
they want to access. Once a day button is implemented it then accesses the enterWorkout Activity
 */

public class WeekDay extends AppCompatActivity implements OnClickListener {

    private Button sunday;
    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;
        // Menu Options button
    private Button menuhomepageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_day);

        // link the buttons to the variables
        sunday = (Button) findViewById(R.id.sun_btn);
        monday = (Button) findViewById(R.id.mon_btn);
        tuesday = (Button) findViewById(R.id.tues_btn);
        wednesday = (Button) findViewById(R.id.wed_btn);
        thursday = (Button) findViewById(R.id.thurs_btn);
        friday = (Button) findViewById(R.id.fri_btn);
        saturday = (Button) findViewById(R.id.sat_btn);
        // Link to Home Page View (Menu Option Activity)
        menuhomepageview = (Button) findViewById(R.id.menu_option_btn1);

        // set up the buttons for activity
        sunday.setOnClickListener(this);
        monday.setOnClickListener(this);
        tuesday.setOnClickListener(this);
        wednesday.setOnClickListener(this);
        thursday.setOnClickListener(this);
        friday.setOnClickListener(this);
        saturday.setOnClickListener(this);
    }

        @Override
        public void onClick (View view){
            if ((view == sunday) || (view == monday) || (view == tuesday) || (view == wednesday)
                    || (view == thursday) || (view == friday) || (view == saturday)) {
                // open up to enter workout page
                    startActivity(new Intent(WeekDay.this, enterWorkout.class));
                // specify where the data will be stored??
            /*should all the days be listed in this single if statement? since they
             all go to the same page? Or should they each have thier own set up?
             see wk 10 agenda for more Q's and details...
             */
        //If selected Return To Home Page button then go to menuoption activity
        if(view == menuhomepageview) {
        // send to exerciseLog activity
        startActivity(new Intent(WeekDay.this, menuoption.class));
        }





            }
        }
    }
