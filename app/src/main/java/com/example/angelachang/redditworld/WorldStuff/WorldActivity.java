package com.example.angelachang.redditworld.WorldStuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Threads.ServerComThread;
import com.example.angelachang.redditworld.Threads.WorldThread;
import com.example.angelachang.redditworld.Util.DataProvider;
import com.example.angelachang.redditworld.Util.SDataProvider;
import com.example.angelachang.redditworld.Views.WorldView;

import java.util.ArrayList;

public class WorldActivity extends AppCompatActivity {

    private static DataProvider dataProvider;
    public static WorldActivity rootview;

    private static ArrayList<String> eventList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        dataProvider = new SDataProvider();
        rootview=this;
        ServerComThread c = new ServerComThread();
        c.start();


    }

    public static synchronized void  addEvent(String s){
        eventList.add(s);

    }

    public static synchronized ArrayList<String> getEvent(){
        ArrayList<String> tmp = new ArrayList(eventList);
        eventList.clear();
        return tmp;
    }




    public static DataProvider getDataProvider(){
        return dataProvider;
    }

    public void SendMessage(View v){


        EditText t = (EditText)findViewById(R.id.chatbox);
        String message = t.getText().toString();
        if(!message.equals("chat")){
            addEvent(message);
            t.setText("chat");
        }

    }

    /*public void ClearChatBox(View v){
        EditText t = (EditText)findViewById(R.id.chatbox);
        if (t.getText().toString().equals("chat")) {
            t.setText("");
        }
    }
*/



}


