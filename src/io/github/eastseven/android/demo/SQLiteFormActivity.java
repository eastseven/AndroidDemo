package io.github.eastseven.android.demo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteFormActivity extends Activity implements OnClickListener {

	private static final String tag = "D7_SQLiteFormActivity";

	EditText username, password;
	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_form);
		
		Log.d(tag, "onCreate");
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(true);
		
		this.username = (EditText) findViewById(R.id.sqlite_username);
		this.password = (EditText) findViewById(R.id.sqlite_password);
		this.submit   = (Button)   findViewById(R.id.sqlite_submit);
		this.submit.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sqlite_form, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			
			Intent intent = new Intent(this, SQLiteActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {
		String _username = this.username.getText().toString();
		String _password = this.password.getText().toString();
		
		if("".equals(_username)) {
			this.username.setError("username is null");
			return;
		}
		if("".equals(_password)) {
			this.password.setError("password is null");
			return;
		}
		Log.d(tag, "username="+_username+", password="+_password);
		
	}
}
