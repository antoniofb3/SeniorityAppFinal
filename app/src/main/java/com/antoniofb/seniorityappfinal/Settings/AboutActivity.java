package com.antoniofb.seniorityappfinal.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setActionBarTitle();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
