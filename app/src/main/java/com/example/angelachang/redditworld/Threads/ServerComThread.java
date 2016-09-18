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

            //new ServerOutThread(r).start();

            while(is.ready()){
                String d = is.readLine();
                String[] b = d.split(" ");
                if(b[0].equals("P")){
                    WorldActivity.getDataProvider().addPlayer(new Player(Integer.parseInt(b[1]), Integer.parseInt(b[2]),Integer.parseInt(b[3]),Integer.parseInt(b[4]),b[5], b[6]));
                }
                else if(b[0].equals("S")){
                    WorldActivity.getDataProvider().addPost(new Post(Integer.parseInt(b[1]), Integer.parseInt(b[2]),Integer.parseInt(b[3]),b[4],b[5],Integer.parseInt(b[6])));
                }
            }


           // System.out.println("CONNECTIONSUCCESSFULZ");


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
