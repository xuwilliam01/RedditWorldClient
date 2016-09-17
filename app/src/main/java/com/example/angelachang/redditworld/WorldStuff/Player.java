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
    private String m_image;

    public int getID(){
        return m_ID;
    }

    public int getX(){
        return m_x;
    }

    public int getY(){
        return m_y;
    }

    public String getImage(){
        return m_image;
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

    public void setImage(String image){
        m_image = image;
    }
}
