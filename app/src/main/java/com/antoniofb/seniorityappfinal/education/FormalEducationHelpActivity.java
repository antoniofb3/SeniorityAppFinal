package com.antoniofb.seniorityappfinal.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class FormalEducationHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal_education_help);
        setActionBarTitle();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Formal Education Help");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
