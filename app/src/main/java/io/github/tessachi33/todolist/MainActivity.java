package io.github.tessachi33.todolist;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends ListActivity {

    private ArrayList<String> mTasks;
    private Button mTaskButton;
    private EditText mTaskText;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTaskButton = (Button) findViewById(R.id.taskButton);
        mTaskText = (EditText) findViewById(R.id.taskText);
        mTasks = new ArrayList<String>();

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mTasks);
        setListAdapter(mAdapter);

        mTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
    }

    private void addTask() {
        String newTask =  mTaskText.getText().toString();
        mTasks.add(newTask);
        mAdapter.notifyDataSetChanged();
    }
}