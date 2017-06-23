package com.antoniofb.seniorityappfinal.factors;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;

public class FactorsActivity extends AppCompatActivity {

    private TextView tvEmpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        setActionBarTitle();
        showEmployeeData();
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
}
