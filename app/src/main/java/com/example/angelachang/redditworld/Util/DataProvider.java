package com.example.angelachang.redditworld.Util;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by oscar on 9/17/16.
 */
public class DataProvider {

    private static DataProvider self = null;

    protected DataProvider(){

    }

    public static DataProvider getInstance(){
        if (self == null){
            self = new DataProvider();
        }
        return self;
    }





}
