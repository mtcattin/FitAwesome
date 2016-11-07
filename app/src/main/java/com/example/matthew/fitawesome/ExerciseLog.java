package com.example.matthew.fitawesome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ExerciseLog extends AppCompatActivity {

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
        week1 = (Button) findViewById(R.id.btn_week1);

    }
}

