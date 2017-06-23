package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;

public class SummaryActivity extends AppCompatActivity {

    private Button btConfirm;
    private String[] results = {"Formal Education", "Experience", "Management", "Communication", "Technical Skills", "Leadership Experience", "Empowerment"};
    private ListView lvResults;

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
        lvResults = (ListView) findViewById(R.id.lvResultsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,results);
        lvResults.setAdapter(adapter);
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
