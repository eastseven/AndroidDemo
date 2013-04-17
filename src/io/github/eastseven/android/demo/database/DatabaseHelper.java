package io.github.eastseven.android.demo.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * SQLite3 数据类型包括：Integer, Real, Text, Blob, Numeric
 * @author eastseven
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String tag = "D7_DatabaseHelper";
	
	private static final int DATABASE_VERSION = 7;
	private static final String DATABASE_NAME = "d7"; 
	
	private static final String DB_TNAME_USER = "d7_sqlite_user";
	private static final String DB_TABLE_USER = "create table " + DB_TNAME_USER + " (_id integer primary key autoincrement, username text, password text, updatetime TIMESTAMP default (datetime('now', 'localtime')) );";
	
	SQLiteDatabase db;
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_TABLE_USER);
		Log.d(tag, DB_TABLE_USER);
		Log.d(tag, "数据库创建完毕。。。");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table "+DB_TNAME_USER);
		db.execSQL(DB_TABLE_USER);
		Log.d(tag, "数据库更新完毕。。。");
	}

	public void create(String username, String password) throws Exception {
		this.db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", username);
		values.put("password", password);
		long count = db.insert(DB_TNAME_USER, null, values);
		this.db.close();
		
		Log.d(tag, "写入记录数："+count);
	}
	
	public List<Map<String, Object>> read(int limt) throws Exception {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> row = null;
		this.db = this.getReadableDatabase();
		
		String orderBy = "updatetime desc";
		Cursor cursor = this.db.query(DB_TNAME_USER, null, null, null, null, null, orderBy);
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false) {
			int    id         = cursor.getInt(0);
			String username   = cursor.getString(1);
			String password   = cursor.getString(2);
			String updatetime = cursor.getString(3);
			
			cursor.moveToNext();

			row = new HashMap<String, Object>();
			row.put("id", id);
			row.put("username", username);
			row.put("password", password);
			row.put("updatetime", updatetime);
			
			list.add(row);
			Log.d(tag, "row="+row);
		}
		this.db.close();
		return list; 
	}
	
	public void update() {}
	
	public void delete() {}
}
