package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class exerciseDetails extends AppCompatActivity {
    // variables
    private EditText sets;
    private EditText reps;
    private EditText lb;
    private Button addExercise;
    private Button viewWorkout;
    private Button saveExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        // link the variables to the buttons in the XML
        sets = (EditText) findViewById(R.id.input_sets);
        reps = (EditText) findViewById(R.id.input_reps);
        lb = (EditText) findViewById(R.id.input_lb);

        addExercise = (Button) findViewById(R.id.addEx_btn);
        viewWorkout = (Button) findViewById(R.id.view_wout_btn);
        saveExercise = (Button) findViewById(R.id.save_ex_btn);



    }
}
