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

        final Button calculateBin = (Button) findViewById(R.id.calculateHex);

        final EditText binInput = (EditText) findViewById(R.id.hexInput);
        final TextView decBin = (TextView) findViewById(R.id.binDec);
        final TextView hexBin = (TextView) findViewById(R.id.hexDec);

        final Button hex = (Button) findViewById(R.id.toDec);
        final Button home = (Button) findViewById(R.id.toHome);
        final Button decimal = (Button) findViewById(R.id.toDecimal);

        final Intent intentHome = new Intent(this,MainActivity.class);
        final Intent intentHex = new Intent(this,HexActivity.class);
        final Intent intentDec = new Intent(this,DecActivity.class);

        hex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(intentHex);
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

        calculateBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String bin = binInput.getText().toString();
                String decConverted = MainActivity.binToDec(bin);

                decBin.setText(decConverted);

                String hexConverted = MainActivity.decToHex(decBin.getText().toString());

                hexBin.setText(hexConverted);
            }
        });

    }
}
