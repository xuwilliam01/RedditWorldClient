package com.example.angelachang.redditworld.Util;

import com.example.angelachang.redditworld.WorldStuff.Coordinate;
import com.example.angelachang.redditworld.WorldStuff.Player;
import com.example.angelachang.redditworld.WorldStuff.Post;

import java.util.Arrays;

/**
 * Created by oscar on 9/17/16.
 */
public class SDataProvider implements DataProvider {
    public SDataProvider(){
    }

    @Override
    public synchronized Coordinate getPlayerLocation() {
        return null;
    }

    @Override
    public synchronized void addPlayer(Player p) {

        players[p.getID()] = p;

    }

    @Override
    public synchronized void addPost(Post p) {
        posts[p.getID()] = p;

    }

    @Override
    public synchronized Post[] getPosts() {
        Post[] re = new Post[posts.length];
        System.arraycopy(posts, 0, re, 0, posts.length);
        return re;

    }

    @Override
    public synchronized Player[] getPlayers() {
        Player[] re = new Player[players.length];
        System.arraycopy(posts, 0, re, 0, posts.length);
        return re;

    }

}
