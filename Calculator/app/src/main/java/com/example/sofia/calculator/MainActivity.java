package com.example.sofia.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String op = "+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSum = (Button) findViewById(R.id.btnSum);
        Button btnSubtract = (Button) findViewById(R.id.btnSubtract);
        Button btnMultiply = (Button) findViewById(R.id.btnMultiply);
        Button btnDivide = (Button) findViewById(R.id.btnDivide);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = "+";
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = "-";
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = "*";
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = "/";
            }
        });

        final Button btnEquals = (Button) findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemOne = ((EditText) findViewById(R.id.itemOne)).getText().toString();
                String itemTwo = ((EditText) findViewById(R.id.itemTwo)).getText().toString();
                float numOne;
                float numTwo;
                try
                {
                    numOne = Float.parseFloat(itemOne);
                    numTwo = Float.parseFloat(itemTwo);
                    float result;
                    switch (op){
                        case "+": result = numOne + numTwo; break;
                        case "-": result = numOne - numTwo; break;
                        case "*": result = numOne * numTwo; break;
                        case "/": result = numOne / numTwo; break;
                        default:  result = numOne + numTwo; break;
                    }
                    TextView resultText = (TextView) findViewById(R.id.result);
                    resultText.setText(Float.toString(result));
                }
                catch ( NumberFormatException e )
                {
                    TextView resultText = (TextView) findViewById(R.id.result);
                    resultText.setText("insert numbers");
                }
            }
        });
    }
}
