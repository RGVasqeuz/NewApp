package com.example.vasquezr1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;


    public static int hexIntValue (char hex){

        switch(hex){

            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case 'A': return 10;
            case 'B': return 11;
            case 'C': return 12;
            case 'D': return 13;
            case 'E': return 14;
            case 'F': return 15;

        }
        return 1;
    }

    public static String hexToDec (String hex1){

        int multiplier = 1;
        int total = 0;
        char lastChar;

        for(int i = 1; i <= hex1.length(); i++){

            lastChar = hex1.charAt(hex1.length() - i);

            total += hexIntValue(lastChar) * multiplier;

            multiplier *= 16;

        }

        return "" + total;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boo = (Button) findViewById(R.id.boo);
        final EditText dec = (EditText) findViewById(R.id.dec);
        final EditText hex = (EditText) findViewById(R.id.hex);
        final EditText bin = (EditText) findViewById(R.id.bin);

        boo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String u = dec.getText().toString();

                hex.hexToDec(u);
            }
        });
    }

}