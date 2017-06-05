package com.example.vasquezr1.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ronni on 6/1/2017.
 */

public class DecActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dec_layout);


        final Button calculateDec = (Button) findViewById(R.id.calculateHex);
        final EditText decInput = (EditText) findViewById(R.id.hexInput);
        final TextView binDec = (TextView) findViewById(R.id.binDec);
        final TextView hexDec = (TextView) findViewById(R.id.hexDec);

        final Button hex = (Button) findViewById(R.id.toDec);
        final Button home = (Button) findViewById(R.id.toHome);
        final Button binary = (Button) findViewById(R.id.toBinary);

        final Intent intentHome = new Intent(this,MainActivity.class);
        final Intent intentHex = new Intent(this,HexActivity.class);
        final Intent intentBin = new Intent(this,BinActivity.class);

        hex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHex);
            }
        });

        binary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentBin);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHome);
            }
        });

        calculateDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String dec = decInput.getText().toString();
                String binConverted = MainActivity.decToBin(dec);

                binDec.setText(binConverted);

                String hexConverted = MainActivity.decToHex(dec);

                hexDec.setText(hexConverted);
            }
        });
    }
}
