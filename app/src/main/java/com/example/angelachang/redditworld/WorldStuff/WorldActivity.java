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
        SetListeners();

    }

    public void SetListeners(){

        Button upButton = (Button)findViewById(R.id.upbutton);
        Button downButton = (Button)findViewById(R.id.downbutton);
        Button leftbutton = (Button)findViewById(R.id.leftbutton);
        Button rightbutton = (Button)findViewById(R.id.rightbutton);

        upButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mup=true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mup=false;
                }
                return true;
            }
        });

        downButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mdown=true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mdown=false;
                }
                return true;
            }
        });

        leftbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mleft=true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mleft=false;
                }
                return true;
            }
        });

        rightbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mright=true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ((WorldView) WorldActivity.rootview.findViewById(R.id.view)).thread.mright=false;
                }
                return true;
            }
        });
    }

    public static DataProvider getDataProvider(){
        return dataProvider;
    }





}


