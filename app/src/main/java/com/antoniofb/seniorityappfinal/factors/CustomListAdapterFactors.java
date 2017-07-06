package com.antoniofb.seniorityappfinal.factors;

/**
 * Created by aflores on 7/6/17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.antoniofb.seniorityappfinal.R;

public class CustomListAdapterFactors extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] factors;
    private final Integer[] imagesIds;
    private final int arrowId;

    public CustomListAdapterFactors(Activity context, String[] factors, Integer[] imagesIds, int arrowId) {
        super(context, R.layout.factors_list, factors);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.factors = factors;
        this.imagesIds = imagesIds;
        this.arrowId = arrowId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.factors_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nameFactor);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.iconFactor);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.arrowIcon);

        txtTitle.setText(factors[position]);//itemname es un array de strings, donde va estar el texto de mis factores
        imageView.setImageResource(imagesIds[position]);
        imageView2.setImageResource(arrowId);
        return rowView;

    };
}