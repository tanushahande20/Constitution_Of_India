package com.example.constitution_of_india;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference { private Context context;
    private SharedPreferences.Editor editor;
    public final String MY_PREFS_NAME = "myPreference";
    private SharedPreferences prefs;

    public MyPreference(Context context)
    {
        this.context = context;
        this.editor = context.getSharedPreferences(MY_PREFS_NAME , context.MODE_PRIVATE).edit();
        this.prefs = context.getSharedPreferences(MY_PREFS_NAME,context.MODE_PRIVATE);
    }
    public String putPreferenceValues (String key , String value)
    {
        editor.putString(key, value);
        editor.commit();
        return key;
    }


    public int putPreferenceValues (int key, int value)
    {
        editor.putInt(String.valueOf(key), value);
        editor.commit();
        return key;
    }

    public boolean putPreferenceValues (boolean key , boolean value)
    {
        editor.putBoolean(String.valueOf(key),value);
        editor.commit();
        return key;
    }
    public void clearSharedPreference(){
        prefs.edit().clear().apply();
    }

    public  String getPreferenceValues(String key)
    {
        return prefs.getString(key,"");
    }
    public  int getPreferenceValues(int key)
    {
        return prefs.getInt("", key);
    }
    public boolean getPreferenceValues (boolean key)
    {
        return prefs.getBoolean("True",key);
    }
}
