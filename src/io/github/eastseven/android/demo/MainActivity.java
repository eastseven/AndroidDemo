package io.github.eastseven.android.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

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
	
	Button requestButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Log.d(tag, "onCreate");
		
		this.initListView();
		
		this.requestButton = (Button) findViewById(R.id.main_request);
		this.requestButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		/*
		Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());  
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
		startActivity(i);
		*/
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					
					
					URL url = new URL("http://eastseven.iicp.net:1337");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					Log.d(tag, "conn.id=" + conn);
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String line = null;
					while((line = reader.readLine()) != null) {
						Log.d(tag, line);
					}
					
					reader.close();
					//conn.disconnect();
					Log.d(tag, "conn disconnect...");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					Socket socket = new Socket("eastseven.iicp.net", 1338);
					BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String l = null;
					
					while((l = r.readLine()) != null) {
						Log.d(tag, "TCP: " + l);
					}
					
					socket.close();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}).start();
	}
	
	void initListView() {
		this.menus = this.getResources().getStringArray(R.array.menus);
		
		this.setListView();
		
		//sendBroadcast(new Intent("io.github.eastseven.android.demo"));
		//startService(new Intent(this, RabbitmqService.class));
		//startService(new Intent(this, AlarmService.class));
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
                case 5:
                    startActivity(new Intent(view.getContext(), TelephonyActivity.class));
                    break;
				default:
					break;
				}
			}
		});
	}
}
