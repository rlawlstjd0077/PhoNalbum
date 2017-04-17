package com.example.dsm_025.phonalbum.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dsm_025.phonalbum.R;
import com.example.dsm_025.phonalbum.adapters.NumberAdapter;
import com.example.dsm_025.phonalbum.utils.AppPreferences;
import com.example.dsm_025.phonalbum.utils.UtilsApp;
import com.example.dsm_025.phonalbum.utils.UtilsUI;
import com.mikepenz.materialdrawer.Drawer;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.yalantis.phoenix.PullToRefreshView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fast_scroller) VerticalRecyclerViewFastScroller fastScroller;
    @BindView(R.id.progress) ProgressWheel progressWheel;
    @BindView(R.id.noResults) LinearLayout noResult;
    @BindView(R.id.pull_to_refresh) PullToRefreshView pullToRefreshView;
    @BindView(R.id.numList) RecyclerView recyclerView;

    private AppPreferences appPreferences;

    private Activity activity;
    private Context context;
    private Drawer drawer;
    private NumberAdapter numberAdapter;
    private NumberAdapter favoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.activity = this;
        this.context = this;

        setInitialConfiguration();
        checkAndAddPermission(activity);
        setAppDir();

        pullToRefreshView.setEnabled(false);


        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        drawer = UtilsUI.setNavigationDraer((Activity) context, context, toolbar, numberAdapter, favoriteAdapter, recyclerView);

        progressWheel.setBarColor(appPreferences.getPrimaryColorPref());
        progressWheel.setVisibility(View.VISIBLE);

    }

    private void setInitialConfiguration(){
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.app_name);
        }
    }

    private void checkAndAddPermission(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilsApp.checkPermissions(activity);
        }
    }

    private void setAppDir(){
        File appDir = UtilsApp.getAppFolder();
        if(!appDir.exists()){
            appDir.mkdir();
        }
    }
}
