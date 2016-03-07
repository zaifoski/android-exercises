package me.peserico.unitests.mynotesapp;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by umberto on 07/03/2016.
 */
public class DeleteAllNotesListener implements View.OnClickListener {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    public DeleteAllNotesListener(ArrayList<String> array, ArrayAdapter<String> adapter) {
        this.arrayList = array;
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        arrayList.clear();
        adapter.notifyDataSetChanged();
    }
}
