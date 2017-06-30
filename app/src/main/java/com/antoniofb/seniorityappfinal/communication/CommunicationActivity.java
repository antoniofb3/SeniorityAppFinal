package com.antoniofb.seniorityappfinal.communication;

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

public class CommunicationActivity extends AppCompatActivity {

    private String[] management = {"Basic Interaction", "Task are assigned to an issue tracker", "Receives a lot of tasks", "3 or more years of experience", "4 or more years of experience"};
    private ListView lvCommunication;
    private int communicationScore = 0, communicationPercentage = 15;
    private int[] scores;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
        setActionBarTitle();
        showManagementList();
        acumulateScores();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Communication Screen");
    }

    public void showManagementList(){
        lvCommunication = (ListView) findViewById(R.id.lvCommunicationList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,management);
        lvCommunication.setAdapter(adapter);
        intent = new Intent(this, CommunicationActivity.class);
        lvCommunication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    communicationScore = 0 * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("BI", scores);
                    startActivity(intent);
                    //startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                }
            }
        });
    }

    public void acumulateScores(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("TAO");
        Log.d("TAG", "Score from experience ->>>>: " + scores[2] + " lalala");
    }
}
