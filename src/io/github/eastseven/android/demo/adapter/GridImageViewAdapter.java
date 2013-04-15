package io.github.eastseven.android.demo.adapter;

import io.github.eastseven.android.demo.R;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

public class GridImageViewAdapter extends ArrayAdapter<Integer> {

	private static final String tag = "D7_GridImageViewAdapter";
	
	ArrayList<Integer> imageViewIds;

	public GridImageViewAdapter(Context context, int textViewResourceId, ArrayList<Integer> objects) {
		super(context, textViewResourceId, objects);
		this.imageViewIds = objects;
		Log.d(tag, "GridImageViewAdapter");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		
		if(view == null) {
			view = LayoutInflater.from(getContext()).inflate(R.layout.grid_view_item, null);
		}
		
		ImageButton image = (ImageButton) view.findViewById(R.id.main_grid_view_image);
		image.setImageResource(imageViewIds.get(position));
		return view;
	}
}
