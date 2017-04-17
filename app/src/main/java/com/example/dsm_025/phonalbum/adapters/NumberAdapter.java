package com.example.dsm_025.phonalbum.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dsm_025.phonalbum.NumberInfo;
import com.example.dsm_025.phonalbum.PhoNalbumApplication;
import com.example.dsm_025.phonalbum.R;
import com.example.dsm_025.phonalbum.utils.AppPreferences;
import com.gc.materialdesign.views.ButtonFlat;

import java.util.List;

/**
 * Created by dsm_025 on 2017-04-12.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> implements Filterable {
    private AppPreferences appPreferences;

    private List<NumberInfo> numberList;
    private List<NumberInfo> numberListSearch;
    private Context context;

    public NumberAdapter(List<NumberInfo> numberList, Context context){
        this.context = context;
        this.appPreferences = PhoNalbumApplication.getAppPreferences();
    }

    @Override
    public int getItemCount(){
        return numberList.size();
    }

    public void clear(){
        numberList.clear();
        notifyDataSetChanged();
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        NumberInfo numberInfo = numberList.get(position);
        holder.vName.setText(numberInfo.getName());
        holder.vNumber.setText(numberInfo.getNumber());
//        holder.vIcon.setImageDrawable(R.drawable.);


    }

    private void setButtonEvents(NumberViewHolder viewHolder, final NumberInfo numInfo){
        final CardView cardViwe = viewHolder.vCard;

        cardViwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = (Activity) context;

                Intent intent = new Intent(context, )
            }
        });
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public static class NumberViewHolder extends RecyclerView.ViewHolder{
        protected TextView vName;
        protected TextView vNumber;
        protected ImageView vIcon;
        protected CardView vCard;
        public NumberViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.txtName);
            vNumber = (TextView) v.findViewById(R.id.txtNumber);
            vIcon = (ImageView) v.findViewById(R.id.imgIcon);
            vCard = (CardView) v.findViewById(R.id.number_card);
        }
    }
}
