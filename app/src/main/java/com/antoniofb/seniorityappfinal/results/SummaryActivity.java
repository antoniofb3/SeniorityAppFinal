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
    private int[] scores;
    private Intent intent;

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
        //to add the scores
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("EIH");
    }

    public void registerResults(){
        btConfirm = (Button) findViewById(R.id.btnConfirmSummary);
        intent = new Intent(this, ResultsActivity.class);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("SC", scores);//always put the same key
                startActivity(intent);
                //startActivity(new Intent(SummaryActivity.this, ResultsActivity.class));
            }
        });
    }
}
