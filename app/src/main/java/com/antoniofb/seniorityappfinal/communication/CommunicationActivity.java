package com.antoniofb.seniorityappfinal.communication;

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
import com.antoniofb.seniorityappfinal.technicalSkills.TechnicalSkillsActivity;

public class CommunicationActivity extends AppCompatActivity {

    private String[] communicationOptions = {"Basic Interaction", "Basic Interaction: In the scrums and can answer questions to the external customer", "Frequent contact with the client", "Operational roles with outstanding management", "Negotiation of technical issues", "Gives talks and/or courses"};
    private ListView lvCommunication;
    private int communicationScore = 0, communicationPercentage = 15;
    private Intent intent;
    private int[] communicationScores = {1,2,3,4,5,6,7,8,9,10};
    private int checkedId; //= R.drawable.checked_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
        setActionBarTitle();
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
        getMenuInflater().inflate(R.menu.menu_communication, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,CommunicationHelpActivity.class));
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
        getSupportActionBar().setTitle("Communication");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showManagementList(){
        lvCommunication = (ListView) findViewById(R.id.lvCommunicationList);
        CustomListAdapterCommunication customListAdapterCommunication = new CustomListAdapterCommunication(this, communicationOptions, checkedId);
        lvCommunication.setAdapter(customListAdapterCommunication);
        intent = new Intent(this, FactorsActivity.class);
        lvCommunication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0; i<communicationOptions.length; i++){
                    if (position == i){
                        communicationScore = communicationScores[i] * communicationPercentage;
                        intent.putExtra("CON", communicationScore);
                        intent.putExtra("CO", communicationOptions[i] );
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }
            }
        });
    }
}
