package com.example.akaash.butterknifedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akaash on 11/1/18.
 */

public class StudentProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface Listener {
        void onClickStudentItem(Student student);

        void onClickCollegeName(College college);

        void onClickStar(University university, float changedValue, int position);
    }

    private List<Object> items;
    private Listener listener;
    private boolean onBind;

    private final int STUDENT = 0, COLLEGE = 1, UNIVERSITY = 2;

    public StudentProfileAdapter(List<Object> list, Listener listener) {
        this.items = list;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case STUDENT:
                View studentView = inflater.inflate(R.layout.list_item_profile, parent, false);
                viewHolder = new StudentViewHolder(studentView);
                break;

            case COLLEGE:
                View collegeView = inflater.inflate(R.layout.list_item_college, parent, false);
                viewHolder = new CollegeViewHolder(collegeView);
                break;
            case UNIVERSITY:
                View universityView = inflater.inflate(R.layout.list_item_university, parent, false);
                viewHolder = new UniversityViewHolder(universityView);
                break;
        }

        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {

        if (items.get(position) instanceof Profile) {
            return STUDENT;
        } else if (items.get(position) instanceof College) {
            return COLLEGE;
        } else if (items.get(position) instanceof University) {
            return UNIVERSITY;
        }
        return -1;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBind = true;
        switch (holder.getItemViewType()) {
            case STUDENT:
                StudentViewHolder studentViewHolder = (StudentViewHolder) holder;
                configureStudentViewHolder(studentViewHolder, position);
                break;
            case COLLEGE:
                CollegeViewHolder collegeViewHolder = (CollegeViewHolder) holder;
                configureCollegeViewHolder(collegeViewHolder, position);
                break;
            case UNIVERSITY:
                UniversityViewHolder universityViewHolder = (UniversityViewHolder) holder;
                configureUniversityHolder(universityViewHolder, position);
                break;
        }
        onBind = false;
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (items != null) {
            count = items.size();
        }
        return count;
    }

    private void configureStudentViewHolder(StudentViewHolder studentViewHolder, int position) {
        Profile profile = (Profile) items.get(position);

        studentViewHolder.tvProfilename.setText(profile.getName());
        studentViewHolder.tvProfileURL.setText(profile.getUrl());
        studentViewHolder.tvDataOne.setText(profile.getDataOne());
        studentViewHolder.tvDataTwo.setText(profile.getDataTwo());
    }

    private void configureCollegeViewHolder(CollegeViewHolder collegeViewHolder, int position) {

        College college = (College) items.get(position);

        collegeViewHolder.tvCollegeName.setText(college.getCollegeName());
    }

    private void configureUniversityHolder(UniversityViewHolder universityViewHolder, int position) {
        University university = (University) items.get(position);
        universityViewHolder.tvUniversityName.setText(university.getUniversityName());
        universityViewHolder.rbRating.setRating(university.getRating());
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.parentStudent)
        RelativeLayout parentStudent;

        @BindView(R.id.tvProfileName)
        TextView tvProfilename;

        @BindView(R.id.tvProfileURL)
        TextView tvProfileURL;

        @BindView(R.id.tvDataone)
        TextView tvDataOne;

        @BindView(R.id.tvDatatwo)
        TextView tvDataTwo;


        public StudentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            parentStudent.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == parentStudent) {
                if (null != listener && items.get(getAdapterPosition()) instanceof Student) {
                    listener.onClickStudentItem((Student) items.get(getAdapterPosition()));
                }
            }
        }
    }

    public class CollegeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.rlCollege)
        RelativeLayout parentCollege;

        @BindView(R.id.tvCollegeName)
        TextView tvCollegeName;

        public CollegeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            parentCollege.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == parentCollege) {
                if (null != listener) {
                    listener.onClickCollegeName((College) items.get(getAdapterPosition()));
                }
            }
        }
    }

    public class UniversityViewHolder extends RecyclerView.ViewHolder implements RatingBar.OnRatingBarChangeListener {

        @BindView(R.id.rbRating)
        RatingBar rbRating;

        @BindView(R.id.tvUniversityName)
        TextView tvUniversityName;

        public UniversityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rbRating.setOnRatingBarChangeListener(this);
        }

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            //University university = (University) items.get(getAdapterPosition());
            if (!onBind) {
                listener.onClickStar((University) items.get(getAdapterPosition()), v, getAdapterPosition());
            }
        }
    }

    public List<Object> getCurrentList() {
        return items;
    }

    public void invalidateList(List<Object> newList) {
        items.clear();
        items.addAll(newList);
        notifyDataSetChanged();
    }
}
