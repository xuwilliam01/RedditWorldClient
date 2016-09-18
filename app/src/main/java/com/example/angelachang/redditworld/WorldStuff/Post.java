package com.example.angelachang.redditworld.WorldStuff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.angelachang.redditworld.R;

/**
 * Created by angelachang on 9/17/16.
 */
public class Post {
    private int m_id;
    private int m_x; //relative to 0,0
    private int m_y; //relative to 0,0
    private String m_title;
    private String m_url;
    private int m_score;

    private Bitmap m_image;
    ;

    public String getTitle(){
        return m_title;
    }
    public String getUrl(){
        return m_url;
    }
    public int getScore(){
        return m_score;
    }


    public int getID(){
        return m_id;
    }

    public int getX(){
        return m_x;
    }

    public int getY(){
        return m_y;
    }

    public Bitmap getImage(){
        return m_image;
    }

    public void setID(int id){
        m_id = id;
    }

    public void setX(int x){
        m_x=x;
    }

    public void setY(int y){
        m_y=y;
    }

    public void setImage(Bitmap image){
        m_image = image;
    }

    public Post(int id, int x, int y, String url, String title, int score){
        m_id = id;
        m_x = x;
        m_y = y;
        m_url = url;
        m_title = title;
        m_score = score;
    }


    public void Display(Canvas canvas, Paint painter, int offsetX, int offsetY, int screenX, int screenY,Bitmap image){ //draws the post
        int x = offsetX -m_x+ (screenX/2);
        int y = offsetY-m_y + (screenY/2);

        canvas.drawBitmap(image, x,y,painter);
        painter.setTextSize(50);

        painter.setColor(Color.BLACK);


        //format the string to fit

        canvas.drawText(m_score +": "+m_title, x+20, y+125, painter);
    }

    public void Open(){ //opens the whole post for viewing


    }
}
