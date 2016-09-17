package com.example.angelachang.redditworld.Threads;

import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Util.ConfigVals;
import com.example.angelachang.redditworld.WorldStuff.GameWorld;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by oscar on 9/17/16.
 */
public class ServerComThread extends Thread{

    GameWorld gameWorld = GameWorld.getInstance();
    @Override
    public void run(){
        //System.out.println("STARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTIONSTARTING CONNECTION");
        try{
            Socket sock = new Socket(ConfigVals.server_ip, ConfigVals.port);

            InputStream is = sock.getInputStream();
            PrintWriter r = new PrintWriter( sock.getOutputStream());
            r.write("P 20 40");
            r.flush();
           // System.out.println("CONNECTIONSUCCESSFULZ");


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
