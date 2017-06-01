package com.example.vasquezr1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.String;



public class MainActivity extends AppCompatActivity {




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
        return -1;
    }

    public static int decIntValue(String dec){

        char recent;
        int num = 0;
        for(int i = 0; i < dec.length(); i++) {

            recent = dec.charAt(i);

            switch(recent){
                case '0': num += 0; break;
                case '1': num += 1; break;
                case '2': num += 2; break;
                case '3': num += 3; break;
                case '4': num += 4; break;
                case '5': num += 5; break;
                case '6': num += 6; break;
                case '7': num += 7; break;
                case '8': num += 8; break;
                case '9': num += 9; break;
            }

        }
        return num;
    }

    public static String decToBin (String dec1){
        int decInt = Integer.parseInt(dec1);
        String bin1;

        if(decInt < 0)
            return "ERROR";
        else
            bin1 = Integer.toBinaryString(decInt);

        return bin1;
    }

    public static String hexToDec (String hex1){

        int multiplier = 1;
        int total = 0;
        char lastChar;

        for(int i = 1; i <= hex1.length(); i++){
            lastChar = hex1.charAt(hex1.length() - i);

            if(hexIntValue(lastChar) == -1)
                return "ERROR";
            else
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

                String u = hex.getText().toString();
                String decConverted = hexToDec(u);

                dec.setText(decConverted);

                String binConverted = decToBin(decConverted);

                bin.setText(binConverted);
            }
        });
    }

}