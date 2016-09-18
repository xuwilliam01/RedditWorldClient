package com.example.angelachang.redditworld.WorldStuff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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

            ((WorldView) rootview.findViewById(R.id.view)).thread.playerMessage = message;

            t.setText("chat");
        }

    }

    public void ScreenPressed(View v){

    }

    /*public void ClearChatBox(View v){
        EditText t = (EditText)findViewById(R.id.chatbox);
        if (t.getText().toString().equals("chat")) {
            t.setText("");
        }
    }
*/

    public void loadWebView(String title, String url){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title);

        WebView wv = new WebView(this);
        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

        alert.setView(wv);
        alert.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.show();

    }


}


