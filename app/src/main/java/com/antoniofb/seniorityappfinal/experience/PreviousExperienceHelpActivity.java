package com.antoniofb.seniorityappfinal.experience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class PreviousExperienceHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_experience_help);
        setActionBarTitle();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Previous Experience Help");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
