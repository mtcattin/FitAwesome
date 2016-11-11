package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class WeekDay extends AppCompatActivity {

    private Button sunday;
    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_day);


        sunday = (Button) findViewById(R.id.sun_btn);
        monday = (Button) findViewById(R.id.mon_btn);
        tuesday = (Button) findViewById(R.id.tues_btn);
        wednesday = (Button) findViewById(R.id.wed_btn);
        thursday = (Button) findViewById(R.id.thurs_btn);
        friday = (Button) findViewById(R.id.fri_btn);
        saturday = (Button) findViewById(R.id.sat_btn);
    }
}
