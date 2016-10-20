package com.example.zw.the_first_code;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by zw on 2016/8/12.
 */
public class NotificationActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
  setContentView(R.layout.notification_layout);
        NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);
    }
}
