package com.example.todo_shoppinglist_app;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TodoListActivity extends Activity {

	private EditText mAddText;
	private Button mBtnAdd, mBtnClear;
	private TextView mTitle;
	private ListView mTodoListView;
	private ArrayAdapter<String> todoListAdapter;
	private ArrayList<String> todoItemsList;

	private static final String TAG = "TodoListActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todo_list);
		Log.i(TAG, "onCreate called");

		mAddText = (EditText) findViewById(R.id.editText2);
		mBtnAdd = (Button) findViewById(R.id.add2);
		mBtnClear = (Button) findViewById(R.id.clear1);
		mTitle = (TextView) findViewById(R.id.textView2);
		mTodoListView = (ListView) findViewById(R.id.listView1);

		todoItemsList = new ArrayList<String>();
		todoListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, todoItemsList);

		mBtnClear.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mAddText.setText("");

			}
		});

		mBtnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mAddText.getText().toString().equals(""))
					Toast.makeText(getApplicationContext(), "Field is empty",
							Toast.LENGTH_LONG).show();
				else {

					addItem(mAddText.getText().toString());

					mTodoListView.setAdapter(todoListAdapter);
					mAddText.setText("");
				}

			}
		});

	}

	public void addItem(String item) {

		todoItemsList.add(item);
		todoListAdapter.notifyDataSetChanged();

	}
}
