package com.example.matthew.fitawesome;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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

    // this is what the debugger string is looking for(see below)
    private static final String eWTAG = enterWorkout.class.getSimpleName();

    ExerciseDBHelper sameDB;
    private Button createNewEx;
    private Button viewWorkout;
   // private SearchView exerciseDatabase;
    private ScrollView displayExercisesInDB;

    private String userNameEW;
    private String weekDayEW;
    private String week_numberEW;
    private String exercise_name ="";




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

        userNameEW = getIntent().getStringExtra("userloginWD");
        weekDayEW = getIntent().getStringExtra("selectedDayWD");
        week_numberEW = getIntent().getStringExtra("weekNumWD");

        Log.i(eWTAG,"rcvdFromWD userloginWD " + userNameEW ) ;
        Log.i(eWTAG,"rcvdFromWD selectedDayWD " + weekDayEW );
        Log.i(eWTAG,"rcvdFromWD weekNumWD " + week_numberEW );


        sameDB = new ExerciseDBHelper(this);

        createNewEx = (Button) findViewById(R.id.createNewEx_btn);
        viewWorkout = (Button) findViewById(R.id.btn_View_Wout);

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
    @Override
    public void onClick(View view) {

        //Intent afterWrkoutAct;
        if(view == createNewEx) {
            // take to the exerciseDetails activity
            Intent afterWrkoutAct = new Intent(enterWorkout.this, exerciseDetails.class);
            exercise_name="";

            afterWrkoutAct.putExtra("ewExercise_Name", exercise_name);
            afterWrkoutAct.putExtra("ewWeekDay", weekDayEW);
            afterWrkoutAct.putExtra("ewWeekNumber", week_numberEW);
            afterWrkoutAct.putExtra("ewUserName", userNameEW);
            startActivity(afterWrkoutAct);
        }
        if(view == viewWorkout) {
            // take to the workout view Activity
            Intent afterWrkoutAct2 = new Intent(enterWorkout.this, workoutView.class);
            afterWrkoutAct2.putExtra("selectedDayWD", weekDayEW);
            afterWrkoutAct2.putExtra("weekNumWD", week_numberEW);
            afterWrkoutAct2.putExtra("userloginWD", userNameEW);
            startActivity(afterWrkoutAct2);

        }
    }

    // displays all exercises in DB as buttons
    private void viewExercises(){

        TableLayout ewTableLayout = (TableLayout)findViewById(R.id.ew_scrollTable);

        // get row count from DB
        int count = sameDB.countRowsInDB();

        SQLiteDatabase exdb_temp;
        exdb_temp = sameDB.getReadableDatabase();

        Cursor cursor = exdb_temp.rawQuery("select Exercise from UserExercise_table",null);
        Log.i(eWTAG,"ViewExercisesEW Ex name " + exercise_name ) ;

        if (cursor.moveToFirst()) {
            //int count = 10;
            // display number of buttons based on the ros of data in the DB
            for (int row = 0; row < count; row++) {
                TableRow tableRow = new TableRow(this);
                // setting up properties
                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
                // adds new row inside table
                ewTableLayout.addView(tableRow);

                exercise_name = cursor.getString(0);

                Log.i(eWTAG,"EWViewExercises Name " + row + exercise_name);
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
                        nextExerciseDetails.putExtra("ewExercise_Name", exercise_name);
                        nextExerciseDetails.putExtra("ewWeekDay", weekDayEW);
                        nextExerciseDetails.putExtra("ewWeekNumber", week_numberEW);
                        nextExerciseDetails.putExtra("ewUserName", userNameEW);
                        startActivity(nextExerciseDetails);
                    }
                });
                tableRow.addView(button);
                cursor.moveToNext();

                if(cursor.isAfterLast()){
                    break;
                }
            }
        }
        cursor.close();

    }
    // Function to view exercise
    public void gotoExercise(){
        Toast.makeText(enterWorkout.this, "In Go to Exercise link", Toast.LENGTH_SHORT).show();
    }

}
