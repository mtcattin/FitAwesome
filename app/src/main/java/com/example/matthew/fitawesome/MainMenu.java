package com.example.matthew.fitawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


//


public class MainMenu extends AppCompatActivity {
    private static final String TAG = MainMenu.class.getSimpleName();
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // calls the constructor class (creates an instance and the database)
        myDB = new DBHelper(this);


        EditText userName = (EditText) findViewById(R.id.UserName);
        EditText password = (EditText) findViewById(R.id.Password);
        Button signInBtn = (Button) findViewById(R.id.SignInbutton);
        Button CreateAccountBtn = (Button) findViewById(R.id.BtnCreateAccount);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Log.i(TAG," Log Info Works!" ) ;
        Log.e(TAG," Log Error Works!" ) ;


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onButtonClick(View view){

        Intent nextActivity;

        if (view.getId()== R.id.BtnLog_In){
            nextActivity = new Intent(MainMenu.this, ExerciseLog.class);
            startActivity(nextActivity);
        }
        if (view.getId()== R.id.BtnCreateAccount) {

            nextActivity = new Intent(MainMenu.this, CreateAnAccount.class);
            startActivity(nextActivity);
        }
    }
}

class Phase {
    private int numWeeksInProgram;
    private String[] weekDayList;
    private int phaseNumber;

    public Phase() {
        //check to see what phase you are in

        setNumWeeksInProgram();
        weekDayList = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    }
    public int getNumWeeksInProgram() {
        return numWeeksInProgram;
    }
    public void setNumWeeksInProgram() {
        numWeeksInProgram = 12;
    }

};

class day {
    private String wkDay;
    private List<Exercise> exerciseList;

    public day(String day, List <Exercise> newList){
        setDay(day);
        setExerciseList(newList);
    }
    public String getDay(){
        return wkDay;
    }
    public void setDay(String day){
        wkDay = day;
    }
    public void setExerciseList(List<Exercise> exerciseList1){
        exerciseList = exerciseList1;
    }
    public List getExerciseList() {
        return exerciseList;
    }

}

class Exercise{

    private String dayName;
    private List <Sets> exerciseSet;

    Exercise(String nameofDay, List <Sets> exerciseList1){

        setExerciseName(nameofDay);
        setExerciselist(exerciseList1);
    }
    public String getExerciseName(){
        return dayName;
    }

    public void setExerciseName(String name){
        dayName = name;
    }

    public List<Sets>  getExerciseList(){
        return exerciseSet;
    }

    public void setExerciselist(List <Sets> newList){
        exerciseSet = newList;
    }
}

class Sets{
    private int reps;
    private float weight;

    public Sets(int repetitions, float mass){
        setReps(repetitions);
        setWeight(mass);
    }

    public void setReps(int number){
        reps = number;
    }

    public int getReps(){
        return reps;
    }

    public void setWeight(float pounds){
        weight = pounds;
    }

    public float getWeight(){
        return weight;
    }
}