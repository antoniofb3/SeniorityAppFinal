package com.antoniofb.seniorityappfinal.experience;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;
import com.antoniofb.seniorityappfinal.management.ManagementActivity;
import com.antoniofb.seniorityappfinal.results.SummaryActivity;

public class ExperienceActivity extends AppCompatActivity {

    private String[] experience = {"Without Experience", "1 or more year of experience", "2 or more years of experience", "3 or more years of experience", "4 or more years of experience", "5 or more years of experience", "6 or more years of experience"};
    private ListView lvExperience;
    private int experienceScore = 0, educationScore = 0, experiencePercentage = 20;
    private int[] scores;
    private Intent intent;
    private int[] experienceScores = {0,1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        setActionBarTitle();
        showExperienceList();
        acumulateScores();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Experience Screen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showExperienceList(){
        lvExperience = (ListView) findViewById(R.id.lvExperienceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,experience);
        lvExperience.setAdapter(adapter);
        intent = new Intent(this, FactorsActivity.class);
        lvExperience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    experienceScore = experienceScores[0] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ExperienceActivity.this,SummaryActivity.class));
                }
                if (position == 1){
                    experienceScore = experienceScores[1] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ExperienceActivity.this,SummaryActivity.class));
                }
                if (position == 2){
                    experienceScore = experienceScores[2] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ExperienceActivity.this,SummaryActivity.class));
                }
                if (position == 3){
                    experienceScore = experienceScores[3] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ExperienceActivity.this,SummaryActivity.class));
                }
                if (position == 4){
                    experienceScore = experienceScores[4] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ExperienceActivity.this,SummaryActivity.class));
                }
                if (position == 5){
                    experienceScore = experienceScores[5] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                }
                if (position == 6){
                    experienceScore = experienceScores[6] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                }
            }
        });
    }

    public void acumulateScores(){
        Intent intent = getIntent();
        if (intent.hasExtra("FEO")) {
            Bundle bundle = getIntent().getExtras();
            scores = bundle.getIntArray("FEO");
            Log.d("TAG", "Score from education ->>>>: " + scores[0] + " lalala");
        }
        else {
            scores = new int[7];//I have to change this because it can delete the previous scores registered
        }
    }
}
