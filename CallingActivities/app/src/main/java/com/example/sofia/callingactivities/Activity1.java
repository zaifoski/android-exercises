package com.example.sofia.callingactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    static int instances = 0;
    TextView counter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instances++;
        setContentView(R.layout.content_activity1);

        Button buttonCalls2 = (Button) findViewById(R.id.buttonCalls2);
        counter = (TextView) findViewById(R.id.counter);
        buttonCalls2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        instances--;
    }
    protected void onResume() {
        super.onResume();
        if (counter != null)
            counter.setText("Instance count: A1 = " +
                    Activity1.instances+" - count A2 = " +
                    Activity2.instances);
    }
}
