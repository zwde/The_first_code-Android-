package com.example.zw.the_first_code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

   private Button btn1,btn2;
    //第一次被创建的时候调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActionBarActivity不行 Activity可以
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ActivityCollector.AddActivity(this);

        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        //finish(); 此方法直接销毁当前活动
        btn1=(Button)findViewById(R.id.Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用显式Intent 并且传值
                Intent intent=new Intent(MainActivity.this,Second.class);
                intent.putExtra("name","value");
                startActivity(intent);
            }
        });
btn2=(Button)findViewById(R.id.Btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过调用ActivityCollector类，此活动退出时销毁全部activity，而不是一个一个退出
                ActivityCollector.FinishAll();
            }
        });


    }
//此活动由不可见到可见的时候调用
    @Override
    protected void onStart() {
        super.onStart();
    }
    //此活动准备好和用户进行交互的时候调用，此时一定位于返回栈栈顶，并且处于运行状态
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.RemoveActivity(this);
    }
}
