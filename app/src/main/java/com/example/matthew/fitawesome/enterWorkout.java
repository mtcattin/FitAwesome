package com.example.matthew.fitawesome;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

/*
*  enterWorkout Class
*
*  This class links the enterWorkout UI to the DB and the variables that are used
*  to save the information to the DB.
*  It displays all the exercises as buttons
*
*/
public class enterWorkout extends AppCompatActivity implements OnClickListener{

    ExerciseDBHelper sameDB;
    private Button createNewEx;
    private Button viewWorkout;
    private ScrollView displayExercisesInDB;
    private String weekDay_num;
    private String week_number;
    String exercise_name ="";
    // Go to menuoptions activity icon
    private ImageButton menuhomepageview;

    @Override
    /*
    * Name: onCreate
    *
    * This instantiates the variables and allows for the interactive elements to be set up
    *
    * @param savedInstanceState
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_workout);

        weekDay_num = getIntent().getStringExtra("weekDayNum");
        week_number = getIntent().getStringExtra("weekNUMMM");

        sameDB = new ExerciseDBHelper(this);

       createNewEx = (Button) findViewById(R.id.createNewEx_btn);
       viewWorkout = (Button) findViewById(R.id.btn_week2);

        //exerciseDatabase = (SearchView) findViewById(R.id.srchExData);
        displayExercisesInDB = (ScrollView) findViewById(R.id.listPreviousExercises);

        // Link to Home Page View (Menu Option Activity)
         menuhomepageview = (ImageButton) findViewById(R.id.go_to_menu_option2);
        //
        createNewEx.setOnClickListener(this);
        viewWorkout.setOnClickListener(this);

        viewExercises();

    }

    /*
    * onClick
    *
    * This function takes uses the variables from above and sets up the actions
    * involved with the various interactive elements.
    *
    * specifically this one sets up either option to the activities they are linked to.
    * @param view
    */
    public void onClick(View view) {
        if(view.getId() == R.id.createNewEx_btn) {
            // take to the exerciseDetails activity
            startActivity(new Intent(enterWorkout.this, exerciseDetails.class));
        }
        if(view.getId() == R.id.btn_week2) {
            // take to the workout view Activity
            startActivity(new Intent(enterWorkout.this, workoutView.class));

            // IF select one of the scrollView items then open the exerciseDetails page
            // also set the exerciseName of that exercise to be the DB value of the "name"

        }
        //If selected Return To Home Page button then go to menuoption activity
        if(view == menuhomepageview) {
        // Send to menuoption activity
        startActivity(new Intent(enterWorkout.this, menuoption.class));
        }
    }

    // displays all exercises in DB as buttons
    private void viewExercises(){
       // sameDB = this.getWritableDatabase();

        sameDB.getReadableDatabase();

        TableLayout ewTableLayout = (TableLayout)findViewById(R.id.ew_scrollTable);
        int count = sameDB.countRowsInDB();
        Cursor cursor = sameDB.getFirstRow();
        exercise_name = cursor.getString(0);
        cursor.moveToFirst();
        //int count = 10;
        // display number of buttons based on the ros of data in the DB
        for (int row = 0; row < count; row++){
            TableRow tableRow = new TableRow(this);
            // setting up properties
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            // adds new row inside table
            ewTableLayout.addView(tableRow);

            // create a new button
            Button button = new Button(this);

            // set button parameters
            button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT, 1.0f));
            //set button text display
            button.setText(exercise_name);
            // set button to be clickable
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoExercise();
                    Intent nextExerciseDetails = new Intent(enterWorkout.this, exerciseDetails.class);
                    nextExerciseDetails.putExtra("ewExercise_Name",exercise_name);
                    nextExerciseDetails.putExtra("ewWeekDay",weekDay_num);
                    nextExerciseDetails.putExtra("ewWeekNumber",week_number);
                    startActivity(nextExerciseDetails);
                }
            });
            tableRow.addView(button);
        }

    }
    // Function to view exercise
    public void gotoExercise(){
        Toast.makeText(enterWorkout.this, "In Go to Exercise link", Toast.LENGTH_SHORT).show();
    }


}
//    // Go to menuoptions activity icon
//       private ImageButton menuhomepageview;

//// Link to Home Page View (Menu Option Activity)
//         menuhomepageview = (ImageButton) findViewById(R.id.go_to_menu_option2);
//
//        //If selected Return To Home Page button then go to menuoption activity
//        if(view == menuhomepageview) {
//        // Send to menuoption activity
//        startActivity(new Intent(enterWorkout.this, menuoption.class));
//        }