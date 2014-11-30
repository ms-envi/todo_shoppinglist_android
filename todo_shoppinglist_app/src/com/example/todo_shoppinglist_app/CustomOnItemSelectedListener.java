package com.example.todo_shoppinglist_app;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		switch (position) {

		case 1:
			position = 1;
			List<String> bakeryList = new ArrayList<String>();
			bakeryList.add("Bread");
			bakeryList.add("Roll");
			bakeryList.add("Rice");
			bakeryList.add("Pasta");
			bakeryList.add("Flour");
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
					parent.getContext(), android.R.layout.simple_spinner_item,
					bakeryList);
			adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			

			break;

		}

		Toast.makeText(parent.getContext(), "Choose item", Toast.LENGTH_LONG)
				.show();

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
