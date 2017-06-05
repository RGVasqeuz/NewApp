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

public class BinActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bin_layout);

        final Button calculateBin = (Button) findViewById(R.id.calculateHex);//Calculate Button to cionvert

        final EditText binInput = (EditText) findViewById(R.id.hexInput);//Takes in input text
        final TextView decBin = (TextView) findViewById(R.id.binDec);//Text view to view decimal conversion
        final TextView hexBin = (TextView) findViewById(R.id.hexDec);//Text view to view binary conversion
        //Buttons to go to new window
        final Button hex = (Button) findViewById(R.id.toDec);
        final Button home = (Button) findViewById(R.id.toHome);
        final Button decimal = (Button) findViewById(R.id.toDecimal);
        //Intents to open new windows
        final Intent intentHome = new Intent(this,MainActivity.class);
        final Intent intentHex = new Intent(this,HexActivity.class);
        final Intent intentDec = new Intent(this,DecActivity.class);
        //Opens Binary window
        hex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHex);
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
        calculateBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String bin = binInput.getText().toString();//retrieves input
                String decConverted = MainActivity.binToDec(bin);//Converts input to Decimal

                decBin.setText(decConverted);//Sets Decimal text view to converted string

                String hexConverted = MainActivity.decToHex(decBin.getText().toString());//converts decimal to hex

                hexBin.setText(hexConverted);//sets hex textview to converted string
            }
        });

    }
}
