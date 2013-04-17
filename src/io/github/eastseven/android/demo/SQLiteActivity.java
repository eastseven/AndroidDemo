package io.github.eastseven.android.demo;

import io.github.eastseven.android.demo.adapter.SQLiteListAdapter;
import io.github.eastseven.android.demo.database.DatabaseHelper;

import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SQLiteActivity extends Activity implements OnScrollListener {

	private static final String tag = "D7_SQLiteActivity";

	ActionBar actionBar;

	DatabaseHelper dbHelper;
	
	SQLiteListAdapter adapter;
	ListView listview;
	Button loadmore;
	
	List<Map<String, Object>> list;
	
	final int limt = 8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);
		Log.d(tag, "onCreate");

		this.actionBar = getActionBar();
		this.actionBar.setDisplayHomeAsUpEnabled(true);

		this.listview = (ListView) findViewById(R.id.sqlite_listview);
		this.listview.setOnScrollListener(this);
		this.loadData();//TODO 需要改成异步加载
		
		this.loadmore = (Button) findViewById(R.id.sqlite_listview_load_more);
		this.loadmore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					adapter.addAll(dbHelper.read(limt));
					adapter.notifyDataSetChanged();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	void loadData() {
		try {
			dbHelper = new DatabaseHelper(getApplicationContext());
			list = dbHelper.read(limt);
			adapter = new SQLiteListAdapter(SQLiteActivity.this, 0, list);
			listview.setAdapter(adapter);
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(SQLiteActivity.this, "加载数据出错", Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sqlite, menu);
		Log.d(tag, "onCreateOptionsMenu");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean bln = true;
		Log.d(tag, "onOptionsItemSelected=" + item);
		Log.d(tag, "item title=" + item.getTitle());
		switch (item.getItemId()) {
		case android.R.id.home:
			
			// app icon in action bar clicked; go home
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			
			break;
		case R.id.sqlite_add:
			
			startActivity(new Intent(this, SQLiteFormActivity.class));
			
			break;
		case R.id.sqlite_delete:
			
			break;
		case R.id.sqlite_edit:
			
			break;
		case R.id.sqlite_search:
			
			break;
		default:
			bln = super.onOptionsItemSelected(item);
		}
		
		return bln;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		Log.d(tag, "onScrollStateChanged view="+view+", scrollState="+scrollState);
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		Log.d(tag, "onScroll view="+view+", firstVisibleItem="+firstVisibleItem+", visibleItemCount="+visibleItemCount+", totalItemCount="+totalItemCount);
	}

}
