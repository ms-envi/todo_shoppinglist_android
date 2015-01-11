package com.example.todo_shoppinglist_app.helpers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;


import android.content.ClipData.Item;
import android.content.Context;

public class ShoppingListJSONSerializer {
	
	
	private Context mContext;
	private String mFilename;

	public ShoppingListJSONSerializer(Context c, String f) {
		mContext=c;
		mFilename=f;
	}
	
	public void saveShoppingList(ArrayList<ShoppingList> items) throws JSONException, IOException
	{
		//Build an array in JSON
		JSONArray array = new JSONArray();
		for (ShoppingList l: items)
			array.put(l.toJSON());
		
		//Write the file to disk
		Writer writer= null;
		
		try{
			OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
			writer= new OutputStreamWriter(out);
			writer.write(array.toString());
		}
		finally
		{ if (writer !=null)
			writer.close();
		}
		
	}

}
