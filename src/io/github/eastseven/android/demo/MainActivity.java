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

	private static final String tag = "Main";
	
	ListView listView;
	
	final String[] menus = new String[] {"GridView"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Log.d(tag, "onCreate");
		
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
