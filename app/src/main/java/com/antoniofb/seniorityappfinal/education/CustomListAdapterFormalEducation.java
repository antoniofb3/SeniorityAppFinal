package com.antoniofb.seniorityappfinal.education;

/**
 * Created by aflores on 7/10/17.
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;

public class CustomListAdapterFormalEducation extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] educationOptions;
    private final int checkedId;

    public CustomListAdapterFormalEducation(Activity context, String[] educationOptions, int checkedId) {
        super(context, R.layout.formal_education_list, educationOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.educationOptions = educationOptions;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.formal_education_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.formalEducationOption);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.checkedEducationIcon);

        txtTitle.setText(educationOptions[position]);
        imageView2.setImageResource(checkedId);
        int pos = getPos();
        if (position == pos){
            imageView2.setVisibility(view.VISIBLE);
        }
        return rowView;

    };

    public int getPos(){
        SharedPreferences sharedPref = context.getSharedPreferences("PCFEOptions", context.MODE_PRIVATE);
        int position = sharedPref.getInt("selected_position", 0);
        return position;
    }
}