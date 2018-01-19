package com.example.akaash.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentDashboard extends AppCompatActivity {

    @BindView(R.id.rvStudent)
    RecyclerView rvStudent;

    private StudentProfileAdapter studentProfileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        ButterKnife.bind(this);
        recyclerView();
    }

    public void recyclerView() {
        rvStudent.setLayoutManager(new LinearLayoutManager(this));
        List<Object> list = new ArrayList<>();
        list.add(new Profile("Akaash Trivedi", "http://coditas.com", "Android developer", "Location: Pune"));
        list.add(new College("College name : VIT, Pune"));
        list.add(new University(3, "Pune University"));
        list.add(new Profile("Akaash Trivedi", "http://coditas.com", "Android developer", "Location: Pune"));
        list.add(new College("College name : VIT, Pune"));
        list.add(new University(5, "Pune University"));
        list.add(new Profile("Akaash Trivedi", "http://coditas.com", "Android developer", "Location: Pune"));
        list.add(new College("College name : VIT, Pune"));
        list.add(new University(5, "Pune University"));
        list.add(new Profile("Akaash Trivedi", "http://coditas.com", "Android developer", "Location: Pune"));
        list.add(new College("College name : VIT, Pune"));
        list.add(new University(5, "Pune University"));
        list.add(new Profile("Akaash Trivedi", "http://coditas.com", "Android developer", "Location: Pune"));
        list.add(new College("College name : VIT, Pune"));
        list.add(new University(5, "Pune University"));
        list.add(new Profile("Akaash Trivedi", "http://coditas.com", "Android developer", "Location: Pune"));
        list.add(new College("College name : VIT, Pune"));
        list.add(new University(5, "Pune University"));


        studentProfileAdapter = new StudentProfileAdapter(list, new StudentProfileAdapter.Listener() {
            @Override
            public void onClickStudentItem(Student student) {
                
            }

            @Override
            public void onClickCollegeName(College college) {

            }

            @Override
            public void onClickStar(University university, float changedValue, int position) {
                List<Object> list = new ArrayList<>();
                list.addAll(studentProfileAdapter.getCurrentList());
                university.setRating(changedValue);
                list.set(position, university);
                studentProfileAdapter.invalidateList(list);
            }
        });
        rvStudent.setAdapter(studentProfileAdapter);
    }
}
