package com.antoniofb.seniorityappfinal.education;

/**
 * Created by aflores on 7/10/17.
 */

import android.app.Activity;
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
    //private final Integer[] imagesIds;
    private final int checkedId;

    public CustomListAdapterFormalEducation(Activity context, String[] educationOptions, int checkedId) {
        super(context, R.layout.formal_education_list, educationOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.educationOptions = educationOptions;
        //this.imagesIds = imagesIds;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.formal_education_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.formalEducationOption);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.checkedIcon);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.checkedIcon);

        txtTitle.setText(educationOptions[position]);
        //imageView.setImageResource(imagesIds[position]);
        imageView2.setImageResource(checkedId);
        return rowView;

    };
}