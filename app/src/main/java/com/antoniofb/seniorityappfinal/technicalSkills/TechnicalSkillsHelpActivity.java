package com.antoniofb.seniorityappfinal.technicalSkills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class TechnicalSkillsHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_skills_help);
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
