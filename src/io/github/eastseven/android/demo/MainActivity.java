package io.github.eastseven.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private static final String tag = "D7_MainActivity";
	
	ListView listView;
	
	String[] menus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Log.d(tag, "onCreate");
		
		this.menus = this.getResources().getStringArray(R.array.menus);
		
		this.listView = (ListView) findViewById(R.id.main_list_view);
		this.listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menus));
		this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String menu = menus[position];
				Log.d(tag, "view=" + view.getClass() + ", menu=" + menu);
				switch (position) {
				case 0:
					startActivity(new Intent(MainActivity.this, GridViewActivity.class));
					break;
				case 1:
					startActivity(new Intent(MainActivity.this, SQLiteActivity.class));
					break;
				case 2:
					startActivity(new Intent(view.getContext(), ActionBarActivity.class));
				case 3:
					startActivity(new Intent(view.getContext(), io.github.eastseven.android.demo.effectivenavigation.MainActivity.class));
				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
