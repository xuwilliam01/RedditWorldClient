package com.example.angelachang.redditworld.WorldStuff;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by TigerZhao on 16-09-17.
 */
public class Player {

    private int m_ID;
    private int m_x;
    private int m_y;
    private int m_frame;
    private String m_subreddit;
    private String m_message;
    private int m_image;

    public int getM_image() {
        return m_image;
    }

    public void setM_image(int m_image) {
        this.m_image = m_image;
    }

    public Player(int a, int x, int y, int z, int mg,String d, String mes){

        m_ID = a;
        m_x = x;
        m_y = y;
        m_frame = z;
        m_subreddit = d;
        m_message = mes;
        m_image = mg;

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
        return m_frame;
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
        m_frame = image;
    }

    public void setSubreddit(String subreddit){
        m_subreddit = subreddit;
    }

    public void setMessage(String a){
        m_message = a;
    }


    public Player(int id, int x, int y, int image){
        m_ID = id;
        m_x = x;
        m_y = y;
        m_frame = image;
    }



    public void Display(Canvas canvas, Paint painter, int offsetX, int offsetY, int screenX, int screenY, Bitmap image){ //draws the post
        int x = offsetX -m_x+ (screenX/2);
        int y = offsetY-m_y + (screenY/2);

        canvas.drawBitmap(image, x,y,painter);
        painter.setTextSize(50);

        painter.setColor(Color.BLACK);

        if (m_message !="μ" && m_message !=null){
            Rect r= new Rect();
            painter.getTextBounds(m_message,0,m_message.length(),r);
            canvas.drawText(m_message,x+image.getWidth()/2 - r.width()/2,y-50,painter);

        }



    }
}
