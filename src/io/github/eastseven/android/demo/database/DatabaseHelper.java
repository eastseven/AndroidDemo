package io.github.eastseven.android.demo.database;

import android.content.Context;
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
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "d7"; 
	
	private static final String DB_TNAME_USER = "sqlite_user";
	private static final String DB_TABLE_USER = "create table " + DB_TNAME_USER + " (username text, password text, updatetime text)";
	
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

	void create() {
		
	}
	
	Object read() {
		return null; 
	}
	
	void update() {}
	
	void delete() {}
}
