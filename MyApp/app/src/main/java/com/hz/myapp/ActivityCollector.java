package com.hz.myapp;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollector {
    public static ArrayList<Activity> activities = new ArrayList<>();

    public static  void add(Activity activity){
        activities.add(activity);
    }

    public static void remove(Activity activity){
        activities.remove(activity);
    }

    public static void removeAll(){
        for (Activity activity:activities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
