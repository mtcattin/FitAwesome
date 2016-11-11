package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class enterWorkout extends AppCompatActivity implements OnClickListener {

    private Button createNewEx;
    private Button viewWorkout;
    private SearchView exerciseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_workout);

        createNewEx = (Button) findViewById(R.id.createNewEx_btn);
        viewWorkout = (Button) findViewById(R.id.btn_week2);
        exerciseDatabase = (SearchView) findViewById(R.id.srchExData);

        // need to figure out how to set up the search still
        createNewEx.setOnClickListener(this);
        viewWorkout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == createNewEx) {
            // take to the exerciseDetails activity
        }
        if(view == viewWorkout) {
            // taje to the workout view Activity
        }
    }
}
