package com.antoniofb.seniorityappfinal.education;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

public class FormalEducationActivity extends AppCompatActivity {

    private String[] education = {"Incomplete Terciary Education", "Incomplete Bachelor", "Bachelor", "Graduated + Especializated", "Master"};
    private ListView lvEducation;
    private int educationScore = 0, educationPercentage = 5;
    private int[] scores = new int[7];
    private Intent intent;
    private int[] educationScores = {1,2,3,5,6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal_education);
        setActionBarTitle();
        showEducationList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Formal Education");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showEducationList(){
        lvEducation = (ListView) findViewById(R.id.lvFormalEducationList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,education);
        lvEducation.setAdapter(adapter);//me salio el mismo error de null el adapter, lo arregle poniendo bien el findViewById
        intent = new Intent(this,FactorsActivity.class);
        lvEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    educationScore = educationScores[0] * educationPercentage;
                    scores[0] = educationScore;//always position 0
                    intent.putExtra("ITE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(FormalEducationActivity.this,ExperienceActivity.class));
                }
                if (position == 1){
                    educationScore = educationScores[1] * educationPercentage;
                    scores[0] = educationScore;//always position 0
                    intent.putExtra("ITE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(FormalEducationActivity.this,ExperienceActivity.class));
                }
                if (position == 2){
                    educationScore = educationScores[2] * educationPercentage;
                    scores[0] = educationScore;//always position 0
                    intent.putExtra("ITE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(FormalEducationActivity.this,ExperienceActivity.class));
                }
                if (position == 3){
                    educationScore = educationScores[3] * educationPercentage;
                    scores[0] = educationScore;//always position 0
                    intent.putExtra("ITE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(FormalEducationActivity.this,ExperienceActivity.class));
                }
                if (position == 4){
                    educationScore = educationScores[4] * educationPercentage;
                    scores[0] = educationScore;//always position 0
                    intent.putExtra("ITE", scores);
                    startActivity(intent);
                    //startActivity(new Intent(FormalEducationActivity.this,ExperienceActivity.class));
                }
            }
        });
    }
}
