package io.github.eastseven.android.demo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class SQLiteActivity extends Activity {

	private static final String tag = "D7_SQLiteActivity";

	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);
		Log.d(tag, "onCreate");

		this.actionBar = getActionBar();
		this.actionBar.setDisplayHomeAsUpEnabled(true);
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

}
