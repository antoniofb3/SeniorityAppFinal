package com.antoniofb.seniorityappfinal.management;

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
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

public class ManagementActivity extends AppCompatActivity {

    private String[] managementOptions = {"Task are assigned objetivectly",
            "Task to an issue tracker",
            "Receives a lot of tasks",
            "Participates actively in meetings",
            "Coaches 6-12 people",
            "Coaches more than 12 people"
    };
    private ListView lvManagement;
    private int managementScore = 0, managementPercentage = 20;
    private Intent intent;
    private int[] managementScores = {0,1,2,3,4,5,6,7,8,9,10};
    private int checkedId = R.drawable.checked_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
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
        getMenuInflater().inflate(R.menu.menu_management, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,ManagementHelpActivity.class));
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
        getSupportActionBar().setTitle("Management");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        CustomListAdapterManagement customListAdapterManagement = new CustomListAdapterManagement(this, managementOptions, checkedId);
        lvManagement = (ListView) findViewById(R.id.lvManagementList);
        lvManagement.setAdapter(customListAdapterManagement);
        intent = new Intent(this, FactorsActivity.class);
        lvManagement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0; i<managementOptions.length; i++){
                    if (position == i){
                        savePosition(position);
                        managementScore = managementScores[i] * managementPercentage;
                        intent.putExtra("MON", managementScore);
                        intent.putExtra("MO", managementOptions[i] );
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }
            }
        });
    }

    public void savePosition(int position){
        SharedPreferences sharedPref = getSharedPreferences("MOptions", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("selected_position", position);
        editor.apply();
    }
}
