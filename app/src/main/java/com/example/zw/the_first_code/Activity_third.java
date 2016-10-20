package com.example.zw.the_first_code;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;


public class Activity_third extends Activity implements View.OnClickListener{
private Button btn1,btn_alert,btn_ProgressDialog,btn2;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_activity_third);
        btn1=(Button)findViewById(R.id.Change_progress);
        btn1.setOnClickListener(this);
        progress=(ProgressBar)findViewById(R.id.process_bar);
        progress.setProgress(10);
        btn_alert=(Button)findViewById(R.id.btn_alert);
btn_alert.setOnClickListener(this);
        btn_ProgressDialog=(Button)findViewById(R.id.btn_ProgressDialog);
        btn_ProgressDialog.setOnClickListener(this);
        btn2=(Button)findViewById(R.id.Btn2);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Change_progress:
                int pro=progress.getProgress();
                pro=pro+10;
                progress.setProgress(pro);
                break;
            //弹出对话框
            case R.id.btn_alert:
                AlertDialog.Builder dialog=new AlertDialog.Builder(Activity_third.this);
                dialog.setTitle("Dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.btn_ProgressDialog:
                ProgressDialog progressDialog=new ProgressDialog(Activity_third.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                //设为true,表明ProgressDialog是不能通过Back键取消掉的
                // 一定要在代码中做好控制，当数据加载完成后必须要调用
                // ProgressDialog的dismiss()方法来关闭对话框，否则ProgressDialog将会一直存在
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.Btn2:
                Intent intent=new Intent(Activity_third.this,Fourth_Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
