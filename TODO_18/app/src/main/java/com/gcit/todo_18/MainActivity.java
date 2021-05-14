package com.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Sport> mSportData;
    private  SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recycleview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSportData = new ArrayList<>();

        mAdapter = new SportAdapter(this, mSportData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        TypedArray sportImageResource = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportList = getResources().getStringArray(R.array.sports_title);
        String[] sportInfo = getResources().getStringArray(R.array.sports_info);

        //clear the existing data(to avoid duplication)
        mSportData.clear();

        for(int i=0; i<sportList.length; i++){
            mSportData.add(new Sport(sportList[i],sportInfo[i], sportImageResource.getResourceId(i, 0)));

        }

        mAdapter.notifyDataSetChanged();
    }
}