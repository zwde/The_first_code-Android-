package com.example.zw.the_first_code;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 2016/8/7.
 */
public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<Activity>();
    public static void AddActivity(Activity activity){
        activities.add(activity);
    }
    public static void RemoveActivity(Activity activity){
        activities.remove(activity);
    }

    public  static void FinishAll(){
        for(Activity activity:activities){
            activity.finish();
        }
    }


}
