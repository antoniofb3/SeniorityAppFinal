package com.antoniofb.seniorityappfinal.technicalSkills;

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

public class CustomListAdapterTechnicalSkills extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] technicalSkillsOptions;
    private final int checkedId;

    public CustomListAdapterTechnicalSkills(Activity context, String[] technicalSkillsOptions, int checkedId) {
        super(context, R.layout.technical_skills_list, technicalSkillsOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.technicalSkillsOptions = technicalSkillsOptions;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.technical_skills_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.technicalSkillsOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.checkedIcon);

        txtTitle.setText(technicalSkillsOptions[position]);
        imageView.setImageResource(checkedId);
        return rowView;

    };
}