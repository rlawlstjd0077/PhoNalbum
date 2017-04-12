package com.example.dsm_025.phonalbum.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.dsm_025.phonalbum.R;
import com.example.dsm_025.phonalbum.utils.UtilsApp;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.yalantis.phoenix.PullToRefreshView;

import java.io.File;

import butterknife.Bind;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.fast_scroller) VerticalRecyclerViewFastScroller fastScroller;
    @Bind(R.id.progress) ProgressWheel progressWheel;
    @Bind(R.id.noResults) LinearLayout noResult;
    @Bind(R.id.pull_to_refresh) PullToRefreshView pullToRefreshView;
    RecyclerView recyclerView;

    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.activity = this;
        this.context = this;

        setInitialConfiguration();
        checkAndAddPermission(activity);
        setAppDir();


        recyclerView = (RecyclerView) findViewById(R.id.numList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        pullToRefreshView.setEnabled(false);
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
