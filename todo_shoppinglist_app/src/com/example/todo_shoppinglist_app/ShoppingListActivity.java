package com.example.todo_shoppinglist_app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ShoppingListActivity extends Activity {

	private Spinner selectCategory, selectItem1, selectItem2,selectItem3,selectItem4, selectItem5 ;
	private Button addBtn, clearBtn, bakingBtn, dairyBtn, meatBtn, greensBtn,
			othersBtn;
	private TextView addOthers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopping_list);

		addListenerOnSpinnerSelection();
		chooseBakingItems();
		chooseDairyItems();
		chooseGreansItems();
		chooseMeatItems();
		chooseOtherItems();

	}

	private void addListenerOnSpinnerSelection() {
		selectCategory = (Spinner) findViewById(R.id.food_category);
		selectCategory
				.setOnItemSelectedListener(new CustomOnItemSelectedListener());

	}

	public void chooseBakingItems() {
		selectItem1 = (Spinner) findViewById(R.id.food_item);
		List<String> bakeryList = new ArrayList<String>();
		bakeryList.add("Bread");
		bakeryList.add("Roll");
		bakeryList.add("Rice");
		bakeryList.add("Pasta");
		bakeryList.add("Flour");
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, bakeryList);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem1.setAdapter(adapter1);

	}
	
	private void chooseDairyItems (){
		selectItem2=(Spinner)findViewById(R.id.food_item);
		
		List <String> dairyList = new ArrayList<String>();
		dairyList.add("Milk");
		dairyList.add("Cottage cheese");
		dairyList.add("Processed cheese");
		dairyList.add("Yogurt");
		dairyList.add("Cream/kefir");
		ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dairyList);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem2.setAdapter(adapter2);
		
	}
	
	
	private void chooseMeatItems() {
		selectItem3=(Spinner)findViewById(R.id.food_item);
		
		List<String> meatList=new ArrayList<String>();
		meatList.add("Chicken");
		meatList.add("Turkey");
		meatList.add("Beef");
		ArrayAdapter<String> adapter3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, meatList);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem3.setAdapter(adapter3);
	}
	
	private void chooseGreansItems(){
		selectItem4=(Spinner)findViewById(R.id.food_item);
	
		List<String> greensList = new ArrayList<String>();
		greensList.add("Salats");
		greensList.add("Carrot");
		greensList.add("Apples");
		greensList.add("Anything");
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, greensList);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem4.setAdapter(adapter4);
	}
	
	private void chooseOtherItems(){
		selectItem5=(Spinner)findViewById(R.id.food_item);
		selectItem5.setClickable(false);
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
