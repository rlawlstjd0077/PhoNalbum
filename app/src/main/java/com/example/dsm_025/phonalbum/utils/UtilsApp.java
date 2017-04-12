package com.example.dsm_025.phonalbum.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import com.example.dsm_025.phonalbum.PhoNalbumApplication;
import java.io.File;

/**
 * Created by dsm_025 on 2017-04-12.
 */

public class UtilsApp {
    private static final int MY_PERMISSIONS_REQUEST_WRITE_READ = 1;

    public static File getDefaultAppFolder(){
        return new File(Environment.getExternalStorageDirectory() + "/PhoNalbum");
    }

    public static File getAppFolder(){
        AppPreferences appPreferences = PhoNalbumApplication.getAppPreferences();
        return new File(appPreferences.getCustomPath());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static Boolean checkPermissions(Activity activity){
        Boolean res = false;
        if(ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            activity.requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_READ);
        }else{
            res = true;
        }
        return res;
    }
}
