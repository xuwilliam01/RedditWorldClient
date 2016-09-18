package com.example.angelachang.redditworld.Threads;

import com.example.angelachang.redditworld.Views.WorldView;
import com.example.angelachang.redditworld.WorldStuff.WorldActivity;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by oscar on 9/17/16.
 */
public class ServerOutThread extends Thread{
    PrintWriter fr;
    int oldx= -99999;
    int oldy= -99999;
    public ServerOutThread(PrintWriter d){
        fr = d;
    }

    public void run(){
        while(true){
            try {
                if (!(oldx == WorldThread.xPos && oldy == WorldThread.yPos)) {
                    fr.println("P " + WorldThread.xPos + " " + WorldThread.yPos + " " + WorldView.thread.getSpriteType() + " " + WorldView.thread.getSpriteNum());
                    fr.flush();
                    oldx = WorldThread.xPos;
                    oldy = WorldThread.yPos;
                }

                for(String s : WorldActivity.getEvent()){
                    fr.println(s);
                    System.out.println("LOLLOL"+ s);
                    fr.flush();
                }
                //System.
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
