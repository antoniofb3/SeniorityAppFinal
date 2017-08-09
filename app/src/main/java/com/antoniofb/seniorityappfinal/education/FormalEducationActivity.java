package com.antoniofb.seniorityappfinal.education;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class FormalEducationActivity extends AppCompatActivity {

    private String[] educationOptions = {"Incomplete Terciary Education", "Incomplete Bachelor", "Bachelor", "Graduated + Especializated", "Master"};
    private ListView lvEducationOptions;
    private int educationScore = 0, educationPercentage = 5;
    private Intent intent;
    private int[] educationScores = {1,2,3,5,6};
    private int checkedId = R.drawable.checked_icon;
    private int positionChosen, size=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal_education);
        setBarOptions();
        setupGUI();
        //fillFactorsList();
        showEducationList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_formal_education, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.helpButton:
                startActivity(new Intent(this,FormalEducationHelpActivity.class));
                break;

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setupGUI(){
        lvEducationOptions = (ListView) findViewById(R.id.lvFormalEducationList);
    }

    public void setBarOptions(){
        getSupportActionBar().setTitle("Formal Education");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showEducationList(){
        CustomListAdapterFormalEducation customListAdapterFormalEducation = new CustomListAdapterFormalEducation(this, educationOptions, checkedId);
        lvEducationOptions.setAdapter(customListAdapterFormalEducation);
        intent = new Intent(this,FactorsActivity.class);
        lvEducationOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                /*
                if (position == positionChosen){
                    //con la posicion escogida yo puedo decir en q fila va hacer visible el check cuando cargue el activity
                    positionChosen = position;
                    ImageView iv = (ImageView) findViewById(R.id.checkedEducationIcon);
                    iv.setVisibility(view.VISIBLE);
                    //hasta aca
                }
                */
                for (int i=0; i<educationOptions.length; i++){
                    if (position == i){
                        educationScore = educationScores[i] * educationPercentage;
                        intent.putExtra("FEON", educationScore);
                        intent.putExtra("FEO", educationOptions[i] );
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }
            }
        });
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
            JSONArray jsonFactors = factor.getJSONArray("factors");
            size = jsonFactors.length();
            for (int i=0; i<size; i++){
                JSONObject jsonObject = jsonFactors.getJSONObject(i);
                if (jsonObject.getString("factor") == "Formal Education"){

                    JSONArray jsonEducationOptions = jsonObject.getJSONArray("options");
                    educationOptions = new String[jsonEducationOptions.length()];
                    for (int j=0; j<jsonEducationOptions.length();j++){
                        educationOptions[j] = jsonObject.getString("ite");
                    }
                }

                //builder.append(jsonObject.getString("factor"));
                //educationOptions[i] = jsonObject.getString("factor"); //builder.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
