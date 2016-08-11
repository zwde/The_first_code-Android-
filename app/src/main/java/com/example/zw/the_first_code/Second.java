package com.example.zw.the_first_code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


public class Second extends Activity implements View.OnClickListener {

    private Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        //使用intent接收值
        Intent intent1=getIntent();
        String data=intent1.getStringExtra("name");


btn2=(Button)findViewById(R.id.Btn2);

        btn1=(Button)findViewById(R.id.Btn1);
      btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式调用intent 先是action 然后可以加category，可以加多个category，看AndroidManifest.xml
                Intent intent=new Intent("third_activity");
                intent.addCategory("category_third");
                startActivity(intent);
            }
        });*/
    }


    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.Btn1:
            //隐式调用intent 先是action 然后可以加category，可以加多个category，看AndroidManifest.xml
            Intent intent=new Intent("third_activity");
            intent.addCategory("category_third");
            startActivity(intent);
            break;
        case R.id.Btn2:
            Toast.makeText(Second.this,"hello",Toast.LENGTH_SHORT);
            break;
    }
    }
}
