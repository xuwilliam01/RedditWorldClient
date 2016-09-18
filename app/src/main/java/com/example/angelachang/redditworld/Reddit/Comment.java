package com.example.angelachang.redditworld.Reddit;

/**
 * Created by angelachang on 9/17/16.
 */
public class Comment {
    private String m_comment;
    private String m_author;
    private int m_up;
    private int m_down;

    public int getUp(){
        return m_up;
    }
    public int getDown(){
        return m_down;
    }
    public String getComment(){
        return m_comment;
    }
    public String getAuthor(){
        return m_author;
    }
    public Comment(String comment, String author, int up, int down){
        m_comment = comment;
        m_author = author;
        m_up = up;
        m_down = down;
    }


}
