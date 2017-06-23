package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.antoniofb.seniorityappfinal.R;

public class SummaryActivity extends AppCompatActivity {

    private Button btConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        setActionBarTitle();
        showSummaryResults();
        registerResults();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Summary Screen");
    }

    public void showSummaryResults(){
    }

    public void registerResults(){
        btConfirm = (Button) findViewById(R.id.btnConfirmSummary);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SummaryActivity.this, ResultsActivity.class));
            }
        });
    }
}
