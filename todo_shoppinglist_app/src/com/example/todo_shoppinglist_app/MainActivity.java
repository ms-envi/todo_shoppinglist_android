package com.example.todo_shoppinglist_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


public class MainActivity extends Activity {
	
	private ImageButton mBtn1,mBtn2;
	private DrawerLayout mDrawerLayout;
	private ListView mListViewDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mListViewDrawer = (ListView) findViewById(R.id.left_drawer);
        
        
        mBtn1 = (ImageButton)findViewById(R.id.button1);
        mBtn2=(ImageButton)findViewById(R.id.button2);
        
        mBtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent shopping = new Intent(getApplicationContext(), ShoppingListActivity.class);
				startActivity(shopping);
				
			}
		});
        
        mBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent todo = new Intent(getApplicationContext(), TodoListActivity.class);
				startActivity(todo);
				
			}
		});
        
        
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
