package io.github.eastseven.android.demo;

import io.github.eastseven.android.demo.service.RabbitmqService;
import io.github.eastseven.android.demo.service.AlarmService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

	private static final String tag = "D7_MainActivity";
	
	ListView listView;
	
	String[] menus;
	
	Button restart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Log.d(tag, "onCreate");
		
		this.initListView();
		
		this.restart = (Button) findViewById(R.id.main_restart);
		this.restart.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());  
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
		startActivity(i);
	}
	
	void initListView() {
		this.menus = this.getResources().getStringArray(R.array.menus);
		
		this.setListView();
		
		//sendBroadcast(new Intent("io.github.eastseven.android.demo"));
		startService(new Intent(this, RabbitmqService.class));
		startService(new Intent(this, AlarmService.class));
	}

	void setListView() {
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
					break;
				case 3:
					startActivity(new Intent(view.getContext(), io.github.eastseven.android.demo.effectivenavigation.MainActivity.class));
					break;
				case 4:
					startActivity(new Intent(view.getContext(), ColorsActivity.class));
					break;
				default:
					break;
				}
			}
		});
	}
}
