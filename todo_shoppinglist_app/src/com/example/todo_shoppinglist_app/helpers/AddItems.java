package com.example.todo_shoppinglist_app.helpers;

import java.util.ArrayList;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AddItems {
	
	private Context mContext;

	public AddItems(Context ct) {
		mContext=ct;
	}
	
	public void addItem(String item, ArrayList<String> todoArrayList, ArrayAdapter<String> aa) {

		todoArrayList.add(item);
		aa.notifyDataSetChanged();

	}

}
