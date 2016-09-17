package com.example.angelachang.redditworld.WorldStuff;

import com.example.angelachang.redditworld.WorldStuff.Player;
import com.example.angelachang.redditworld.WorldStuff.Post;

import java.util.ArrayList;

/**
 * Created by angelachang on 9/17/16.
 */
public class GameWorld {

    // making GameWorld a singleton
    private static GameWorld instance = null;
    protected GameWorld() {
        // Exists only to defeat instantiation.
    }
    public static GameWorld getInstance() {
        if(instance == null) {
            instance = new GameWorld();
        }
        return instance;
    }

    private int m_playerID; // id of main player
    public ArrayList<Player> players = new ArrayList<Player>();
    public ArrayList<Post> posts = new ArrayList<Post>();

    public int getPlayerID(){
        return m_playerID;
    }
    public void setPlayerID(int playerID){
        m_playerID = playerID;
    }


}
