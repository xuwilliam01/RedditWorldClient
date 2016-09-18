package com.example.angelachang.redditworld.Threads;

import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Util.ConfigVals;
import com.example.angelachang.redditworld.WorldStuff.GameWorld;
import com.example.angelachang.redditworld.WorldStuff.Player;
import com.example.angelachang.redditworld.WorldStuff.Post;
import com.example.angelachang.redditworld.WorldStuff.WorldActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by oscar on 9/17/16.
 */
public class ServerComThread extends Thread{

    @Override
    public void run(){
        //System.out.println("STARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTION");
        try{

            //System.out.println("TESADASDAS");
            Socket sock = new Socket(ConfigVals.server_ip, ConfigVals.port);

            BufferedReader is = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter r = new PrintWriter( sock.getOutputStream());

            new ServerOutThread(r).start();

            while(true){
                String d = is.readLine();

                int currentToken = 0;
                System.out.println("FAGET"+ d);
                String[] b = d.split(" ");
                for(; currentToken < b.length; ) {
                    if (b[currentToken].equals("P")) {
                        System.out.println(d);
                        currentToken++;
                        WorldActivity.getDataProvider().addPlayer(new Player(Integer.parseInt(b[currentToken++]), Integer.parseInt(b[currentToken++]), Integer.parseInt(b[currentToken++]), Integer.parseInt(b[currentToken++]),Integer.parseInt(b[currentToken++]), b[currentToken++], b[currentToken++]));
                    } else if (b[currentToken].equals("S")) {
                        currentToken++;
                        WorldActivity.getDataProvider().addPost(new Post(Integer.parseInt(b[currentToken++]), Integer.parseInt(b[currentToken++]), Integer.parseInt(b[currentToken++]), b[currentToken++], b[currentToken++].replaceAll("_", " "), Integer.parseInt(b[currentToken++])));
                    } else if (b[currentToken].equals("T")) {
                        currentToken++;
                        WorldThread.xPos = Integer.parseInt(b[currentToken++]);
                        WorldThread.yPos = Integer.parseInt(b[currentToken++]);
                    } else if(b[currentToken].equals("Y")){
                        currentToken++;
                        WorldActivity.getDataProvider().setID(Integer.parseInt(b[currentToken++]));
                    }
                    //System.out.println("Current" + currentToken);
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
