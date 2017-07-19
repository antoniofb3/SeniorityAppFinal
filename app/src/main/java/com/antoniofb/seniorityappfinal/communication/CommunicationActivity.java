package com.antoniofb.seniorityappfinal.communication;

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
import com.antoniofb.seniorityappfinal.technicalSkills.TechnicalSkillsActivity;

public class CommunicationActivity extends AppCompatActivity {

    private String[] communicationOptions = {"Basic Interaction", "Basic Interaction: In the scrums and can answer questions to the external customer", "Frequent contact with the client", "Operational roles with outstanding management", "Negotiation of technical issues", "Gives talks and/or courses"};
    private ListView lvCommunication;
    private int communicationScore = 0, communicationPercentage = 15;
    private int[] scores;
    private Intent intent;
    private int[] communicationScores = {1,2,3,4,5,6,7,8,9,10};
    private int checkedId; //= R.drawable.checked_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
        setActionBarTitle();
        showManagementList2();
        acumulateScores();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Communication");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList2(){
        lvCommunication = (ListView) findViewById(R.id.lvCommunicationList);
        CustomListAdapterCommunication customListAdapterCommunication = new CustomListAdapterCommunication(this, communicationOptions, checkedId);
        lvCommunication.setAdapter(customListAdapterCommunication);
        intent = new Intent(this, FactorsActivity.class);
        lvCommunication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    communicationScore = communicationScores[0] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    communicationScore = communicationScores[1] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    communicationScore = communicationScores[2] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 3){
                    communicationScore = communicationScores[3] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[3] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 4){
                    communicationScore = communicationScores[4] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[4] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position ==5){
                    communicationScore = communicationScores[5] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[5] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    public void showManagementList(){
        lvCommunication = (ListView) findViewById(R.id.lvCommunicationList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,communicationOptions);
        lvCommunication.setAdapter(adapter);
        intent = new Intent(this, FactorsActivity.class);
        lvCommunication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    communicationScore = communicationScores[0] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    communicationScore = communicationScores[1] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    communicationScore = communicationScores[2] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 3){
                    communicationScore = communicationScores[3] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[3] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 4){
                    communicationScore = communicationScores[4] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[4] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position ==5){
                    communicationScore = communicationScores[5] * communicationPercentage;
                    scores[3] = communicationScore;
                    intent.putExtra("CO", communicationOptions[5] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    public void acumulateScores(){
        Intent intent = getIntent();
        if (intent.hasExtra("TAO")) {
            Bundle bundle = getIntent().getExtras();
            scores = bundle.getIntArray("TAO");
            Log.d("TAG", "Score from management ->>>>: " + scores[2] + " lalala");
        }
        else {
            scores = new int[7];
        }
    }
}
