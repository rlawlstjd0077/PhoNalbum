package com.example.dsm_025.phonalbum.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.dsm_025.phonalbum.NumberInfo;
import com.example.dsm_025.phonalbum.utils.AppPreferences;

import java.util.Set;

/**
 * Created by dsm_025 on 2017-04-17.
 */

public class NumberActivity extends AppCompatActivity{
    private AppPreferences appPreferences;

    private NumberInfo numInfo;
    private Set<String> numbersFavorite;

    private Context context;
    private Activity activity;
    private MenuItem item_favorite;


}
