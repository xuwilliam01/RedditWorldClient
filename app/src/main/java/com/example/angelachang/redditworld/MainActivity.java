package com.example.angelachang.redditworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.angelachang.redditworld.WorldStuff.WorldActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnterWorld(View v) {
        Intent intent = new Intent(this, WorldActivity.class);
        startActivity(intent);
    }
}
