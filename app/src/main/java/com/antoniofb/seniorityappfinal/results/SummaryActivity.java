package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.content.res.Resources;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class SummaryActivity extends AppCompatActivity {

    private String[] factorsName;
    private ListView lvResults;
    private int[] scores;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        setBarOptions();
        fillFactorsList();
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

    public void setBarOptions(){
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

    public void fillFactorsList(){

        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.factors);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine());
        }
        parseJson(stringBuilder.toString());
    }

    private void parseJson(String s) {
        //StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(s);
            JSONObject factor = root.getJSONObject("seniority");
            JSONArray jsonFactors = factor.getJSONArray("factors");
            factorsName = new String[jsonFactors.length()];
            scores = new int[jsonFactors.length()];
            for (int i=0; i<jsonFactors.length(); i++){
                JSONObject jsonObject = jsonFactors.getJSONObject(i);
                factorsName[i] = jsonObject.getString("factor");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
