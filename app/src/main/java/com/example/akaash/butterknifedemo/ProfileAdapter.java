package com.example.akaash.butterknifedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akaash on 10/1/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private List<Profile> profileList;

    public ProfileAdapter(List<Profile> listProfile) {
        this.profileList=listProfile;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.list_item_profile, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Profile item=profileList.get(position);

        holder.tvProfilename.setText(item.getName());
        holder.tvProfileURL.setText(item.getUrl());
        holder.tvProfileURL.setText(item.getUrl());
        holder.tvDataOne.setText(item.getDataOne());
        holder.tvDataTwo.setText(item.getDataTwo());
    }

    @Override
    public int getItemCount() {
        int count=0;
        if(profileList!=null){
            count=profileList.size();
        }
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProfileName)
        TextView tvProfilename;

        @BindView(R.id.tvProfileURL)
        TextView tvProfileURL;

        @BindView(R.id.tvDataone)
        TextView tvDataOne;

        @BindView(R.id.tvDatatwo)
        TextView tvDataTwo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
