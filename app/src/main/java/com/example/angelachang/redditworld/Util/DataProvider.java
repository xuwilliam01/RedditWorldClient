package com.example.angelachang.redditworld.Util;

import android.database.sqlite.SQLiteDatabase;

import com.example.angelachang.redditworld.WorldStuff.Coordinate;
import com.example.angelachang.redditworld.WorldStuff.Player;

import java.util.ArrayList;

/**
 * Created by oscar on 9/17/16.
 */
public interface DataProvider {

    public Coordinate getPlayerLocation();
    public ArrayList<Player> getPlayers();

}
