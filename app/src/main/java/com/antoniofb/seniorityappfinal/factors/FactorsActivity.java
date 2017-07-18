package com.antoniofb.seniorityappfinal.factors;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.education.FormalEducationActivity;
import com.antoniofb.seniorityappfinal.empowerment.EmpowermentActivity;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.leadershipExperience.LeadershipExperienceActivity;
import com.antoniofb.seniorityappfinal.management.ManagementActivity;
import com.antoniofb.seniorityappfinal.technicalSkills.TechnicalSkillsActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        setActionBarTitle();
        //showEmployeeData();
        showFactorsList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Factors");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showEmployeeData(){
        Bundle bundle = getIntent().getExtras();
        String[] empData = {bundle.getString("Name"), bundle.getString("Job"), bundle.getString("Seniority")};
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeName);
        tvEmpData.setText(empData[0]);
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeJob);
        tvEmpData.setText(empData[1]);
        tvEmpData = (TextView) findViewById(R.id.tvEmployeeSeniority);
        tvEmpData.setText(empData[2]);
    }

    private void showFactorsList(){
        CustomListAdapterFactors customListAdapter = new CustomListAdapterFactors(this, factors, factorsChosen, imagesIds, arrowId);
        lvFactors = (ListView) findViewById(R.id.lvFactorsList);
        lvFactors.setAdapter(customListAdapter);
        lvFactors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    startActivity(new Intent(FactorsActivity.this, FormalEducationActivity.class));
                }
                if (position == 1){
                    startActivity(new Intent(FactorsActivity.this, ExperienceActivity.class));
                }
                if (position == 2){
                    startActivity(new Intent(FactorsActivity.this, ManagementActivity.class));
                }
                if (position == 3){
                    startActivity(new Intent(FactorsActivity.this, CommunicationActivity.class));
                }
                if (position == 4){
                    startActivity(new Intent(FactorsActivity.this, TechnicalSkillsActivity.class));
                }
                if (position == 5){
                    startActivity(new Intent(FactorsActivity.this, LeadershipExperienceActivity.class));
                }
                if (position == 6){
                    startActivity(new Intent(FactorsActivity.this, EmpowermentActivity.class));
                }
            }
        });
    }

    public void checkValue(){

    }
}
