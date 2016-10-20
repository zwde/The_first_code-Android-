package com.example.zw.the_first_code;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class send_message extends Activity {
  private EditText to;
    private EditText msgInput;
    private Button send;

    //检测短信是否发送成功
    private IntentFilter sendFilter;
private SendStatusReceiver sendStatusReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_send_message);
        to=(EditText)findViewById(R.id.to);
   msgInput=(EditText)findViewById(R.id.msg_input);
        send=(Button)findViewById(R.id.send);

        sendFilter=new IntentFilter();
        sendFilter.addAction("SENT_SMS_ACTION");
        sendStatusReceiver=new SendStatusReceiver();
        registerReceiver(sendStatusReceiver,sendFilter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager=SmsManager.getDefault();
               Intent sentIntent=new Intent("SENT_SMS_ACTION");
                PendingIntent pi=PendingIntent.getBroadcast(send_message.this,0,sentIntent,0);
                smsManager.sendTextMessage(to.getText().toString(),null,
                        msgInput.getText().toString(),pi,null);
            }
        });
    }
class SendStatusReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if (getResultCode() == RESULT_OK) {
            // 短信发送成功
            Toast.makeText(context, "Send succeeded", Toast.LENGTH_LONG).show();
        } else {
            // 短信发送失败
            Toast.makeText(context, "Send failed", Toast.LENGTH_LONG).show();
        }

    }
}

}
