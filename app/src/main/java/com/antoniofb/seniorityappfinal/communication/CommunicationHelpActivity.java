package com.antoniofb.seniorityappfinal.communication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniofb.seniorityappfinal.R;

public class CommunicationHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_help);
        setActionBarTitle();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Communication Help");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
