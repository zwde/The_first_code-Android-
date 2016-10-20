package com.example.zw.the_first_code;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by zw on 2016/8/13.
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      new Thread(new Runnable() {
          @Override
          public void run() {
              //处理逻辑
              stopSelf();
          }
      }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
