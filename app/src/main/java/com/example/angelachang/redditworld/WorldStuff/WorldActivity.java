package com.example.angelachang.redditworld.WorldStuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Threads.WorldThread;
import com.example.angelachang.redditworld.Util.DataProvider;
import com.example.angelachang.redditworld.Views.WorldView;
public class WorldActivity extends AppCompatActivity {

    private static DataProvider dataProvider;

    int moveSpeed=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
    }

    public static DataProvider getDataProvider(){
        return dataProvider;
    }

    public void MoveUp(View v){

        //((WorldView) v).thread.backgroundY+=moveSpeed;
        WorldThread.backgroundY+=moveSpeed;
    }

    public void MoveDown(View v){
       // ((WorldView) v).thread.backgroundY-=moveSpeed;
        WorldThread.backgroundY-=moveSpeed;
    }

    public void MoveLeft(View v){
        //((WorldView) v).thread.backgroundX-=moveSpeed;
        WorldThread.backgroundX+=moveSpeed;
    }

    public void MoveRight(View v){
       // ((WorldView) v).thread.backgroundX+=moveSpeed;
        WorldThread.backgroundX-=moveSpeed;
    }




}


