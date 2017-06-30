package com.antoniofb.seniorityappfinal.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;
import com.antoniofb.seniorityappfinal.registration.RegistrationActivity;

public class ResultsActivity extends AppCompatActivity {

    private Button btDone;
    private int[] scores;
    private TextView tvSeniorityScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setActionBarTitle();
        showSeniority();
        returnToRegistration();
    }

    public void setActionBarTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Seniority Screen");
    }

    public void showSeniority(){
        Bundle bundle = getIntent().getExtras();
        scores = bundle.getIntArray("SC");
        int seniorityScore = 0;
        for (int i=0;i<scores.length;i++){
            seniorityScore = seniorityScore + scores[i];
        }
        tvSeniorityScore = (TextView) findViewById(R.id.tvSeniorityScore);
        tvSeniorityScore.setText(Integer.toString(seniorityScore));
        //Log.d("TAG", "Score from leadership experience ->>>>: " + scores[5] + " lalala");
    }

    public void returnToRegistration(){
        btDone = (Button) findViewById(R.id.btnEndProcess);
        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsActivity.this, RegistrationActivity.class));
            }
        });
    }
}
