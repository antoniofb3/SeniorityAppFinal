package com.antoniofb.seniorityappfinal.management;

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

public class ManagementActivity extends AppCompatActivity {

    private String[] management = {"Task are assigned objetivectly", "Task are assigned to an issue tracker", "Receives a lot of tasks", "Participates actively in planning meetings", "Coaches with permanent contact, 6-12 people", "Coaches with permanent contact, more than 12 people"};
    private ListView lvManagement;
    private int managementScore = 0, managementPercentage = 20;
    private int[] scores;
    private Intent intent;
    private int[] managementScores = {0,1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
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
        getSupportActionBar().setTitle("Management");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        lvManagement = (ListView) findViewById(R.id.lvManagementList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,management);
        lvManagement.setAdapter(adapter);
        intent = new Intent(this, FactorsActivity.class);
        lvManagement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    managementScore = managementScores[0] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("TAO", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                }
                if (position == 1){
                    managementScore = managementScores[1] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("TAO", scores);
                    startActivity(intent);
                }
                if (position == 2){
                    managementScore = managementScores[2] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("TAO", scores);
                    startActivity(intent);
                }
                if (position == 3){
                    managementScore = managementScores[3] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("TAO", scores);
                    startActivity(intent);
                }
                if (position == 4){
                    managementScore = managementScores[4] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("TAO", scores);
                    startActivity(intent);
                }
                if (position == 5){
                    managementScore = managementScores[5] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("TAO", scores);
                    startActivity(intent);
                }
            }
        });
    }

    public void acumulateScores(){
        Intent intent = getIntent();
        if (intent.hasExtra("WOE")) {
            Bundle bundle = getIntent().getExtras();
            scores = bundle.getIntArray("WOE");
            Log.d("TAG", "Score from experience ->>>>: " + scores[1] + " lalala");
        }
        else {
            scores = new int[7];
        }
    }
}
