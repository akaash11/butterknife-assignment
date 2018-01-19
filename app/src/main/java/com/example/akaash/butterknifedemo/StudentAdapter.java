package com.example.akaash.butterknifedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akaash on 10/1/18.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> list;

    public StudentAdapter(List<Student> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.list_item_student, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student item = list.get(position);
        holder.tvName.setText(item.getName());
    }


    @Override
    public int getItemCount() {
        int count = 0;
        if (null != list) {
            count = list.size();
        }
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
