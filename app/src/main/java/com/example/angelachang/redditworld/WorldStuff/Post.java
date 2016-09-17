package com.example.angelachang.redditworld.WorldStuff;

/**
 * Created by angelachang on 9/17/16.
 */
public class Post {
    private int m_id;
    private int m_x;
    private int m_y;
    private String m_title;
    private String m_url;
    private int m_score;

    public String getTitle(){
        return m_title;
    }
    public String getUrl(){
        return m_url;
    }
    public int getScore(){
        return m_score;
    }
    private String m_image;

    public int getID(){
        return m_id;
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

    public void setID(int id){
        m_id = id;
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

    public Post(int id, int x, int y, String url, String title, int score){
        m_id = id;
        m_x = x;
        m_y = y;
        m_url = url;
        m_title = title;
        m_score = score;
    }
}
