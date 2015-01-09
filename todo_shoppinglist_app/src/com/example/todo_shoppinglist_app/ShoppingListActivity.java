package com.example.todo_shoppinglist_app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ShoppingListActivity extends Activity {

	private Spinner selectCategory, selectItem1;
	private Button addBtn, clearBtn;
	private TextView addOthers;
	private ListView lview;
	private ArrayAdapter<String> adapterListView;
	private ArrayList<String> itemList;
	protected static final int CONTEXTMENU_EDIT = 1;
	protected static final int CONTEXTMENU_DELETE = 2;
	private static final String TAG="ShoppingListActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate (Bundle) called");
		setContentView(R.layout.shopping_list);

		addListenerOnSpinnerSelection();

		// edit text field implementation
		addOthers = (TextView) findViewById(R.id.other_edit_text);
		addOthers.setHint("Type other stuff here");

		// clear text field and set first spinner to default value
		clearBtn = (Button) findViewById(R.id.clear);
		clearBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addOthers.setText("");
				selectCategory.setSelection(0);
				selectItem1.setEnabled(true);

			}
		});

		// add button
		addBtn = (Button) findViewById(R.id.add);
		addBtn.setOnClickListener(addListener);

		// list view to display list
		lview = (ListView) findViewById(R.id.listView1);
		itemList = new ArrayList<String>();
		adapterListView = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, itemList);
		registerForContextMenu(lview);

		// end OnCreate

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
		System.out.println(pos);
		System.out.println(item.getTitle());
		System.out.println(item.getItemId());
		if (item.getItemId()==2) {
			itemList.remove(pos);
			adapterListView.notifyDataSetChanged();
			
		} else System.out.println("DUPA nie dzia³a");
		

		return true;
	}

	private OnClickListener addListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			// Other is selected so i need to get text from edit text and pass
			// to adapter and then to listview
			if (selectCategory.getSelectedItemPosition() == 5) {

				addItem(addOthers.getText().toString());
				lview.setAdapter(adapterListView);
				addOthers.setText("");

			}

			else {
				addItem(selectItem1.getSelectedItem().toString());
				lview.setAdapter(adapterListView);

			}

		}
	};

	public void addItem(String item) {

		itemList.add(item);
		adapterListView.notifyDataSetChanged();

	}

	private void addListenerOnSpinnerSelection() {
		selectCategory = (Spinner) findViewById(R.id.food_category);
		selectCategory.setOnItemSelectedListener(new CustomOnItemSelect());
	}

	private void chooseBakingItems() {
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

	private void chooseDairyItems() {
		selectItem1 = (Spinner) findViewById(R.id.food_item);

		List<String> dairyList = new ArrayList<String>();
		dairyList.add("Milk");
		dairyList.add("Cottage cheese");
		dairyList.add("Processed cheese");
		dairyList.add("Yogurt");
		dairyList.add("Cream/kefir");
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dairyList);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem1.setAdapter(adapter2);

	}

	private void chooseMeatItems() {
		selectItem1 = (Spinner) findViewById(R.id.food_item);

		List<String> meatList = new ArrayList<String>();
		meatList.add("Chicken");
		meatList.add("Turkey");
		meatList.add("Beef");
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, meatList);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem1.setAdapter(adapter3);
	}

	private void chooseGreansItems() {
		selectItem1 = (Spinner) findViewById(R.id.food_item);

		List<String> greensList = new ArrayList<String>();
		greensList.add("Salats");
		greensList.add("Carrot");
		greensList.add("Apples");
		greensList.add("Anything");
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, greensList);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		selectItem1.setAdapter(adapter4);
	}

	private void chooseOtherItems() {
		selectItem1 = (Spinner) findViewById(R.id.food_item);
		selectItem1.setEnabled(false);
		addOthers.setEnabled(true);

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

	private class CustomOnItemSelect implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {

			findViewById(R.id.food_category).setEnabled(true);
			addOthers.setHint("Type other stuff here");
			addOthers.setEnabled(false);

			switch (parent.getPositionForView(view)) {

			case 1:
				position = 1;
				// if i choose 'Bakery' then the dropdown list in spinner2
				// should be
				// load with list with bakery
				// chooseBakingItems();

				chooseBakingItems();
				Toast.makeText(parent.getContext(), "Choose baking items",
						Toast.LENGTH_LONG).show();

				break;

			case 2:
				position = 2;

				chooseDairyItems();
				Toast.makeText(parent.getContext(), "Choose diary item",
						Toast.LENGTH_LONG).show();
				break;

			case 3:
				position = 3;
				chooseMeatItems();
				Toast.makeText(parent.getContext(), "Choose meat item",
						Toast.LENGTH_LONG).show();

				break;

			case 4:
				position = 4;
				chooseGreansItems();
				Toast.makeText(parent.getContext(), "Choose green item",
						Toast.LENGTH_LONG).show();
				break;

			case 5:
				position = 5;
				chooseOtherItems();
				Toast.makeText(parent.getContext(), "Type other item",
						Toast.LENGTH_LONG).show();
				break;

			}

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	}
}
