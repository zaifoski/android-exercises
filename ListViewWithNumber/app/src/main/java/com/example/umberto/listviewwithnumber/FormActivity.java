package com.example.umberto.listviewwithnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    public static final String NUMBER_OF_ELEMENTS = "numberOfElements";
    private Button confirmButton;
    private EditText numberEditText;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        confirmButton = (Button) findViewById(R.id.confirmButton);
        numberEditText = (EditText) findViewById(R.id.numberEditText);
        errorTextView = (TextView) findViewById(R.id.errorTextView);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormActivity.this, ListViewActivity.class);
                try {
                    int numerOfElements = Integer.parseInt(numberEditText.getText().toString());

                    i.putExtra(getPackageName()+NUMBER_OF_ELEMENTS, Integer.toString(numerOfElements));
                    startActivity(i);
                }
                catch (NumberFormatException e) {
                    //TODO: da implementare una notifica sulla acitvityù
                    errorTextView.setText("Devi inserire un numero");
                }
            }
        });
    }
}
