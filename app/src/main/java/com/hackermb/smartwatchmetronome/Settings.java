package com.hackermb.smartwatchmetronome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    SharedPreferences sharedPref;
    TextView txtFrequency;
    TextView txtDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setup (Set layout and remove App-Title on top of activity)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();

        sharedPref = this.getSharedPreferences(getString(R.string.shared_pref_name), Context.MODE_PRIVATE);

        // Back button
        ImageButton backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> finish());

        // Frequency
        txtFrequency = findViewById(R.id.txtFrequencySet);
        txtFrequency.setText(sharedPref.getInt(getString(R.string.shared_pref_frequency), 100) + " BPM");
        Button btnMinusFrequency = findViewById(R.id.btnMinusFrequency);
        btnMinusFrequency.setOnClickListener(v -> {
            changeFrequency(-1);
        });
        Button btnPlusFrequency = findViewById(R.id.btnPlusFrequency);
        btnPlusFrequency.setOnClickListener(v -> {
            changeFrequency(+1);
        });

        // Duration
        txtDuration = findViewById(R.id.txtDuration);
        txtDuration.setText(sharedPref.getInt(getString(R.string.shared_pref_duration), 250) + " MS");
        Button btnMinusOnTime = (Button) findViewById(R.id.btnMinusDuration);
        btnMinusOnTime.setOnClickListener(v -> {
            changeDuration(-1);
        });
        Button btnPlusDuration = findViewById(R.id.btnPlusDuration);
        btnPlusDuration.setOnClickListener(v -> {
            changeDuration(1);
        });
    }

    /**
     * Change the frequency by the given amount.
     * E.g. can be 1 to increase it by 1 or -1 to decrease it by -1
     * @param amount how much do increase/decrease
     */
    private void changeFrequency(int amount){
        int bpm = sharedPref.getInt(getString(R.string.shared_pref_frequency), 100);
        if ((bpm <= 0 && amount < 0) || (bpm >= 1000 && amount >= 0)){
            return;
        }
        bpm += amount;
        sharedPref.edit().putInt(getString(R.string.shared_pref_frequency), bpm).apply();
        txtFrequency.setText(bpm + " BPM");
    }

    /**
     * Change the duration by the given amount.
     * E.g. can be 1 to increase it by 1 or -1 to decrease it by -1
     * @param amount how much do increase/decrease
     */
    private void changeDuration(int amount){
        int duration = sharedPref.getInt(getString(R.string.shared_pref_duration), 250);
        if ((duration <= 0 && amount < 0) || (duration >= 1000 && amount > 0)){
            return;
        }
        duration += amount;
        sharedPref.edit().putInt(getString(R.string.shared_pref_duration), duration).apply();
        txtDuration.setText(duration + " MS");
    }
}