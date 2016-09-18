package com.example.angelachang.redditworld.WorldStuff;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

    public static WebView wv;

    private static ArrayList<String> eventList = new ArrayList<String>();

    private boolean hasWebView=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        dataProvider = new SDataProvider();
        rootview=this;
        ServerComThread c = new ServerComThread();
        c.start();
        loadWebView("title","http://s2.quickmeme.com/img/cf/cf70f99a696265c3e05e3ada4851eeef5481333fa3b1dbb2c96d5de225026cd7.jpg");

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
            addEvent("M " + message.replace(' ', '_'));

            ((WorldView) rootview.findViewById(R.id.view)).thread.playerMessage = message;

            t.setText("");
        }

    }

    public void ChangeSubreddit(View v){

        WorldActivity.getDataProvider().clear();
        EditText t = (EditText)findViewById(R.id.subreddit);
        String message = t.getText().toString();
        if(!message.equals("")){
            t.setText("");
        }
        WorldActivity.addEvent("S " + message.trim());

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
        if (hasWebView){
            return;
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(rootview, R.style.AlertDialogCustom);

        wv = new WebView(rootview);
        wv.loadUrl(url);
        wv.getSettings().setSupportZoom(true);
        wv.getSettings().setDisplayZoomControls(false);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }


        });
        alert.setView(wv);
        alert.show();

    }


}


