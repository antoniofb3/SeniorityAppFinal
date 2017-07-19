package com.antoniofb.seniorityappfinal.communication;

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

public class CustomListAdapterCommunication extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] communicationOptions;
    //private final Integer[] imagesIds;
    private final int checkedId;

    public CustomListAdapterCommunication(Activity context, String[] communicationOptions, int checkedId) {
        super(context, R.layout.communication_list, communicationOptions);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.communicationOptions = communicationOptions;
        //this.imagesIds = imagesIds;
        this.checkedId = checkedId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.communication_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.communicationOption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.checkedIcon);

        txtTitle.setText(communicationOptions[position]);
        imageView.setImageResource(checkedId);
        return rowView;

    };
}