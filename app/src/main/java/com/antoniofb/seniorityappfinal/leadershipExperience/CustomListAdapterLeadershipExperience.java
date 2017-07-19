package com.antoniofb.seniorityappfinal.leadershipExperience;

/**
 * Created by aflores on 7/19/17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;

public class CustomListAdapterLeadershipExperience extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] leadershipExperienceOptions;
    private final int checkedId;

    public CustomListAdapterLeadershipExperience(Activity context, String[] leadershipExperienceOptions, int checkedId) {
        super(context, R.layout.leadership_experience_list, leadershipExperienceOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.leadershipExperienceOptions = leadershipExperienceOptions;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.leadership_experience_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.leadershipExperienceOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.checkedIcon);

        txtTitle.setText(leadershipExperienceOptions[position]);
        imageView.setImageResource(checkedId);
        return rowView;

    };
}