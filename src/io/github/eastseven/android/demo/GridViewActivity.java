package io.github.eastseven.android.demo;

import io.github.eastseven.android.demo.adapter.GridImageViewAdapter;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

public class GridViewActivity extends Activity {

	GridView gridView;
	ListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view);
		
		this.gridView = (GridView) findViewById(R.id.main_grid_view);
		//this.gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		this.adapter = new GridImageViewAdapter(this, 0, getImageIds());
		this.gridView.setAdapter(adapter);
	}
	
	ArrayList<Integer> getImageIds() {
		ArrayList<Integer> ids = new ArrayList<Integer>(9);
		ids.add(R.drawable.grid_view_1);
		ids.add(R.drawable.grid_view_2);
		ids.add(R.drawable.grid_view_3);
		
		ids.add(R.drawable.grid_view_4);
		ids.add(R.drawable.grid_view_5);
		ids.add(R.drawable.grid_view_6);
		
		ids.add(R.drawable.grid_view_7);
		ids.add(R.drawable.grid_view_8);
		ids.add(R.drawable.grid_view_9);
		
		return ids;
	}
}
