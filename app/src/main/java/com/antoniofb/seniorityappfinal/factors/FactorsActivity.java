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
import com.antoniofb.seniorityappfinal.education.FormalEducationActivity;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.management.ManagementActivity;

public class FactorsActivity extends AppCompatActivity {

    private TextView tvEmpData;
    private ListView lvFactors;
    private String[] factors = {"Formal Education", "Experience", "Management", "Communication", "Technical Skills", "Leadership Experience", "Empowerment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        setActionBarTitle();
        showEmployeeData();
        showFactorsList();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Factors Screen");
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

    public void showFactorsList(){
        lvFactors = (ListView) findViewById(R.id.lvFactorsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,factors);
        lvFactors.setAdapter(adapter);
        lvFactors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(FactorsActivity.this, FormalEducationActivity.class));
                }
                if (position == 1){
                    startActivity(new Intent(FactorsActivity.this, ExperienceActivity.class));
                }
                if (position == 2){
                    startActivity(new Intent(FactorsActivity.this, ManagementActivity.class));
                }
            }
        });
    }
}
