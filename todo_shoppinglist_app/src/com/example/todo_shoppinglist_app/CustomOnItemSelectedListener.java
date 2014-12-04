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
			position = 0;
			
			

			break;
			
		case 2:
			position =1;
			break;
			
		case 3: 
		position =2;
		
		break;
		
		case 4: 
			position =3;
			
			break;
			
		case 5: 
			position =4;
			
			//method to deactivate second spinner, and activate textview
			
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
