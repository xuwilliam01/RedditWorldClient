package com.example.angelachang.redditworld.WorldStuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Threads.WorldThread;
import com.example.angelachang.redditworld.Util.DataProvider;
import com.example.angelachang.redditworld.Views.WorldView;
public class WorldActivity extends AppCompatActivity {

    private static DataProvider dataProvider;
    public static WorldActivity rootview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        rootview=this;
    }

    public static DataProvider getDataProvider(){
        return dataProvider;
    }





}


