package com.antoniofb.seniorityappfinal.empowerment;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.results.SummaryActivity;

public class EmpowermentActivity extends AppCompatActivity {

    private String[] empowerment = {"High", "Medium", "Low"};
    private ListView lvEmpowerment;
    private int empowermentScore = 0, empowermentPercentage = 10;
    private int[] scores;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empowerment);
        setActionBarTitle();
        showManagementList();
        acumulateScores();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Empowerment");
    }

    public void showManagementList(){
        lvEmpowerment = (ListView) findViewById(R.id.lvEmpowermentList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,empowerment);
        lvEmpowerment.setAdapter(adapter);
        intent = new Intent(this, SummaryActivity.class);
        lvEmpowerment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    empowermentScore = 0 * empowermentPercentage;
                    scores[6] = empowermentScore;
                    intent.putExtra("EIH", scores);//always put the same key
                    startActivity(intent);
                    //startActivity(new Intent(ManagementActivity.this,CommunicationActivity.class));
                }
            }
        });
    }

    public void acumulateScores(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("LEWE");
        Log.d("TAG", "Score from leadership experience ->>>>: " + scores[5] + " lalala");
    }
}
