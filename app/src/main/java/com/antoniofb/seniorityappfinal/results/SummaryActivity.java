package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;

public class SummaryActivity extends AppCompatActivity {

    private String[] factorsName = {"Formal Education", "Experience", "Management", "Communication", "Technical Skills", "Leadership Experience", "Empowerment"};
    private ListView lvResults;
    private int[] scores = new int[7];
    private Intent intent;
    private String[] factorsScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        setActionBarTitle();
        showSummaryResults();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.registerButton:
                intent = new Intent(this, ResultsActivity.class);
                intent.putExtra("SC", scores);//always put the same key
                startActivity(intent);
                break;

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Summary");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showSummaryResults(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("AllScores");
        CustomListAdapterSummary customListAdapterSummary = new CustomListAdapterSummary(this,factorsName,scores);
        lvResults = (ListView) findViewById(R.id.lvResultsList);
        lvResults.setAdapter(customListAdapterSummary);
    }
}
