package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;
import com.antoniofb.seniorityappfinal.registration.RegistrationActivity;

public class ResultsActivity extends AppCompatActivity {

    private int[] scores;
    private TextView tvSeniorityScore, tvSeniorityCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setBarOptions();
        showSeniority();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.finishButton:
                startActivity(new Intent(ResultsActivity.this, FactorsActivity.class));
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
        getSupportActionBar().setTitle("Seniority Results");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showSeniority(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("SC");
        int seniorityScore = 0;
        for (int i=0;i<scores.length;i++){
            seniorityScore = seniorityScore + scores[i];
        }
        tvSeniorityScore = (TextView) findViewById(R.id.tvSeniorityScore);
        tvSeniorityScore.setText(Integer.toString(seniorityScore));
        showCategory(seniorityScore);
        //Log.d("TAG", "Score from leadership experience ->>>>: " + scores[5] + " lalala");
    }

    public void showCategory(int seniorityScore){
        tvSeniorityCategory = (TextView) findViewById(R.id.tvSeniorityCategory);
        if (seniorityScore > 0 && seniorityScore <= 105){
            tvSeniorityCategory.setText("Eng 1");
        }
        if (seniorityScore > 105 && seniorityScore <= 180){
            tvSeniorityCategory.setText("Eng 2");
        }
        if (seniorityScore > 180 && seniorityScore <= 265){
            tvSeniorityCategory.setText("Eng 3");
        }
        if (seniorityScore > 265 && seniorityScore <= 395){
            tvSeniorityCategory.setText("SR A");
        }
        if (seniorityScore > 395 && seniorityScore <= 460){
            tvSeniorityCategory.setText("SR B");
        }
        if (seniorityScore > 460 && seniorityScore <= 535){
            tvSeniorityCategory.setText("SR C/SME A");
        }
        if (seniorityScore > 535 && seniorityScore <= 660){
            tvSeniorityCategory.setText("SR D/SME B");
        }
    }
}
