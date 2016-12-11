package com.example.matthew.fitawesome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 *  This class deals with letting the user select from a list of pre-established workout
 *  programs from Bodybuilding.Com. We selected 3 programs that are highly rated and used most
 *  frequently from the site. ShortcuttoShred, Shortcuttosize, Jamie Eason's LivFit.
 */
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

    /**
     * Name: onCreate
     *
     * This sets up all the variables to the various buttons from the XML.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_options);

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

    /**
     * name:  onClick
     *    All the buttons are linked to thier cooresponding webpage. So all of the Phase buttons
     *    link to that particular "phase" in the program, which the large program button will
     *    link to the main page of the program.
     * @param view
     */
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
        }
        if(view == SC2Sprgm_p2) {
            Intent SC2Sprgm_p2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-8-chest-triceps-abs.html"));
            startActivity(SC2Sprgm_p2Intent);
        }
        if(view == SC2Sprgm_p3) {
            Intent SC2Sprgm_p3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jim-stoppani-six-week-shortcut-to-shred-day-15-chest-triceps.html"));
            startActivity(SC2Sprgm_p3Intent);
        }
        if(view == SC2Szprgm) {
            Intent SC2SzprgmIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-training.html"));
            startActivity(SC2SzprgmIntent);
        }
        if(view == SC2Szprgm_p1) {
            Intent SC2Szprgm_p1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-phase-1-week-1-day-1.html"));
            startActivity(SC2Szprgm_p1Intent);
        }
        if(view == SC2Szprgm_p2) {
            Intent SC2Szprgm_p2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-phase-2-week-5-day-29.html"));
            startActivity(SC2Szprgm_p2Intent);
        }
        if(view == SC2Szprgm_p3) {
            Intent SC2Szprgm_p3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/shortcut-to-size-phase-3-week-9-day-57.html"));
            startActivity(SC2Szprgm_p3Intent);
        }
        if (view == livfitprgm) {
            Intent livfitprgm = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-eason-livefit-trainer.html"));
            startActivity(livfitprgm);

        }
        if(view == livfitprgm_p1) {
            Intent livfitprgm_p1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-1.html"));
            startActivity(livfitprgm_p1);

        }
        if(view == livfitprgm_p2) {
            Intent livfitprgm_p2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-2.html"));
            startActivity(livfitprgm_p2);
        }
        if(view == livfitprgm_p3) {
            Intent livfitprgm_p3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodybuilding.com/fun/jamie-easons-livefit-phase-3.html"));
            startActivity(livfitprgm_p3);
        }
    }
}
