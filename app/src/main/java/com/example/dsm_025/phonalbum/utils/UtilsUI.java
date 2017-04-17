package com.example.dsm_025.phonalbum.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dsm_025.phonalbum.PhoNalbumApplication;
import com.example.dsm_025.phonalbum.R;
import com.example.dsm_025.phonalbum.adapters.NumberAdapter;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Calendar;

/**
 * Created by dsm_025 on 2017-04-12.
 */

public class UtilsUI {

    public static int darker(int color, double factor) {
        int a = Color.alpha(color);
        int r = Color.alpha(color);
        int g = Color.alpha(color);
        int b = Color.alpha(color);

        return Color.argb(a, Math.max((int) (r * factor), 0), Math.max((int) (g * factor), 0), Math.max((int) (b * factor), 0));
    }

    public static Drawer setNavigationDraer(Activity activity, final Context context, Toolbar toolbar, final NumberAdapter numberAdapter, final NumberAdapter favoriteAdapter, final RecyclerView recyclerView) {
        final String loadingLabel = "...";
        int header;
        AppPreferences appPreferences = PhoNalbumApplication.getAppPreferences();

        if (getDayOrNight() == 1) {
            header = R.drawable.header_day;
        } else {
            header = R.drawable.header_night;
        }

        if (numberAdapter != null) {

        }

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(header)
                .build();

        Integer badgeColor = ContextCompat.getColor(context, R.color.divider);
        BadgeStyle badgeStyle = new BadgeStyle(badgeColor, badgeColor).withTextColor(Color.GRAY);

        DrawerBuilder drawerBuilder = new DrawerBuilder();
        drawerBuilder.withActivity(activity);
        drawerBuilder.withToolbar(toolbar);
        drawerBuilder.withAccountHeader(headerResult);
        drawerBuilder.withStatusBarColor(UtilsUI.darker(appPreferences.getPrimaryColorPref(), 0.8));

        drawerBuilder.addDrawerItems(
                new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_all_list)),
                new DividerDrawerItem(),
                new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_favorite)));

        drawerBuilder.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                switch (drawerItem.getIdentifier()){
                    case 1:
                        recyclerView.setAdapter(numberAdapter);
                        break;
                    case 2:
                        recyclerView.setAdapter(favoriteAdapter);
                }

                return false;
            }
        });
        return drawerBuilder.build();
    }

    public static int getDayOrNight() {
        int actualHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (actualHour >= 8 && actualHour < 19) {
            return 1;
        } else {
            return 0;
        }
    }
}
