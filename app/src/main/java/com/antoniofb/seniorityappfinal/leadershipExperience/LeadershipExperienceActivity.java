package com.antoniofb.seniorityappfinal.leadershipExperience;

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
import com.antoniofb.seniorityappfinal.empowerment.EmpowermentActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

public class LeadershipExperienceActivity extends AppCompatActivity {

    private String[] leadershipExperienceOptions = {"Without experience", "1 or more years of experience", "2 or more years of experience", "3 or more years of experience", "4 or more years of experience", "5 or more years of experience"};
    private ListView lvLeadershipExperience;
    private int leadershipScore = 1, leadershipPercentage = 20;
    private Intent intent;
    private int[] leadershipScores = {0,1,2,3,4,5,6,7,8,9,10};
    private int checkedId = R.drawable.checked_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leadership_experience);
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
        getMenuInflater().inflate(R.menu.menu_leadership_experience, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,LeadershipExperienceHelpActivity.class));
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
        getSupportActionBar().setTitle("Leadership Experience");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        lvLeadershipExperience = (ListView) findViewById(R.id.lvLeadershipList);
        CustomListAdapterLeadershipExperience customListAdapterLeadershipExperience = new CustomListAdapterLeadershipExperience(this, leadershipExperienceOptions, checkedId);
        lvLeadershipExperience.setAdapter(customListAdapterLeadershipExperience);
        intent = new Intent(this, FactorsActivity.class);
        lvLeadershipExperience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0; i<leadershipExperienceOptions.length; i++){
                    if (position == i){
                        savePosition(position);
                        leadershipScore = leadershipScores[i] * leadershipPercentage;
                        intent.putExtra("LEON", leadershipScore);
                        intent.putExtra("LEO", leadershipExperienceOptions[i] );
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }
            }
        });
    }

    public void savePosition(int position){
        SharedPreferences sharedPref = getSharedPreferences("LEOptions", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("selected_position", position);
        editor.apply();
    }
}
