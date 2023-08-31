package com.example.constitution_of_india;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private Context context;                        //context means address
    private SharedPreferences.Editor editor;        //when update or edit
    public final String MY_PRESS_NAME="myPrefrene";
    private SharedPreferences pref;

    public SharedPreference(Context context) {
        this.context = context;
        this.editor = context.getSharedPreferences(MY_PRESS_NAME,context.MODE_PRIVATE).edit(); // To Put data
        this.pref = context.getSharedPreferences(MY_PRESS_NAME,context.MODE_PRIVATE);        // TO GET Data
    }

    public String putPreferenceValue(String key, int value){
        editor.putInt(key,value);
        editor.commit();
        return key;
    }


    public int getPreferenceValues(String key){
        int ans = pref.getInt(key, 0);
        return ans;
    }


    public void clearSharedPrefrence2(){
        pref.edit().clear().apply();               // to clear the prefrence
    }

    public void clearSharedPrefrence() {
    }
}
