package com.antoniofb.seniorityappfinal.management;

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
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

public class ManagementActivity extends AppCompatActivity {

    private String[] managementOptions = {"Task are assigned objetivectly",
            "Task to an issue tracker",
            "Receives a lot of tasks",
            "Participates actively in meetings",
            "Coaches 6-12 people",
            "Coaches more than 12 people"
    };
    private ListView lvManagement;
    private int managementScore = 0, managementPercentage = 20;
    private int[] scores;
    private Intent intent;
    private int[] managementScores = {0,1,2,3,4,5,6,7,8,9,10};
    private int arrowId = R.drawable.arrow_icon;

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
        CustomListAdapterManagement customListAdapterManagement = new CustomListAdapterManagement(this, managementOptions, arrowId);
        lvManagement = (ListView) findViewById(R.id.lvManagementList);
        lvManagement.setAdapter(customListAdapterManagement);
        intent = new Intent(this, FactorsActivity.class);
        lvManagement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    managementScore = managementScores[0] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("MO", managementOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    managementScore = managementScores[1] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("MO", managementOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    managementScore = managementScores[2] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("MO", managementOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 3){
                    managementScore = managementScores[3] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("MO", managementOptions[3] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 4){
                    managementScore = managementScores[4] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("MO", managementOptions[4] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 5){
                    managementScore = managementScores[5] * managementPercentage;
                    scores[2] = managementScore;
                    intent.putExtra("MO", managementOptions[5] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
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
