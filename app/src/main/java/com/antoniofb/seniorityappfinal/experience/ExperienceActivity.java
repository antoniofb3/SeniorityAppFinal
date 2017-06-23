package com.antoniofb.seniorityappfinal.experience;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;

public class ExperienceActivity extends AppCompatActivity {

    private String[] experience = {"Without Experience", "1 or more year of experience", "2 or more years of experience", "3 or more years of experience", "4 or more years of experience"};
    private ListView lvExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        setActionBarTitle();
        showExperienceList();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Experience Screen");
    }

    public void showExperienceList(){
        lvExperience = (ListView) findViewById(R.id.lvExperienceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,experience);
        lvExperience.setAdapter(adapter);
        lvExperience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity();
                }
            }
        });
    }
}
