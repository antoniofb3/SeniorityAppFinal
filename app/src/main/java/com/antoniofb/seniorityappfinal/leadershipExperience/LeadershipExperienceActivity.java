package com.antoniofb.seniorityappfinal.leadershipExperience;

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
import com.antoniofb.seniorityappfinal.empowerment.EmpowermentActivity;

public class LeadershipExperienceActivity extends AppCompatActivity {

    private String[] leadershipExperience = {"Without experience", "1 or more years of experience", "2 or more years of experience", "3 or more years of experience", "4 or more years of experience", "5 or more years of experience"};
    private ListView lvLeadershipExperience;
    private int leadershipScore = 1, leadershipPercentage = 20;
    private int[] scores;
    private Intent intent;
    private int[] leadershipScores = {0,1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leadership_experience);
        setActionBarTitle();
        showManagementList();
        acumulateScores();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Leadership Experience");
    }

    public void showManagementList(){
        lvLeadershipExperience = (ListView) findViewById(R.id.lvLeadershipList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,leadershipExperience);
        lvLeadershipExperience.setAdapter(adapter);
        intent = new Intent(this, EmpowermentActivity.class);
        lvLeadershipExperience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    leadershipScore = leadershipScores[0] * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                }
                if (position == 1){
                    leadershipScore = leadershipScores[1] * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                }
                if (position == 2){
                    leadershipScore = leadershipScores[2] * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                }
                if (position == 3){
                    leadershipScore = leadershipScores[3] * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                }
                if (position == 4){
                    leadershipScore = leadershipScores[4] * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                }
                if (position == 5){
                    leadershipScore = leadershipScores[5] * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                }
            }
        });
    }

    public void acumulateScores(){
        Intent intent = getIntent();
        if (intent.hasExtra("LK")) {
            Bundle bundle = getIntent().getExtras();
            scores = bundle.getIntArray("LK");
            Log.d("TAG", "Score from technical skills ->>>>: " + scores[4] + " lalala");
        }
        else {
            scores = new int[7];
        }
    }
}
