package me.peserico.unitests.mynotesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    private ArrayAdapter<String> elementsAdapter;
    private ArrayList<String> elements;
    private ListView elementsListView;
    private Button insertNoteButton;
    private Button deleteAllNotesButton;
    private Button updateNoteButton;
    private EditText insertTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        // Elements of UI
        elementsListView = (ListView) findViewById(R.id.elementsListView);
        insertNoteButton = (Button) findViewById(R.id.insertNoteButton);
        deleteAllNotesButton = (Button) findViewById(R.id.deleteAllNotesButton);
        insertTextField = (EditText) findViewById(R.id.insertTextField);
        updateNoteButton = (Button) findViewById(R.id.updateNoteButton);

        // Array model of the list
        elements = new ArrayList<>();

        // Adapter for listview update
        elementsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elements);
        elementsListView.setAdapter(elementsAdapter);

        // Adding event listeners
        insertNoteButton.setOnClickListener(new AddNoteListener(elements, elementsAdapter, insertTextField));
        deleteAllNotesButton.setOnClickListener(new DeleteAllNotesListener(elements, elementsAdapter));

        elementsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String element = elements.get(position);
                insertNoteButton.setVisibility(View.GONE);
                updateNoteButton.setVisibility(View.VISIBLE);
                insertTextField.setText(element);
                insertTextField.setSelection(insertTextField.getText().length());

                updateNoteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        elements.set(position, insertTextField.getText().toString());
                        elementsAdapter.notifyDataSetChanged();
                        insertNoteButton.setVisibility(View.VISIBLE);
                        updateNoteButton.setVisibility(View.GONE);
                    }
                });
            }
        });

    }


}
