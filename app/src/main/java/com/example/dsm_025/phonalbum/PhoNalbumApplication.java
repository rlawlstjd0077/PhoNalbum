package com.example.dsm_025.phonalbum;

import android.app.Application;

import com.example.dsm_025.phonalbum.utils.AppPreferences;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.Iconics;

/**
 * Created by dsm_025 on 2017-04-12.
 */

public class PhoNalbumApplication extends Application{
    private static AppPreferences sAppPreferences;
    private static boolean isPro;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppPreferences = new AppPreferences(this);

        Iconics.registerFont(new GoogleMaterial());
    }

    public static AppPreferences getAppPreferences() {
        return sAppPreferences;
    }
}
