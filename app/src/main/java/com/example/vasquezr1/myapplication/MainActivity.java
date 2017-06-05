package com.example.vasquezr1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Character;
import java.lang.String;



public class MainActivity extends AppCompatActivity {
//Taught me how to link layouts to Activities and open new layouts from other layouts: https://www.youtube.com/watch?v=MCf7EWLVWO8



    //Finds integer value of hex characters
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
    //Finds char value for Decimal integers in Hex
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

    //Converts Decimal to Binary
    public static String decToBin (String dec1){

        int decInt = Integer.parseInt(dec1);//gets integer value from decimal string
        String bin1;//binary String

        if(decInt < 0)
            return "ERROR";
        else
            bin1 = Integer.toBinaryString(decInt);

        return bin1;
    }
    //Converts hex string to Decimal string
    public static String hexToDec (String hex1){

        int multiplier = 1;//multiplier increase by 16 in order to respond to hex
        int total = 0;
        char lastChar;
        //For loop to go througjh characters in hex string
        for(int i = 1; i <= hex1.length(); i++){
            //Checks most recent char and sets to uppercase
            lastChar = Character.toUpperCase(hex1.charAt(hex1.length() - i)) ;
            //if an invalid input Error message is sent
            if(hexIntValue(lastChar) == -1)
                return "ERROR";
            else
                //total int value is added per character
                total += hexIntValue(lastChar) * multiplier;
                multiplier *= 16;
        }
        return "" + total;//Total is returned in string format
    }
    //Binary to Decimal Converter method
    public static String binToDec(String bin1){
        //Pre-existing Interger method existed
        int dec = Integer.parseInt(bin1, 2);

        String decString = "" + dec;//Set it to a String

        return decString;
    }

    //Decimal to Hex Converter
    public static String decToHex(String dec1) {
        // String to store hex string
        String hex = "";
        //gets integer value from string decimal value
        int dec = Integer.parseInt(dec1);
        int remainder;//Remainder is left over to be checks if its value corelates with any character list
        //While decimal is greater than 0 loop will continue
        while (dec > 0) {
            //
            remainder = dec % 16;
            //Checks remainder to convert to hex character and add on to previous hex string
            hex = decHexValue(remainder) + hex;
            //Decimal is lessened to subtract remainder
            dec = dec / 16;

        }
        return hex;
    }

    //Opens hex window
    public void openHex(){
        Intent intent = new Intent(this,HexActivity.class);
        startActivity(intent);
    }
    //Opens Binary window
    public void openBin(){
        Intent intent = new Intent(this,BinActivity.class);
        startActivity(intent);
    }
    //Opens Decimal Window
    public void openDec(){
        Intent intent = new Intent(this,DecActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buttons to go to different windows
        final Button buttonHex = (Button) findViewById(R.id.buttonHex);
        final Button buttonDec = (Button) findViewById(R.id.buttonDec);
        final Button buttonBin = (Button) findViewById(R.id.buttonBin);

        //Opens Hex window
        buttonHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openHex();}
        });
        //Opens Binary Window
        buttonBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openBin();}
        });
        //Opens Decimal Window
        buttonDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openDec();}
        });




    }

}