package com.example.vasquezr1.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

        final Button calculate = (Button) findViewById(R.id.calculate);

        final EditText hexInput = (EditText) findViewById(R.id.hexInput);
        final TextView decHex = (TextView) findViewById(R.id.decHex);
        final TextView binHex = (TextView) findViewById(R.id.binHex);



        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String u = hexInput.getText().toString();
                String decConverted = MainActivity.hexToDec(u);

                decHex.(decConverted);

                String binConverted = MainActivity.decToBin(decConverted);

                binHex.setText(binConverted);
            }
        });


    }
}
