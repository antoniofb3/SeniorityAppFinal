package com.antoniofb.seniorityappfinal.leadershipExperience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class LeadershipExperienceHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leadership_experience_help);
        setActionBarTitle();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Help for Technical Skills");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
