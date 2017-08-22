package com.antoniofb.seniorityappfinal.management;

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

public class CustomListAdapterManagement extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] managementOptions;
    private final int checkedId;

    public CustomListAdapterManagement(Activity context, String[] managementOptions, int checkedId) {
        super(context, R.layout.management_list, managementOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.managementOptions = managementOptions;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.management_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.managementOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.arrowIcon);

        txtTitle.setText(managementOptions[position]);
        imageView.setImageResource(checkedId);
        int pos = getPos();
        if (position == pos){
            imageView.setVisibility(view.VISIBLE);
        }
        return rowView;

    };

    public int getPos(){
        SharedPreferences sharedPref = context.getSharedPreferences("MOptions", context.MODE_PRIVATE);
        int position = sharedPref.getInt("selected_position", 0);
        return position;
    }
}