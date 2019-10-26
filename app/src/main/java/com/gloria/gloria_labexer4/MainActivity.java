package com.gloria.gloria_labexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] cName, cCountry, cCeo, cIndustry,cStock,cDesc;
    int[] logos = {R.drawable.icbc,R.drawable.jpmorgan,R.drawable.chinaconstructionbank,R.drawable.agribank,
            R.drawable.bankofamerica,R.drawable.apple,R.drawable.ping,R.drawable.bankofchina,R.drawable.royal,
            R.drawable.wells,R.drawable.exxon,R.drawable.at,R.drawable.samsung,R.drawable.citi};

    ArrayList<Companies> companies = new ArrayList<>();

    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        cName = getResources().getStringArray(R.array.companyName);
        cCountry = getResources().getStringArray(R.array.companyCountry);
        cCeo = getResources().getStringArray(R.array.companyCEO);
        cIndustry = getResources().getStringArray(R.array.companyIndustry);
        cDesc = getResources().getStringArray(R.array.companyDescription);
        cStock = getResources().getStringArray(R.array.companyStockPrice);

        for (int i=0; i < cName.length; i++){
            companies.add(i, new Companies(logos[i], cName[i], cCountry[i],cCeo[i],cIndustry[i],cDesc[i]));
        }

        Adapter adapter = new Adapter(this, R.layout.newlayout,companies);

        listCompanies = findViewById(R.id.companyList);
        listCompanies.setAdapter(adapter);
        listCompanies.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long id) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logos[i]);
        dialog.setTitle(cName[i]);

        dialog.setMessage(cDesc[i]);
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, cName[i] + "'s stock price: " + cStock[i],Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}