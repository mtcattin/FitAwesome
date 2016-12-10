package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

public class workoutView extends AppCompatActivity implements OnClickListener {

    private Button completeWorkout;
    private Button clearWorkout;
    private ExpandableListView workoutDisplay;

    // Go to menuoptions activity icon
    private ImageButton menuhomepageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        completeWorkout = (Button) findViewById(R.id.completeWout_btn);
        clearWorkout = (Button) findViewById(R.id.clrWout_btn);
        workoutDisplay = (ExpandableListView) findViewById(R.id.list_woutContents);

        //Link to Home Page View (Menu Option Activity)
         menuhomepageview = (ImageButton) findViewById(R.id.go_to_menu_option4);

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
        //If selected Return To Home Page button then go to menuoption activity
        if(view == menuhomepageview) {
        // Send to menuoption activity
        startActivity(new Intent(workoutView.this, menuoption.class));
        }
    }
}
//    // Go to menuoptions activity icon
//       private ImageButton menuhomepageview;

////       Link to Home Page View (Menu Option Activity)
//         menuhomepageview = (ImageButton) findViewById(R.id.go_to_menu_option4);
//
//        //If selected Return To Home Page button then go to menuoption activity
//        if(view == menuhomepageview) {
//        // Send to menuoption activity
//        startActivity(new Intent(exerciseDetails.this, menuoption.class));
//        }