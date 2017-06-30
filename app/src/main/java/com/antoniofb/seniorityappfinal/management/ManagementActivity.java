package com.antoniofb.seniorityappfinal.management;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;

public class ManagementActivity extends AppCompatActivity {

    private String[] management = {"Task are assigned objetivectly", "Task are assigned to an issue tracker", "Receives a lot of tasks", "3 or more years of experience", "4 or more years of experience"};
    private ListView lvManagement;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        setActionBarTitle();
        showExperienceList();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Management Screen");
    }

    public void showExperienceList(){
        lvManagement = (ListView) findViewById(R.id.lvManagementList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,management);
        lvManagement.setAdapter(adapter);
        lvManagement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                    score = 0;
                }
            }
        });
    }
}
