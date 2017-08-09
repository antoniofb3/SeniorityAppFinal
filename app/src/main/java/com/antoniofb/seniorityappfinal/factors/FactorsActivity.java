package com.antoniofb.seniorityappfinal.factors;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
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
import com.antoniofb.seniorityappfinal.Settings.AboutActivity;
import com.antoniofb.seniorityappfinal.communication.CommunicationActivity;
import com.antoniofb.seniorityappfinal.education.FormalEducationActivity;
import com.antoniofb.seniorityappfinal.empowerment.EmpowermentActivity;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.leadershipExperience.LeadershipExperienceActivity;
import com.antoniofb.seniorityappfinal.management.ManagementActivity;
import com.antoniofb.seniorityappfinal.results.SummaryActivity;
import com.antoniofb.seniorityappfinal.technicalSkills.TechnicalSkillsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FactorsActivity extends AppCompatActivity {

    private TextView tvEmpData;
    private ListView lvFactors;
    private String[] factors;
    private String[] factorsChosen;
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
    private int[] scoresFactors = {-1,-1,-1,-1,-1,-1,-1};
    private int scoreFactor = 0;
    private int size = 0;//to get the number of factors for the rest of arrays

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        setBarOptions();
        setupGUI();
        //showEmployeeData();
        fillFactorsList();
        showFactorsList();
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

            case R.id.actionSettings:
                startActivity(new Intent(this, AboutActivity.class));
                break;

            case R.id.actionSettings2:
                this.finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setBarOptions(){
        getSupportActionBar().setTitle("Seniority Belatrix");
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

    public void fillFactorsList(){

        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.factors);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine());
        }
        parseJson(stringBuilder.toString());
    }

    private void parseJson(String s) {
        //StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(s);
            JSONObject factor = root.getJSONObject("seniority");
            //builder.append("Name: ").append(student.getString("name")).append("\n");
            //builder.append("Full Time: ").append(student.getBoolean("full-time")).append("\n\n");
            JSONArray jsonFactors = factor.getJSONArray("factors");
            size = jsonFactors.length();
            factors = new String[size];
            factorsChosen = new String[size];
            for (int i=0; i<size; i++){
                JSONObject jsonObject = jsonFactors.getJSONObject(i);
                //builder.append(jsonObject.getString("factor"));
                factors[i] = jsonObject.getString("factor"); //builder.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
