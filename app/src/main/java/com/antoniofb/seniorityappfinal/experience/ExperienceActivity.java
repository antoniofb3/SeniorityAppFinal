package com.antoniofb.seniorityappfinal.experience;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.empowerment.EmpowermentActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;
import com.antoniofb.seniorityappfinal.management.ManagementActivity;
import com.antoniofb.seniorityappfinal.results.SummaryActivity;

public class ExperienceActivity extends AppCompatActivity {

    private String[] workExperienceOptions = {"Without Experience", "1 or more year of experience", "2 or more years of experience", "3 or more years of experience", "4 or more years of experience", "5 or more years of experience", "6 or more years of experience"};
    private ListView lvExperience;
    private int experienceScore = 0, educationScore = 0, experiencePercentage = 20;
    private int[] scores;
    private Intent intent;
    private int[] experienceScores = {0,1,2,3,4,5,6,7,8,9,10};
    private int arrowId;// = R.drawable.arrow_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        setActionBarTitle();
        setupGUI();
        showExperienceList();
        acumulateScores();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_previous_experience, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,PreviousExperienceHelpActivity.class));
                break;

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setupGUI(){
        lvExperience = (ListView) findViewById(R.id.lvExperienceList);
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Experience Screen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showExperienceList(){
        CustomListAdapterWorkExperience customListAdapterWorkExperience = new CustomListAdapterWorkExperience(this,workExperienceOptions, arrowId );
        lvExperience.setAdapter(customListAdapterWorkExperience);
        intent = new Intent(this, FactorsActivity.class);
        lvExperience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    experienceScore = experienceScores[0] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    experienceScore = experienceScores[1] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    experienceScore = experienceScores[2] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 3){
                    experienceScore = experienceScores[3] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[3] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 4){
                    experienceScore = experienceScores[4] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[4] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 5){
                    experienceScore = experienceScores[5] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[5] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 6){
                    experienceScore = experienceScores[6] * experiencePercentage;
                    scores[1] = experienceScore;
                    intent.putExtra("PEO", workExperienceOptions[6] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
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
