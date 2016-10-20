package com.example.zw.the_first_code;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Window;
import android.widget.TextView;

//接收短信
public class sixth_activity extends Activity {
  private TextView sender,content;
    private IntentFilter receiveFilter;
    private  MessageReceiver messageReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sixth_activity);
        sender=(TextView)findViewById(R.id.sender);
        content=(TextView)findViewById(R.id.content);

        receiveFilter=new IntentFilter();
        receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        receiveFilter.setPriority(100);//设定优先级
        messageReceiver=new MessageReceiver();
        registerReceiver(messageReceiver,receiveFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
    }

    public class MessageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle=intent.getExtras();
            Object[] pdus=(Object[])bundle.get("pdus");//提取短信消息
            SmsMessage[] messages=new SmsMessage[pdus.length];
            for(int i=0;i<messages.length;i++){
                messages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
            }
            String address=messages[0].getOriginatingAddress();//获取发送方号码
            String fullMessage="";
            for(SmsMessage message:messages){
                fullMessage+=message.getMessageBody();//获取短信内容
            }
              sender.setText(address);
              content.setText(fullMessage);

            abortBroadcast();//接收短信后就拦截
        }
    }

}
