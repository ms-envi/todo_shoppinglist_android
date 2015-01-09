package com.example.todo_shoppinglist_app;

import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class ShoppingList {
	
	private static final String JSON_ID="id";
	private static final String JSON_NAME="itemName";
	
	private UUID mId;
	private String mName;
	

	public ShoppingList() {
		mId=UUID.randomUUID();
	}
	
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_ID, mId.toString());
		json.put(JSON_NAME, mName.toString());
		return json;
	}
	
	@Override
	public String toString(){
		return mName;
	}

}
