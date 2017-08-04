package com.antoniofb.seniorityappfinal.empowerment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class EmpowermentHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empowerment_help);
        setBarOptions();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        finish();
        return true;
    }

    public void setBarOptions(){
        getSupportActionBar().setTitle("Help for Empowerment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
