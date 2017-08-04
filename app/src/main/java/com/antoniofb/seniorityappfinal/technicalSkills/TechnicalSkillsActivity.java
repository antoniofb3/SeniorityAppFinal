package com.antoniofb.seniorityappfinal.technicalSkills;

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
    private Intent intent;
    private int[] technicalSkillsScores = {1,2,3,4,5,6,7,8,9};
    private int checkedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_skills);
        setBarOptions();
        showManagementList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_technical_skills, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,TechnicalSkillsHelpActivity.class));
                break;

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setBarOptions(){
        getSupportActionBar().setTitle("Technical Skills");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        lvSkills = (ListView) findViewById(R.id.lvSkillsList);
        CustomListAdapterTechnicalSkills customListAdapterTechnicalSkills = new CustomListAdapterTechnicalSkills(this, technicalSkillsOptions, checkedId);
        lvSkills.setAdapter(customListAdapterTechnicalSkills);
        intent = new Intent(this, FactorsActivity.class);
        lvSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0; i<technicalSkillsOptions.length; i++){
                    if (position == i){
                        skillsScore = technicalSkillsScores[i] * skillsPercentage;
                        intent.putExtra("TSON", skillsScore);
                        intent.putExtra("TSO", technicalSkillsOptions[i] );
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }
            }
        });
    }
}
