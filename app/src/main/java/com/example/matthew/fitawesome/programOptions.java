package com.example.matthew.fitawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class programOptions extends AppCompatActivity {
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
    }
}
