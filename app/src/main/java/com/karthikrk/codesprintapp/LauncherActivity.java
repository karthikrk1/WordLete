package com.karthikrk.codesprintapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    /**
     * Handler for the Start Button
     * @param view
     */
    public void onClickStart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Handler for the Instruction Button - Opens a new Activity
     * @param view
     */
    public void onInsClick(View view) {
        Intent intent = new Intent(this, InstructionActivity.class);
        startActivity(intent);
    }

}
