package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class menuoption extends AppCompatActivity {

    private Button exProgram;
    private Button woLog;
    private Button progLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuoption);

        // link the variables to the buttons in the XML
        exProgram = (Button) findViewById(R.id.exercise_prg_btn);
        woLog = (Button) findViewById(R.id.workoutLog_btn);
        progLog = (Button) findViewById(R.id.progress_log_btn);

    }
}


