package com.example.dsm_025.phonalbum.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.dsm_025.phonalbum.R;

/**
 * Created by dsm_025 on 2017-04-12.
 */

public class AppPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public static final String KeyPrimaryColor = "prefPrimaryColor";
    public static final String KeyCustomPath = "prefCustomPath";

    public AppPreferences(Context context){
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
        this.context = context;
    }

    public int getPrimaryColorPref() {
        return sharedPreferences.getInt(KeyPrimaryColor, context.getResources().getColor(R.color.primary));
    }

    public void setPrimaryColorPref(Integer res) {
        editor.putInt(KeyPrimaryColor, res);
        editor.commit();
    }

    public String getCustomPath(){
        return sharedPreferences.getString(KeyCustomPath, UtilsApp.getDefaultAppFolder().getPath());
    }

    public void setCustomPath(String path) {
        editor.putString(KeyCustomPath, path);
        editor.commit();
    }
}
