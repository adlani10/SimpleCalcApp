package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String op = "+";
    String oldNum = "";
    double memory;
    boolean isNewOp = true;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
        ed1.setShowSoftInputOnFocus(false);
    }
    //Creates and adds numbers to the calc screen
    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.zeroBTN:
                number += "0";
                break;
            case R.id.oneBTN:BTN:
                number += "1";
                break;
            case R.id.twoBTN:
                number += "2";
                break;
            case R.id.threeBTN:
                number += "3";
                break;
            case R.id.fourBTN:
                number += "4";
                break;
            case R.id.fiveBTN:
                number += "5";
                break;
            case R.id.sixBTN:
                number += "6";
                break;
            case R.id.sevenBTN:
                number += "7";
                break;
            case R.id.eightBTN:
                number += "8";
                break;
            case R.id.nineBTN:
                number += "9";
                break;
            case R.id.eeBTN:
                number += "E";
                break;
            case R.id.pointBTN:
                number += ".";
                break;
            case R.id.plusMinusBTN:
                number = "-"+number;
                break;
        }
        ed1.setText(number);
    }

    //Method to handle the different mathematical operators
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNum = ed1.getText().toString();
        switch (view.getId()){
            case R.id.divideBTN:op = "/"; break;
            case R.id.multiplyBTN:op = "*"; break;
            case R.id.addBTN:op = "+"; break;
            case R.id.subtractBTN:op = "-"; break;
            case R.id.xyRtBTN:op = "y√x"; break;
            case R.id.xyPowBTN:op = "x^y"; break;
        }
    }
    //Method to evaluate the expression passed through
    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNum) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNum) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNum) * Double.parseDouble(newNumber);
                break;
            case "/":
                //exception for dividing by zero.
                try {
                    result = Double.parseDouble(oldNum) / Double.parseDouble(newNumber);
                } catch (ArithmeticException e) {
                    result = Double.parseDouble("Error");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    result = Double.parseDouble("Error");
                }
                break;
            case "y√x":
                result = Math.pow(Double.parseDouble(oldNum),1/Double.parseDouble(newNumber));
                break;
            case "x^y":
                result = Math.pow((Double.parseDouble(oldNum)),(Double.parseDouble(newNumber)));
                break;
        }

        ed1.setText(result+"");
    }



    //Method to clear the current calc window
    public void clearEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }
    //The methods below are primarily used for the scientific calculator portion.

    // memory recall, addition, subtraction and clear methods
    public void memRecallEvent(View view) {
        ed1.setText(memory + "");
        isNewOp = true;
    }

    public void memAddEvent(View view) {
        memory = memory + Double.parseDouble(ed1.getText().toString());
        isNewOp = true;
    }

    public void memSubEvent(View view) {
        memory = memory - Double.parseDouble(ed1.getText().toString());
        isNewOp = true;
    }

    public void memClearEvent(View view) {
        memory = 0;
        isNewOp = true;
    }
    // Method to turn number value to percent
    public void percentEvent(View view) {
        double num = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(num + "");
        isNewOp = true;
    }

    //The following methods involve radical expressions
    public void squareEvent(View view) {
        double num = Math.pow(Double.parseDouble(ed1.getText().toString()),2);
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void cubeEvent(View view) {
        double num = Math.pow(Double.parseDouble(ed1.getText().toString()),3);
        ed1.setText(num + "");
        isNewOp = true;
    }
    public void squareRtEvent(View view) {
        double num = Math.sqrt(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }
    public void cubeRtEvent(View view) {
        double num = Math.cbrt(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    // The following methods involve exponential expressions.
    public void tenPowEvent(View view) {
        double num = Math.pow(10,Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }
    public void ePowEvent(View view) {
        double num = Math.pow(2.7182818284590452,Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void reciprocalEvent(View view) {
        double num = 1/Double.parseDouble(ed1.getText().toString());
        ed1.setText(num + "");
        isNewOp = true;
    }

    // The following methods involve logarithmic expressions.
    public void log10Event(View view) {
        double num = Math.log10(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }


    public void lnEvent(View view) {
        double num = Math.log(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void eEvent(View view) {
        double num = 2.7182818284590452;
        ed1.setText(num + "");
        isNewOp = true;
    }
    // The method generates a random number between 0 and 1
    public void randEvent(View view) {
        double num = Math.random();
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void piEvent(View view) {
        double num = 3.141592653589793;
        ed1.setText(num + "");
        isNewOp = true;
    }
    public void hexEvent(View view) {
        double num = Math.toRadians(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(Double.toHexString(num));
        isNewOp = true;
    }

    // The following methods involve trig expressions.
    public void sinEvent(View view) {
        double num = Math.sin(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }
    public void asinEvent(View view) {
        double num = Math.asin(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void cosEvent(View view) {
        double num = Math.cos(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }
    public void acosEvent(View view) {
        double num = Math.acos(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void tanEvent(View view) {
        double num = Math.tan(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    public void atanEvent(View view) {
        double num = Math.atan(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;
    }

    // This methods takes the factorial of the number displayed
    public void factorialEvent(View view) {
        double num = Double.parseDouble(ed1.getText().toString());
        double fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = fact * i;
        }

        ed1.setText(fact + "");
        isNewOp = true;
    }

    // This methods takes the absolute value of the number displayed
    public void absEvent(View view) {
        double num = Math.abs(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(num + "");
        isNewOp = true;

    }

    //The method is an easter egg for Big Dairy.
    public void mooEvent(View view) {
        ed1.setText("M0000");
        isNewOp = true;
    }
}