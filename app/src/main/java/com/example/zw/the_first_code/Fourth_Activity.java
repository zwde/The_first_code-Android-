package com.example.zw.the_first_code;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class Fourth_Activity extends Activity implements View.OnClickListener{
      private Button Btn1,Btn2,Btn3,Btn4,Btn5,btn_startService,btn_stopService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fourth_);
        Btn1=(Button)findViewById(R.id.Btn1);
        Btn2=(Button)findViewById(R.id.Btn2);
        Btn3=(Button)findViewById(R.id.Btn3);
        Btn4=(Button)findViewById(R.id.Btn4);
        Btn5=(Button)findViewById(R.id.Btn5);
        btn_startService=(Button)findViewById(R.id.start_service);
        btn_stopService=(Button)findViewById(R.id.stop_service);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        Btn4.setOnClickListener(this);
        Btn5.setOnClickListener(this);
        btn_startService.setOnClickListener(this);
        btn_stopService.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btn1:
                Intent intent=new Intent(Fourth_Activity.this,fifth_Activity.class);
                startActivity(intent);
                break;
            case R.id.Btn2:
                Intent intent1=new Intent(Fourth_Activity.this,sixth_activity.class);
                startActivity(intent1);
                break;
            case R.id.Btn3:
                NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Notification notification=new Notification(R.drawable.noti,"Hello World",System.currentTimeMillis());
               Intent intent2=new Intent(this,NotificationActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent2, PendingIntent.FLAG_CANCEL_CURRENT);
                notification.setLatestEventInfo(Fourth_Activity.this,"This is content title","This is content text",pendingIntent);
                manager.notify(1,notification);
                break;
            case R.id.Btn4:
                Intent intent3=new Intent(Fourth_Activity.this,send_message.class);
                startActivity(intent3);
                break;
            case R.id.Btn5:
                Intent intent4=new Intent(Fourth_Activity.this,seventh_Activity.class);
                startActivity(intent4);
                break;
            case R.id.start_service:
                Intent startIntent=new Intent(this,MyService.class);
                startService(startIntent);//启动服务
                break;
            case R.id.stop_service:
                Intent stopIntent=new Intent(this,MyService.class);
                stopService(stopIntent);//停止服务
                break;
            default:
                break;
        }
    }
}
