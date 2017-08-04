package com.antoniofb.seniorityappfinal.experience;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class PreviousExperienceHelpActivity extends AppCompatActivity {

    private TextView tvFEHelpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_experience_help);
        setActionBarOptions();
        setupGUI();
        fillTVHelp();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        finish();
        return true;
    }

    public void setActionBarOptions(){
        getSupportActionBar().setTitle("Previous Experience Help");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupGUI(){
        tvFEHelpText = (TextView) findViewById(R.id.tvFEHelpText);
    }

    public void fillTVHelp(){

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
        try {
            JSONObject root = new JSONObject(s);
            JSONObject factor = root.getJSONObject("seniority");
            JSONArray jsonFactors = factor.getJSONArray("factors");
            JSONObject jsonObject = jsonFactors.getJSONObject(1);
            tvFEHelpText.setText(jsonObject.getString("help"));

            /*
            //factors = new String[jsonFactors.length()];
            for (int i=0; i<jsonFactors.length(); i++){
                JSONObject jsonObject = jsonFactors.getJSONObject(i);
                //builder.append(jsonObject.getString("factor"));
                factors[i] = jsonObject.getString("factor"); //builder.toString();
            }
            */
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
