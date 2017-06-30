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
import com.antoniofb.seniorityappfinal.management.ManagementActivity;
import com.antoniofb.seniorityappfinal.results.SummaryActivity;

public class ExperienceActivity extends AppCompatActivity {

    private String[] experience = {"Without Experience", "1 or more year of experience", "2 or more years of experience", "3 or more years of experience", "4 or more years of experience"};
    private ListView lvExperience;
    private int experienceScore = 0, educationScore = 0, experiencePercentage = 20;
    private int[] scores;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        setActionBarTitle();
        showExperienceList();
        acumulateScores();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Experience Screen");
    }

    public void showExperienceList(){
        lvExperience = (ListView) findViewById(R.id.lvExperienceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,experience);
        lvExperience.setAdapter(adapter);
        intent = new Intent(this, ManagementActivity.class);
        lvExperience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    experienceScore = 0 * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("WOE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ExperienceActivity.this,SummaryActivity.class));
                }
            }
        });
    }

    public void acumulateScores(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("ITE");
        Log.d("TAG", "Score from education ->>>>: " + scores[0] + " lalala");
    }
}
