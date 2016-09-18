package com.example.angelachang.redditworld.WorldStuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by TigerZhao on 16-09-17.
 */
public class Player {

    private int m_ID;
    private int m_x;
    private int m_y;
    private int m_image;
    private String m_subreddit;
    private String m_message;

    public Player(int a, int x, int y, int z, String d, String mes){

        m_ID = a;
        m_x = x;
        m_y = y;
        m_image = z;
        m_subreddit = d;
        m_message = mes;


    }

    public int getID(){
        return m_ID;
    }

    public int getX(){
        return m_x;
    }

    public int getY(){
        return m_y;
    }

    public int getImage(){
        return m_image;
    }

    public String getSubreddit(){
        return m_subreddit;
    }

    public String getMessage(){
        return m_message;
    }

    public void setID(int ID){
        m_ID = ID;
    }

    public void setX(int x){
        m_x=x;
    }

    public void setY(int y){
        m_y=y;
    }

    public void setImage(int image){
        m_image = image;
    }

    public void setSubreddit(String subreddit){
        m_subreddit = subreddit;
    }

    public void setMessage(String a){
        m_message = a;
    }
}
