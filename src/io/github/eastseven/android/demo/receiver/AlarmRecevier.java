package io.github.eastseven.android.demo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmRecevier extends BroadcastReceiver {

	private static final String tag = "D7_AlarmRecevier";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//Log.d(tag, "context="+context+", intent="+intent);
		
		Log.d(tag, "向服务端发送Http请求。。。"+this);
	}

}
