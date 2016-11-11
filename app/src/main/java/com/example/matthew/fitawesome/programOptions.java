package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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

    @Override
    public void onClick(View view) {
        if(view == SC2Sprgm) {
            // link to URL of the program
        }
        if(view == SC2Sprgm_p1) {
            // Link to phase 1
        }
        if(view == SC2Sprgm_p2) {

        }
        if(view == SC2Sprgm_p3) {

        }
        if(view == SC2Szprgm) {

        }
        if(view == SC2Szprgm_p1) {

        }
        if(view == SC2Szprgm_p2) {

        }
        if(view == SC2Szprgm_p3) {

        }
        if (view == livfitprgm) {

        }
        if(view == livfitprgm_p1) {

        }
        if(view == livfitprgm_p2) {

        }
        if(view == livfitprgm_p3) {

        }
    }
}
