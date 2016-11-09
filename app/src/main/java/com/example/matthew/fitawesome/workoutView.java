package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ExpandableListView;

public class workoutView extends AppCompatActivity {

    private Button completeWorkout;
    private Button clearWorkout;
    private ExpandableListView workoutDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        completeWorkout = (Button) findViewById(R.id.completeWout_btn);
        clearWorkout = (Button) findViewById(R.id.clrWout_btn);
        workoutDisplay = (ExpandableListView) findViewById(R.id.list_woutContents);
    }
}
