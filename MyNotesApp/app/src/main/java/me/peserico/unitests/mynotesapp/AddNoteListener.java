package me.peserico.unitests.mynotesapp;

import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by umberto on 07/03/2016.
 */
public class AddNoteListener implements View.OnClickListener {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText source;

    public AddNoteListener(ArrayList<String> array, ArrayAdapter<String> adapter, EditText source) {
        this.arrayList = array;
        this.adapter = adapter;
        this.source = source;
    }

    @Override
    public void onClick(View v) {
        arrayList.add(source.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
