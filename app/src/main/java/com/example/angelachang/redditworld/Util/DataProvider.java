package com.example.angelachang.redditworld.Util;

import android.database.sqlite.SQLiteDatabase;

import com.example.angelachang.redditworld.WorldStuff.Coordinate;
import com.example.angelachang.redditworld.WorldStuff.Player;
import com.example.angelachang.redditworld.WorldStuff.Post;

import java.util.ArrayList;

/**
 * Created by oscar on 9/17/16.
 */
public interface DataProvider {

    public Player[] players = new Player[100000];
    public Post[] posts = new Post[100000];

    public void addPlayer(Player p);
    public Coordinate getPlayerLocation();

    public void addPost(Post p);
    public Post[] getPosts();
    public Player[] getPlayers();

    public int getMyID();
    public void setID(int i);



}
