package com.karthikrk.codesprintapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {
    private TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        t1 = (TextView) findViewById(R.id.textView5);
        t2 = (TextView) findViewById(R.id.textView7);
        t1.setEnabled(false);
        t2.setEnabled(false);
    }
}
