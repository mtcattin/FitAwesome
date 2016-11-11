package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class menuoption extends AppCompatActivity implements OnClickListener {

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

        // set up the buttons
        exProgram.setOnClickListener(this);
        woLog.setOnClickListener(this);
        progLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == exProgram) {
            // link to programOptions activity
        }
        if(view == woLog) {
            // send to exerciseLog activity
        }
        // NOT SETTING UP THE PROGLOG YET...
    }
}


