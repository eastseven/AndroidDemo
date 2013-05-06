package io.github.eastseven.android.demo.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AlarmService extends Service {

	private static final String tag = "D7_AlarmService";
	
	AlarmManager am;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(tag, "onCreate");
		
		PendingIntent operation = PendingIntent.getBroadcast(this, 2, new Intent("io.github.eastseven.android.demo"), 0);
		
		am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1234L, operation);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(tag, "intent="+intent+", flags="+flags+", startId="+startId);
		return super.onStartCommand(intent, flags, startId);
	}
}
