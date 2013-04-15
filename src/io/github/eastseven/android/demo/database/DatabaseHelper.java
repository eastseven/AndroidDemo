package io.github.eastseven.android.demo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String tag = "D7_DatabaseHelper";
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "d7"; 
	
	private static final String DB_TNAME_DATA_TYPE = "sqlite_data_type";
	private static final String DB_TABLE_DATA_TYPE = "create table " + DB_TNAME_DATA_TYPE + " (n_int integer, n_real real, n_text text, n_blob blob, n_bool integer, n_numeric numeric)";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(tag, DB_TABLE_DATA_TYPE);
		db.execSQL(DB_TABLE_DATA_TYPE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
