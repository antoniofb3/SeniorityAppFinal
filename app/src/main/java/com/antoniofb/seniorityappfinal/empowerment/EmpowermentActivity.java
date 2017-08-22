package com.antoniofb.seniorityappfinal.empowerment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.antoniofb.seniorityappfinal.results.SummaryActivity;

public class EmpowermentActivity extends AppCompatActivity {

    private String[] empowermentOptions = {"High", "Medium", "Low"};
    private ListView lvEmpowerment;
    private int empowermentScore = 0, empowermentPercentage = 10;
    private Intent intent;
    private int[] empowermentScores = {0,1,2,3,4,5,6,7,8,9};
    private int checkedId = R.drawable.checked_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empowerment);
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
        getMenuInflater().inflate(R.menu.menu_empowerment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,EmpowermentHelpActivity.class));
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
                for (int i=0; i<empowermentOptions.length; i++){
                    if (position == i){
                        savePosition(position);
                        empowermentScore = empowermentScores[i] * empowermentPercentage;
                        intent.putExtra("EON", empowermentScore);
                        intent.putExtra("EO", empowermentOptions[i] );
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }
            }
        });
    }

    public void savePosition(int position){
        SharedPreferences sharedPref = getSharedPreferences("EOptions", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("selected_position", position);
        editor.apply();
    }
}
