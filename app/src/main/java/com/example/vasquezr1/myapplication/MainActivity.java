package com.example.vasquezr1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    public static char decHexValue (int dec){

        switch(dec){

            case 0: return '0';
            case 1: return '1';
            case 2: return '2';
            case 3: return '3';
            case 4: return '4';
            case 5: return '5';
            case 6: return '6';
            case 7: return '7';
            case 8: return '8';
            case 9: return '9';
            case 10: return 'A';
            case 11: return 'B';
            case 12: return 'C';
            case 13: return 'D';
            case 14: return 'E';
            case 15: return 'F';

        }
        return ' ';
    }

    public static int decIntValue(String dec){

        char recent;
        int num = 0;
        int multiplier = 1;
        for(int i = dec.length() - 1; i >= 0; i--) {

            recent = dec.charAt(i);

            switch(recent){
                case '0': num += (0 * multiplier); break;
                case '1': num += (1 * multiplier); break;
                case '2': num += (2 * multiplier); break;
                case '3': num += (3 * multiplier); break;
                case '4': num += (4 * multiplier); break;
                case '5': num += (5 * multiplier); break;
                case '6': num += (6 * multiplier); break;
                case '7': num += (7 * multiplier); break;
                case '8': num += (8 * multiplier); break;
                case '9': num += (9 * multiplier); break;
            }
            multiplier *= 10;
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

    public static String binToDec(String bin1){

        int dec = Integer.parseInt(bin1, 2);

        String decString = "" + dec;

        return decString;
    }


    public static String decToHex(String dec1) {
        String hex = "";
        int dec = decIntValue(dec1);
        int remainder;

        while (dec > 0) {

            remainder = dec % 16;
            hex = decHexValue(remainder) + hex;
            dec = dec / 16;

        }
        return hex;
    }


    public void openHex(){
        Intent intent = new Intent(this,HexActivity.class);
        startActivity(intent);
    }

    public void openBin(){
        Intent intent = new Intent(this,BinActivity.class);
        startActivity(intent);
    }

    public void openDec(){
        Intent intent = new Intent(this,DecActivity.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonHex = (Button) findViewById(R.id.buttonHex);
        final Button buttonDec = (Button) findViewById(R.id.buttonDec);
        final Button buttonBin = (Button) findViewById(R.id.buttonBin);


        buttonHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openHex();}
        });

        buttonBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openBin();}
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openDec();}
        });




    }

}