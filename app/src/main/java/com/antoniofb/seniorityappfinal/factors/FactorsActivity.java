package com.antoniofb.seniorityappfinal.factors;

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
import android.widget.TextView;
import android.widget.Toast;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.education.FormalEducationActivity;
import com.antoniofb.seniorityappfinal.empowerment.EmpowermentActivity;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.leadershipExperience.LeadershipExperienceActivity;
import com.antoniofb.seniorityappfinal.management.ManagementActivity;
import com.antoniofb.seniorityappfinal.results.SummaryActivity;
import com.antoniofb.seniorityappfinal.technicalSkills.TechnicalSkillsActivity;

import java.util.ArrayList;

public class FactorsActivity extends AppCompatActivity {

    private TextView tvEmpData;
    private ListView lvFactors;
    private String[] factors = {
            "Formal Education",
            "Experience",
            "Management",
            "Communication",
            "Technical Skills",
            "Leadership Experience",
            "Empowerment"
    };
    private String[] factorsChosen = new String[7];
    private Integer[] imagesIds = {
            R.drawable.education_icon,
            R.drawable.experience_icon,
            R.drawable.management_icon,
            R.drawable.communication_icon,
            R.drawable.technical_skills_icon,
            R.drawable.leadership_experience_icon,
            R.drawable.empowerment_icon
    };
    private int arrowId = R.drawable.arrow_icon;
    private Intent intent;
    private CustomListAdapterFactors customListAdapter;
    private int[] scoresFactors = {-1,-1,-1,-1,-1,-1,-1};//new int[7];
    private int scoreFactor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        setActionBarTitle();
        setupGUI();
        //showEmployeeData();
        showFactorsList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_factors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.calculateButton:
                saveScoresToSummary();
                break;

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Seniority Belatrix");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupGUI(){
        lvFactors = (ListView) findViewById(R.id.lvFactorsList);
    }

    public void showEmployeeData(){
        /*
        Bundle bundle = getIntent().getExtras();
        String[] empData = {bundle.getString("Name"), bundle.getString("Job"), bundle.getString("Seniority")};
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeName);
        tvEmpData.setText(empData[0]);
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeJob);
        tvEmpData.setText(empData[1]);
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeSeniority);
        tvEmpData.setText(empData[2]);
        */
    }

    private void showFactorsList(){
        customListAdapter = new CustomListAdapterFactors(this, factors, factorsChosen, imagesIds, arrowId);
        lvFactors.setAdapter(customListAdapter);
        lvFactors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    intent = new Intent(FactorsActivity.this,FormalEducationActivity.class);
                    startActivityForResult(intent, 1);
                }
                if (position == 1){
                    intent = new Intent(FactorsActivity.this,ExperienceActivity.class);
                    startActivityForResult(intent, 2);
                }
                if (position == 2){
                    intent = new Intent(FactorsActivity.this,ManagementActivity.class);
                    startActivityForResult(intent, 3);
                }
                if (position == 3){
                    intent = new Intent(FactorsActivity.this,CommunicationActivity.class);
                    startActivityForResult(intent, 4);
                }
                if (position == 4){
                    intent = new Intent(FactorsActivity.this,TechnicalSkillsActivity.class);
                    startActivityForResult(intent, 5);
                }
                if (position == 5){
                    intent = new Intent(FactorsActivity.this,LeadershipExperienceActivity.class);
                    startActivityForResult(intent, 6);
                }
                if (position == 6){
                    intent = new Intent(FactorsActivity.this,EmpowermentActivity.class);
                    startActivityForResult(intent, 7);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[0] = data.getIntExtra("FEON",scoreFactor);
                String formalEducationOption = data.getStringExtra("FEO");
                factorsChosen[0] = formalEducationOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 2){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[1] = data.getIntExtra("PEON",scoreFactor);
                String previousExperienceOption = data.getStringExtra("PEO");
                factorsChosen[1] = previousExperienceOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 3){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[2] = data.getIntExtra("MON",scoreFactor);
                String managementOption = data.getStringExtra("MO");
                factorsChosen[2] = managementOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 4){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[3] = data.getIntExtra("CON",scoreFactor);
                String communicationOption = data.getStringExtra("CO");
                factorsChosen[3] = communicationOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 5){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[4] = data.getIntExtra("TSON",scoreFactor);
                String technicalSkillsOption = data.getStringExtra("TSO");
                factorsChosen[4] = technicalSkillsOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 6){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[5] = data.getIntExtra("LEON",scoreFactor);
                String leadershipExperienceOption = data.getStringExtra("LEO");
                factorsChosen[5] = leadershipExperienceOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 7){
            if (resultCode == Activity.RESULT_OK){
                scoresFactors[6] = data.getIntExtra("EON",scoreFactor);
                String empowermentOption = data.getStringExtra("EO");
                factorsChosen[6] = empowermentOption;
                customListAdapter.notifyDataSetChanged();
            }
        }
    }

    public void saveScoresToSummary(){
        if (checkArrayContent()) {
            intent = new Intent(this, SummaryActivity.class);
            intent.putExtra("AllScores", scoresFactors);
            startActivity(intent);
        }
    }

    public boolean checkArrayContent(){
        String message = "";
        int counter = 0;
        for (int i=0; i<scoresFactors.length; i++){
            if (scoresFactors[i] < 0){
                message = message + "\n" + factors[i];
                counter++;
            }
        }
        if (counter > 0){
            Toast.makeText(this,"Missing score for: " + message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
