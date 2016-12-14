package com.example.matthew.fitawesome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class programOptions extends AppCompatActivity implements OnClickListener {
// short cut to shred buttons
    private Button SC2Sprgm;
    private Button SC2Sprgm_p1;
    private Button SC2Sprgm_p2;
    private Button SC2Sprgm_p3;


// short cut to size buttons
    private Button SC2Szprgm;
    private Button SC2Szprgm_p1;
    private Button SC2Szprgm_p2;
    private Button SC2Szprgm_p3;

    // live fit buttons
    private Button livfitprgm;
    private Button livfitprgm_p1;
    private Button livfitprgm_p2;
    private Button livfitprgm_p3;

    // Go to menuoptions activity icon
    private ImageButton menuhomepageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_options);

        // Link to Home Page View (Menu Option Activity)
        menuhomepageview = (ImageButton) findViewById(R.id.go_to_menu_option1);

        // link the variables to the buttons in the XML (shortcut to shred)
        SC2Sprgm = (Button) findViewById(R.id.SC2S_btn);
        SC2Sprgm_p1 = (Button) findViewById(R.id.SC2S_P1_btn);
        SC2Sprgm_p2 = (Button) findViewById(R.id.SC2S_P2_btn);
        SC2Sprgm_p3 = (Button) findViewById(R.id.SC2S_P3_btn);

        // link shortcut to size
        SC2Szprgm = (Button) findViewById(R.id.SC2SZ_btn);
        SC2Szprgm_p1 = (Button) findViewById(R.id.SC2Sz_P1_btn);
        SC2Szprgm_p2 = (Button) findViewById(R.id.SC2Sz_P2_btn);
        SC2Szprgm_p3 = (Button) findViewById(R.id.SC2Sz_P3_btn);

        // link to live fit
        livfitprgm = (Button) findViewById(R.id.livfit_btn);
        livfitprgm_p1 = (Button) findViewById(R.id.LF_P1_btn);
        livfitprgm_p2 = (Button) findViewById(R.id.LF_P2_btn);
        livfitprgm_p3 = (Button) findViewById(R.id.LF_P3_btn);

        // set up the buttons
        SC2Sprgm.setOnClickListener(this);
        SC2Sprgm_p1.setOnClickListener(this);
        SC2Sprgm_p2.setOnClickListener(this);
        SC2Sprgm_p3.setOnClickListener(this);

        SC2Szprgm.setOnClickListener(this);
        SC2Szprgm_p1.setOnClickListener(this);
        SC2Sprgm_p2.setOnClickListener(this);
        SC2Sprgm_p3.setOnClickListener(this);

        livfitprgm.setOnClickListener(this);
        livfitprgm_p1.setOnClickListener(this);
        livfitprgm_p2.setOnClickListener(this);
        livfitprgm_p3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == SC2Sprgm) {
            Intent SC2SprgmIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred.html"));
            startActivity(SC2SprgmIntent);
            // link to URL of the program
        }
        if(view == SC2Sprgm_p1) {
            Intent SC2Sprgm_p1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-1-chest-triceps-abs.html"));
            startActivity(SC2Sprgm_p1Intent);

            //http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-1-chest-triceps-abs.html
            // Link to phase 1
        }
        if(view == SC2Sprgm_p2) {
            Intent SC2Sprgm_p2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-8-chest-triceps-abs.html"));
            startActivity(SC2Sprgm_p2Intent);

            //http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-8-chest-triceps-abs.html

        }
        if(view == SC2Sprgm_p3) {
            Intent SC2Sprgm_p3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-15-chest-triceps.html"));
            startActivity(SC2Sprgm_p3Intent);
            //http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-15-chest-triceps.html

        }
        if(view == SC2Szprgm) {
            Intent SC2SzprgmIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-training.html"));
            startActivity(SC2SzprgmIntent);

            //http://www.bodybuilding.com/fun/shortcut-to-size-training.html

        }
        if(view == SC2Szprgm_p1) {
            Intent SC2Szprgm_p1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-phase-1-week-1-day-1.html"));
            startActivity(SC2Szprgm_p1Intent);

            //http://www.bodybuilding.com/fun/shortcut-to-size-phase-1-week-1-day-1.html

        }
        if(view == SC2Szprgm_p2) {
            Intent SC2Szprgm_p2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-phase-2-week-5-day-29.html"));
            startActivity(SC2Szprgm_p2Intent);

            //http://www.bodybuilding.com/fun/shortcut-to-size-phase-2-week-5-day-29.html

        }
        if(view == SC2Szprgm_p3) {
            Intent SC2Szprgm_p3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-phase-3-week-9-day-57.html"));
            startActivity(SC2Szprgm_p3Intent);
            //http://www.bodybuilding.com/fun/shortcut-to-size-phase-3-week-9-day-57.html

        }
        if (view == livfitprgm) {
            Intent livfitprgm = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-eason-livefit-trainer.html"));
            startActivity(livfitprgm);

            //http://www.bodybuilding.com/fun/jamie-eason-livefit-trainer.html

        }
        if(view == livfitprgm_p1) {
            Intent livfitprgm_p1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-1.html"));
            startActivity(livfitprgm_p1);

            //http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-1.html

        }
        if(view == livfitprgm_p2) {
            Intent livfitprgm_p2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-2.html"));
            startActivity(livfitprgm_p2);

            //http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-2.html

        }
        if(view == livfitprgm_p3) {
            Intent livfitprgm_p3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-3.html"));
            startActivity(livfitprgm_p3);

            //http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-3.html

        }//If selected Return To Home Page button then go to menuoption activity

        //If selected Return To Home Page button then go to menuoption activity
        if(view == menuhomepageview) {
        // Send to menuoption activity
        startActivity(new Intent(programOptions.this, menuoption.class));
        }
    }
}
//Use this code for the image buttons
//    // Go to menuoptions activity icon
//       private ImageButton menuhomepageview;

//// Link to Home Page View (Menu Option Activity)
//         menuhomepageview = (ImageButton) findViewById(R.id.go_to_menu_option1);
//
//        //If selected Return To Home Page button then go to menuoption activity
//        if(view == menuhomepageview) {
//        // Send to menuoption activity
//        startActivity(new Intent(exerciseDetails.this, menuoption.class));
//        }
//***Dont use this code below***
//    // Menu Options button
//    private Button menuhomepageview;

//// Link to Home Page View (Menu Option Activity)
//menuhomepageview = (Button) findViewById(R.id.menu_option_btn);
//
//        //If selected Return To Home Page button then go to menuoption activity
//        if(view == menuhomepageview) {
//        // send to exerciseLog activity
//        startActivity(new Intent(programOptions.this, menuoption.class));
//        }