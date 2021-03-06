package com.antoniofb.seniorityappfinal.experience;

/**
 * Created by Antonio on 10/07/2017.
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

public class CustomListAdapterWorkExperience extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] workExperienceOptions;
    private final int checkedId;

    public CustomListAdapterWorkExperience(Activity context, String[] workExperienceOptions, int checkedId) {
        super(context, R.layout.work_experience_list, workExperienceOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.workExperienceOptions = workExperienceOptions;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.work_experience_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.workExperienceOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.arrowIcon);

        txtTitle.setText(workExperienceOptions[position]);
        imageView.setImageResource(checkedId);
        int pos = getPos();
        if (position == pos){
            imageView.setVisibility(view.VISIBLE);
        }
        return rowView;

    };

    public int getPos(){
        SharedPreferences sharedPref = context.getSharedPreferences("WEOptions", context.MODE_PRIVATE);
        int position = sharedPref.getInt("selected_position", -1);
        return position;
    }
}