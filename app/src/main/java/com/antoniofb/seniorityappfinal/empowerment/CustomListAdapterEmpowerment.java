package com.antoniofb.seniorityappfinal.empowerment;

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

public class CustomListAdapterEmpowerment extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] empowermentOptions;
    private final int checkedId;

    public CustomListAdapterEmpowerment(Activity context, String[] empowermentOptions, int checkedId) {
        super(context, R.layout.empowerment_list, empowermentOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.empowermentOptions = empowermentOptions;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.empowerment_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.empowermentOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.checkedIcon);

        txtTitle.setText(empowermentOptions[position]);
        imageView.setImageResource(checkedId);
        return rowView;

    };
}