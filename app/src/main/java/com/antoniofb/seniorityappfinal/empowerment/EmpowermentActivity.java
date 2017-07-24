package com.antoniofb.seniorityappfinal.empowerment;

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
import com.antoniofb.seniorityappfinal.results.SummaryActivity;

public class EmpowermentActivity extends AppCompatActivity {

    private String[] empowermentOptions = {"High", "Medium", "Low"};
    private ListView lvEmpowerment;
    private int empowermentScore = 0, empowermentPercentage = 10;
    private Intent intent;
    private int[] empowermentScores = {0,1,2,3,4,5,6,7,8,9};
    private int checkedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empowerment);
        setActionBarTitle();
        showManagementList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setActionBarTitle(){
        getSupportActionBar().setTitle("Empowerment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        lvEmpowerment = (ListView) findViewById(R.id.lvEmpowermentList);
        CustomListAdapterEmpowerment customListAdapterEmpowerment = new CustomListAdapterEmpowerment(this, empowermentOptions, checkedId);
        lvEmpowerment.setAdapter(customListAdapterEmpowerment);
        intent = new Intent(this, FactorsActivity.class);
        lvEmpowerment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    empowermentScore = empowermentScores[0] * empowermentPercentage;
                    intent.putExtra("EON", empowermentScore);
                    intent.putExtra("EO", empowermentOptions[0] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 1){
                    empowermentScore = empowermentScores[1] * empowermentPercentage;
                    intent.putExtra("EON", empowermentScore);
                    intent.putExtra("EO", empowermentOptions[1] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                if (position == 2){
                    empowermentScore = empowermentScores[2] * empowermentPercentage;
                    intent.putExtra("EON", empowermentScore);
                    intent.putExtra("EO", empowermentOptions[2] );
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}
