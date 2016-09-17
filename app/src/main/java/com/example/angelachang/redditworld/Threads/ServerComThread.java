package com.example.angelachang.redditworld.Threads;

import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Util.ConfigVals;

import java.net.Socket;

/**
 * Created by oscar on 9/17/16.
 */
public class ServerComThread extends Thread{

    @Override
    public void run(){
        try{
            Socket sock = new Socket(ConfigVals.server_ip, ConfigVals.port);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
