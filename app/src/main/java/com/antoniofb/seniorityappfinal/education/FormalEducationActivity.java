package com.antoniofb.seniorityappfinal.education;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

public class FormalEducationActivity extends AppCompatActivity {

    private String[] educationOptions = {"Incomplete Terciary Education", "Incomplete Bachelor", "Bachelor", "Graduated + Especializated", "Master"};
    private ListView lvEducationOptions;
    private int educationScore = 0, educationPercentage = 5;
    private int[] scores = new int[7];
    private Intent intent;
    private int[] educationScores = {1,2,3,5,6};
    private int checkedId = R.drawable.checked_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal_education);
        setActionBarTitle();
        setupGUI();
        showEducationList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_formal_education, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.helpButton){
            startActivity(new Intent(this,FormalEducationHelpActivity.class));
        }
        return true;
    }

    public void setupGUI(){
        lvEducationOptions = (ListView) findViewById(R.id.lvFormalEducationList);
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Formal Education");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showEducationList(){
        CustomListAdapterFormalEducation customListAdapterFormalEducation = new CustomListAdapterFormalEducation(this, educationOptions, checkedId);
        lvEducationOptions.setAdapter(customListAdapterFormalEducation);
        intent = new Intent(this,FactorsActivity.class);
        lvEducationOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    educationScore = educationScores[0] * educationPercentage;
                    scores[0] = educationScore;
                    intent.putExtra("FEO", educationOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    educationScore = educationScores[1] * educationPercentage;
                    scores[0] = educationScore;
                    intent.putExtra("FEO", educationOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    educationScore = educationScores[2] * educationPercentage;
                    scores[0] = educationScore;
                    intent.putExtra("FEO", educationOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 3){
                    educationScore = educationScores[3] * educationPercentage;
                    scores[0] = educationScore;
                    intent.putExtra("FEO", educationOptions[3] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 4){
                    educationScore = educationScores[4] * educationPercentage;
                    scores[0] = educationScore;
                    intent.putExtra("FEO", educationOptions[4] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}
