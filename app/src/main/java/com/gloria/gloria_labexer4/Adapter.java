package com.gloria.gloria_labexer4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Companies> {

    private Context context;
    private int resource;

    public Adapter(@NonNull Context context, int resource, @NonNull List<Companies> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
        int logo = getItem(i).getLogo();
        String cName = getItem(i).getcompanyName();
        String cCountry = getItem(i).getcompanyCountry();
        String cCEO = getItem(i).getcompanyCEO();
        String cIndustry = getItem(i).getcompanyIndustry();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);
        ImageView img = convertView.findViewById(R.id.logo);
        TextView companyName = convertView.findViewById(R.id.cName);
        TextView companyCountry = convertView.findViewById(R.id.cCountry);
        TextView companyCeo = convertView.findViewById(R.id.cCeo);
        TextView companyIndustry = convertView.findViewById(R.id.cIndustry);

        img.setImageResource(logo);
        companyName.setText(cName);
        companyCountry.setText("Country: " + cCountry);
        companyIndustry.setText("Industry: " +cIndustry);
        companyCeo.setText("CEO: " + cCEO);

        return convertView;
    }
}
