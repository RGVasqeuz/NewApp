package com.example.vasquezr1.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ronni on 6/1/2017.
 */

public class HexActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hex_layout);

        final Button calculateHex = (Button) findViewById(R.id.calculateHex);

        final EditText hexInput = (EditText) findViewById(R.id.hexInput);
        final TextView decHex = (TextView) findViewById(R.id.binDec);
        final TextView binHex = (TextView) findViewById(R.id.hexDec);

        final Button bin = (Button) findViewById(R.id.toBinary);
        final Button home = (Button) findViewById(R.id.toHome);
        final Button decimal = (Button) findViewById(R.id.toDec);

        final Intent intentHome = new Intent(this,MainActivity.class);
        final Intent intentBin = new Intent(this,BinActivity.class);
        final Intent intentDec = new Intent(this,DecActivity.class);

        bin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentBin);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentDec);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHome);
            }
        });


        calculateHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String hex = hexInput.getText().toString();
                String decConverted = MainActivity.hexToDec(hex);

                decHex.setText(decConverted);

                String binConverted = MainActivity.decToBin(decConverted);

                binHex.setText(binConverted);
            }
        });


    }
}
