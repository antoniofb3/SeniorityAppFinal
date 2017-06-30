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

    private String[] leadershipExperience = {"Without experience", "1 or more years of experience", "Receives a lot of tasks", "3 or more years of experience", "4 or more years of experience"};
    private ListView lvLeadershipExperience;
    private int leadershipScore = 1, leadershipPercentage = 20;
    private int[] scores;
    private Intent intent;

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
                    leadershipScore = 0 * leadershipPercentage;
                    scores[5] = leadershipScore;
                    intent.putExtra("LEWE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                }
            }
        });
    }

    public void acumulateScores(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("LK");
        Log.d("TAG", "Score from technical skills ->>>>: " + scores[4] + " lalala");
    }
}
