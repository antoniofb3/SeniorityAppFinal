package com.antoniofb.seniorityappfinal.management;

/**
 * Created by Antonio on 10/07/2017.
 */

import android.app.Activity;
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
    private final int arrowId;

    public CustomListAdapterManagement(Activity context, String[] managementOptions, int arrowId) {
        super(context, R.layout.management_list, managementOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.managementOptions = managementOptions;
        this.arrowId = arrowId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.management_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.managementOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.arrowIcon);

        txtTitle.setText(managementOptions[position]);
        imageView.setImageResource(arrowId);
        return rowView;

    };
}