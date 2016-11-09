package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.Button;

public class enterWorkout extends AppCompatActivity {

    private Button createNewEx;
    private Button viewWorkout;
    private SearchView exerciseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_workout);

        createNewEx = (Button) findViewById(R.id.createNewEx_btn);
        viewWorkout = (Button) findViewById(R.id.viewWout_btn);
        exerciseDatabase = (SearchView) findViewById(R.id.srchExData);
    }
}
