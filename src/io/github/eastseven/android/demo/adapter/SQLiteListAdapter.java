package io.github.eastseven.android.demo.adapter;

import io.github.eastseven.android.demo.R;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SQLiteListAdapter extends ArrayAdapter<Map<String, Object>> {

	private List<Map<String, Object>> objects;

	public SQLiteListAdapter(Context context, int textViewResourceId, List<Map<String, Object>> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(getContext()).inflate(R.layout.sqlite_item, null);

		Map<String, Object> row = this.objects.get(position);

		TextView username   = (TextView) view.findViewById(R.id.sqlite_item_username);
		TextView updateTime = (TextView) view.findViewById(R.id.sqlite_item_updatetime);

		username.setText(row.get("username").toString());
		updateTime.setText(row.get("updatetime").toString());

		return view;
	}

	// @Override
	// public HashMap<String, Object> getItem(int position) {
	// return this.objects.get(position);
	// }

}
