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


        final Button calculateDec = (Button) findViewById(R.id.calculateHex);//Calculate Button to cionvert
        final EditText decInput = (EditText) findViewById(R.id.hexInput);//Takes in input text
        final TextView binDec = (TextView) findViewById(R.id.binDec);//Text view to view decimal conversion
        final TextView hexDec = (TextView) findViewById(R.id.hexDec);//Text view to view binary conversion
        //Buttons to go to new window
        final Button hex = (Button) findViewById(R.id.toDec);
        final Button home = (Button) findViewById(R.id.toHome);
        final Button binary = (Button) findViewById(R.id.toBinary);
        //Intents to open new windows
        final Intent intentHome = new Intent(this,MainActivity.class);
        final Intent intentHex = new Intent(this,HexActivity.class);
        final Intent intentBin = new Intent(this,BinActivity.class);
        //Opens hex window
        hex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHex);
            }
        });
        //Opens binary window
        binary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentBin);
            }
        });
        //Opens Home window
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHome);
            }
        });
        //Converts input
        calculateDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String dec = decInput.getText().toString();//retrieves input
                String binConverted = MainActivity.decToBin(dec);//Converts input to binary

                binDec.setText(binConverted);//Sets binary text view to converted string

                String hexConverted = MainActivity.decToHex(dec);//converts decimal to hex

                hexDec.setText(hexConverted);//sets hex textview to converted string
            }
        });
    }
}
