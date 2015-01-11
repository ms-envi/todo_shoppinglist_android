package com.example.todo_shoppinglist_app;

import java.util.ArrayList;

import com.example.todo_shoppinglist_app.helpers.AddItems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class TodoListActivity extends Activity {

	private EditText mAddText;
	private Button mBtnAdd, mBtnClear;
	private TextView mTitle;
	private ListView mTodoListView;
	private ArrayAdapter<String> todoListAdapter;
	private ArrayList<String> todoItemsList;
	private Context mCtx;
	protected static final int CONTEXTMENU_EDIT = 1;
	protected static final int CONTEXTMENU_DELETE = 2;


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
		registerForContextMenu(mTodoListView);
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

					AddItems addItems= new AddItems(mCtx);
					addItems.addItem(mAddText.getText().toString(), todoItemsList, todoListAdapter);
					

					mTodoListView.setAdapter(todoListAdapter);
					mAddText.setText("");
				}

			}
		});

	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
	
	@Override
	public void onResume(){
		super.onResume();
	}
	
	@Override
	public void onStop(){
		super.onStop();
	}
	
	@Override
	public void onStart(){
		super.onStart();
	}
	
	@Override
	public void onRestart(){
		super.onRestart();
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		Log.d(TAG, "onCreateContextMenu called");
		menu.setHeaderTitle("Choose action");
		menu.add(0, CONTEXTMENU_EDIT, 0, R.string.context_menu_edit);
		menu.add(0, CONTEXTMENU_DELETE, 1, R.string.context_menu_delete);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		int pos = info.position;
		if (item.getItemId() == 2) {
			todoItemsList.remove(pos);
			todoListAdapter.notifyDataSetChanged();

		} else if (item.getItemId() == 1) {
			// TODO: implement some method here
		}

		return true;
	}


/*
	public void addItem(String item) {

		todoItemsList.add(item);
		todoListAdapter.notifyDataSetChanged();

	}*/
}
