package com.antoniofb.seniorityappfinal.education;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.experience.ExperienceActivity;
import com.antoniofb.seniorityappfinal.factors.FactorsActivity;

public class FormalEducationActivity extends AppCompatActivity {

    private String[] education = {"Incomplete Terciary Education", "Incomplete Bachelor", "Bachelor", "Graduated + Especializated", "Master"};
    private ListView lvEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal_education);
        setActionBarTitle();
        showEducationList();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Formal Education Screen");
    }

    public void showEducationList(){
        lvEducation = (ListView) findViewById(R.id.lvFormalEducationList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,education);
        lvEducation.setAdapter(adapter);//me salio el mismo error de null el adapter, lo arregle poniendo bien el findViewById
        lvEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(FormalEducationActivity.this,ExperienceActivity.class));
                }
            }
        });
    }
}
