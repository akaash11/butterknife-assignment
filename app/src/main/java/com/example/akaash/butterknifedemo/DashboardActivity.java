package com.example.akaash.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.searchView)
    SearchView searchView;

//    @BindView(R.id.rvStudent)
//    RecyclerView rvStudent;

    @BindView(R.id.rvProfile)
    RecyclerView rvProfile;
    private Menu menu;
    //private StudentAdapter studentAdapter;

    private ProfileAdapter profileAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        tvToolbarTitle.setText(getString(R.string.ToolbarTitle));
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.setVisibility(View.GONE);
                menu.getItem(0).setVisible(true);
                return true;
            }
        });
//        rvStudent.setLayoutManager(new LinearLayoutManager(this));
//        List<Student> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(new Student("name: " + i));
//        }
//        studentAdapter = new StudentAdapter(list);
//        rvStudent.setAdapter(studentAdapter);

        rvProfile.setLayoutManager(new LinearLayoutManager(this));
        List<Profile>listProfile=new ArrayList<>();
        for(int i=0;i<=112;i++){
            listProfile.add(new Profile("name: " + i,"ProfileURL : http://coditas.com/"+i,"Data one: "+i,"Data Two: "+i*i));
        }
        profileAdapter =new ProfileAdapter(listProfile);
        rvProfile.setAdapter(profileAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_button:
                searchView.setVisibility(View.VISIBLE);
                item.setVisible(false);
                return true;
        }
        return true;
    }
}
