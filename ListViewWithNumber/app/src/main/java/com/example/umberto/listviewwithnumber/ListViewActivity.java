package com.example.umberto.listviewwithnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private MyListViewAdapter mAdapter;
    private ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Intent intent = getIntent();

        ArrayList<ListItem> items = new ArrayList<>();

        int numberOfElements = Integer.parseInt(intent.getStringExtra(getPackageName()+FormActivity.NUMBER_OF_ELEMENTS));

        for(int i=0; i<numberOfElements; i++) {
            items.add(new ListItem("Elemento prova"+i));
        }

        mAdapter = new MyListViewAdapter(this, R.layout.list_item_1, items);
        mainListView = (ListView) findViewById(R.id.mainListView);

        mainListView.setAdapter(mAdapter);
    }
}
