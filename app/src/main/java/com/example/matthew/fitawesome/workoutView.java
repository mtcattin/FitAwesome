package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

public class workoutView extends AppCompatActivity implements OnClickListener {

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

        // set up the buttons
        completeWorkout.setOnClickListener(this);
        clearWorkout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == completeWorkout) {
            // save workout to database open 
        }
        if(view == clearWorkout) {
            // delete currect days workout from the database
        }

    }
}
