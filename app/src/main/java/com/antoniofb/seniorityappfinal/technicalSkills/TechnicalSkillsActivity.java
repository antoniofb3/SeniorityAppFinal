package com.antoniofb.seniorityappfinal.technicalSkills;

import android.app.Activity;
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
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;
import com.antoniofb.seniorityappfinal.leadershipExperience.LeadershipExperienceActivity;

public class TechnicalSkillsActivity extends AppCompatActivity {

    private String[] technicalSkillsOptions = {
            "Little knowledge",
            "Knows some programming language",
            "Knows and uses some of the best know namespaces",
            "Has a good knowledge of the namespaces",
            "Has a sustained and predictable productivity",
            "Is highly predictable with a sustained productivity"
    };
    private ListView lvSkills;
    private int skillsScore = 1, skillsPercentage = 20;
    private int[] scores;
    private Intent intent;
    private int[] technicalSkillsScores = {1,2,3,4,5,6,7,8,9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_skills);
        setActionBarTitle();
        showManagementList();
        acumulateScores();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Technical Skills");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        lvSkills = (ListView) findViewById(R.id.lvSkillsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,technicalSkillsOptions);
        lvSkills.setAdapter(adapter);
        intent = new Intent(this, FactorsActivity.class);
        lvSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    skillsScore = technicalSkillsScores[0] * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("TSO", technicalSkillsOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    skillsScore = technicalSkillsScores[1] * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("TSO", technicalSkillsOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    skillsScore = technicalSkillsScores[2] * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("TSO", technicalSkillsOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 3){
                    skillsScore = technicalSkillsScores[3] * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("TSO", technicalSkillsOptions[3] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 4){
                    skillsScore = technicalSkillsScores[4] * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("TSO", technicalSkillsOptions[4] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 5){
                    skillsScore = technicalSkillsScores[5] * skillsPercentage;
                    scores[4] = skillsScore;
                    intent.putExtra("TSO", technicalSkillsOptions[5] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    public void acumulateScores(){
        Intent intent = getIntent();
        if (intent.hasExtra("BI")) {
            Bundle bundle = getIntent().getExtras();
            scores = bundle.getIntArray("BI");
            Log.d("TAG", "Score from communication ->>>>: " + scores[3] + " lalala");
        }
        else {
            scores = new int[7];
        }
    }
}
