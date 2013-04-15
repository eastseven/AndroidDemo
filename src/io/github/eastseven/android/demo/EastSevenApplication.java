package io.github.eastseven.android.demo;

import android.app.Application;
import android.util.Log;

public class EastSevenApplication extends Application {

	private static final String tag = "D7_EastSevenApplication";
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(tag, "onCreate");
	}
}
