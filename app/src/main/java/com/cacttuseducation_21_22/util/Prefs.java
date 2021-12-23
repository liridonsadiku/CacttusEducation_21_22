package com.cacttuseducation_21_22.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    public static String KEY_SHARED_PREFERENCES = "com.cacttus.education21_22";

    public static SharedPreferences getPrefs(Context context){
        return context.getSharedPreferences(KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void saveString(Context context, String key, String value){
        getPrefs(context).edit().putString(key,value).apply();
    }

    public static String getString(Context context, String key){
        return getPrefs(context).getString(key,"");
    }

    public static void saveBoolean(Context context, String key, boolean value){
        getPrefs(context).edit().putBoolean(key,value).apply();
    }

    public static boolean getBoolean(Context context, String key){
        return getPrefs(context).getBoolean(key,false);
    }




}
