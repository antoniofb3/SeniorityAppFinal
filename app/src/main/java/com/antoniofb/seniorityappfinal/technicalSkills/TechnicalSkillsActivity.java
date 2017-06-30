package com.antoniofb.seniorityappfinal.technicalSkills;

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
import com.antoniofb.seniorityappfinal.leadershipExperience.LeadershipExperienceActivity;

public class TechnicalSkillsActivity extends AppCompatActivity {

    private String[] skills = {"Little knowledge", "Knows some", "Receives a lot of tasks", "3 or more years of experience", "4 or more years of experience"};
    private ListView lvSkills;
    private int skillsScore = 1, skillsPercentage = 20;
    private int[] scores;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_skills);
        setActionBarTitle();
        showManagementList();
        acumulateScores();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Technical Skills");
    }

    public void showManagementList(){
        lvSkills = (ListView) findViewById(R.id.lvSkillsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,skills);
        lvSkills.setAdapter(adapter);
        intent = new Intent(this, LeadershipExperienceActivity.class);
        lvSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    skillsScore = 1 * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("LK", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                }
            }
        });
    }

    public void acumulateScores(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("BI");
        Log.d("TAG", "Score from communication ->>>>: " + scores[3] + " lalala");
    }
}
