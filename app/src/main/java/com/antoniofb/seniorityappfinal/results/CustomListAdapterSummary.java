package com.antoniofb.seniorityappfinal.results;

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

public class CustomListAdapterSummary extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] factorsName;
    private final int[] scores;

    public CustomListAdapterSummary(Activity context, String[] factorsName, int[] scores) {
        super(context, R.layout.summary_list, factorsName);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.factorsName = factorsName;
        this.scores = scores;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.summary_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.factorName);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.factorScore);

        txtTitle.setText(factorsName[position]);//itemname es un array de strings, donde va estar el texto de mis factores
        txtTitle2.setText(Integer.toString(scores[position]));
        return rowView;

    };
}