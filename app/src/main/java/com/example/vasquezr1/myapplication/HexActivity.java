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

        final Button calculateHex = (Button) findViewById(R.id.calculateHex);//Calculate Button to cionvert

        final EditText hexInput = (EditText) findViewById(R.id.hexInput);//Takes in input text
        final TextView decHex = (TextView) findViewById(R.id.binDec);//Text view to view decimal conversion
        final TextView binHex = (TextView) findViewById(R.id.hexDec);//Text view to view binary conversion
        //Buttons to go to new window
        final Button bin = (Button) findViewById(R.id.toBinary);
        final Button home = (Button) findViewById(R.id.toHome);
        final Button decimal = (Button) findViewById(R.id.toDec);
        //Intents to open new windows
        final Intent intentHome = new Intent(this,MainActivity.class);
        final Intent intentBin = new Intent(this,BinActivity.class);
        final Intent intentDec = new Intent(this,DecActivity.class);
        //Opens Binary window
        bin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentBin);
            }
        });
        //Opens Decimal window
        decimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentDec);
            }
        });
        //Opens Home window
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHome);
            }
        });
        //Converts input
        calculateHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String hex = hexInput.getText().toString();//retrieves input
                String decConverted = MainActivity.hexToDec(hex);//Converts input to Decimal

                decHex.setText(decConverted);//Sets Decimal text view to converted string

                String binConverted = MainActivity.decToBin(decConverted);//converts decimal to binary

                binHex.setText(binConverted);//sets binary textview to converted string
            }
        });


    }
}
