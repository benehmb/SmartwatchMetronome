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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();

        sharedPref = this.getSharedPreferences(getString(R.string.shared_pref_name), Context.MODE_PRIVATE);

        ImageButton backButton = (ImageButton) findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> finish());
        txtFrequency = (TextView) findViewById(R.id.txtFrequencySet);
        updateTxtFrequencySet();
        Button btnMinus = (Button) findViewById(R.id.btnMinusFrequency);
        btnMinus.setOnClickListener(v -> {
            int bpm = sharedPref.getInt(getString(R.string.shared_pref_frequency), 100);
            if (bpm > 1) {
                bpm--;
                sharedPref.edit().putInt(getString(R.string.shared_pref_frequency), bpm).apply();
                updateTxtFrequencySet();
            }
        });
        Button btnPlus = (Button) findViewById(R.id.btnPlusFrequency);
        btnPlus.setOnClickListener(v -> {
            int bpm = sharedPref.getInt(getString(R.string.shared_pref_frequency), 100);
            if (bpm < 300) {
                bpm++;
                sharedPref.edit().putInt(getString(R.string.shared_pref_frequency), bpm).apply();
                updateTxtFrequencySet();
            }
        });
        TextView txtOnTime = (TextView) findViewById(R.id.txtDuration);
        txtOnTime.setText(String.valueOf(sharedPref.getInt(getString(R.string.shared_pref_duration), 250)) + " ms");
        Button btnMinusOnTime = (Button) findViewById(R.id.btnMinusDuration);
        btnMinusOnTime.setOnClickListener(v -> {
            int onTime = sharedPref.getInt(getString(R.string.shared_pref_duration), 250);
            if (onTime > 1) {
                onTime--;
                sharedPref.edit().putInt(getString(R.string.shared_pref_duration), onTime).apply();
                txtOnTime.setText(String.valueOf(onTime) + " ms");
            }
        });
        Button btnPlusOnTime = (Button) findViewById(R.id.btnPlusDuration);
        btnPlusOnTime.setOnClickListener(v -> {
            int onTime = sharedPref.getInt(getString(R.string.shared_pref_duration), 250);
            if (onTime < 1000) {
                onTime++;
                sharedPref.edit().putInt(getString(R.string.shared_pref_duration), onTime).apply();
                txtOnTime.setText(String.valueOf(onTime) + " MS");
            }
        });
    }

    private void updateTxtFrequencySet(){
        int bpm = sharedPref.getInt(getString(R.string.shared_pref_frequency), 100);
        txtFrequency.setText(String.valueOf(bpm) + " BPM");
    }
}