package com.example.angelachang.redditworld.WorldStuff;

/**
 * Created by angelachang on 9/17/16.
 */
public class Post {
    private int m_id;
    private int m_x;
    private int m_y;
    private String m_URL;
    private String m_title;
    private int m_upvotes;
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

    public Post(int a, int x, int y, String url, String title, int upv){

        m_ID = a;
        m_x = x;
        m_y = y;
        m_URL = url;
        m_title = title;
        m_upvotes = upv;

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

    public String getURL(){
        return m_URL;
    }

    public String getTitle(){
        return m_title;
    }

    public int getUpvotes(){
        return m_upvotes;
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
}
