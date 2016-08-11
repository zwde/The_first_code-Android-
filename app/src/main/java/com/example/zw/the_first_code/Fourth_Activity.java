package com.example.zw.the_first_code;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class Fourth_Activity extends ActionBarActivity implements View.OnClickListener{
      private Button Btn1,Btn2,Btn3,Btn4,Btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_);
        Btn1=(Button)findViewById(R.id.Btn1);
        Btn1=(Button)findViewById(R.id.Btn2);
        Btn3=(Button)findViewById(R.id.Btn3);
        Btn4=(Button)findViewById(R.id.Btn4);
        Btn5=(Button)findViewById(R.id.Btn5);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btn1:
                Intent intent=new Intent(Fourth_Activity.this,fifth_Activity.class);
                startActivity(intent);
                break;
            case R.id.Btn2:
                break;
            case R.id.Btn3:
                break;
            case R.id.Btn4:
                break;
            case R.id.Btn5:
                break;
            default:
                break;
        }
    }
}
