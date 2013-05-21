package io.github.eastseven.android.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

/**
 * Created by eastseven on 13-5-21.
 */
public class TelephonyActivity extends Activity implements View.OnClickListener {

    private Button btn;

    private TelephonyManager mTelephonyManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telephony_manager);
        this.btn = (Button) findViewById(R.id.button);
        this.mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }

    @Override
    public void onClick(View v) {

    }
}