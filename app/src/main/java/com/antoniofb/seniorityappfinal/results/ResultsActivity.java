package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.registration.RegistrationActivity;

public class ResultsActivity extends AppCompatActivity {

    private Button btDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setActionBarTitle();
        showSeniority();
        returnToRegistration();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Seniority Screen");
    }

    public void showSeniority(){

    }

    public void returnToRegistration(){
        btDone = (Button) findViewById(R.id.btnEndProcess);
        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsActivity.this, RegistrationActivity.class));
            }
        });
    }
}
