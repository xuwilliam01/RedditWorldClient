package com.example.angelachang.redditworld;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.DisplayMetrics;


/**
 * Created by TigerZhao on 16-09-17.
 */
public class ImageResources {
    Bitmap[] playerSprites = new Bitmap[4]; //stores the playerSprites
    int curPlayerSprite=0; //indicates the index of playerSprite

    public int screenX, screenY; //width and height of the screen

    public Bitmap background, tree, rock;

    /**
     * Load images here for use in world view.
     */
    public ImageResources(Context ctx) {
        DisplayMetrics dm = new DisplayMetrics();
        dm=ctx.getResources().getDisplayMetrics();
        screenY = Math.abs(dm.heightPixels);
        screenX = Math.abs(dm.widthPixels);



        //load the background:
        background = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.grass);
        //background=ResizeBitmap(background, 10);
    }


    public Bitmap ResizeBitmap(Bitmap bm, double scale){
       // bm = Bitmap.createScaledBitmap(bm, 0, 0,(int) scale*bm.getWidth(),(int)scale*bm.getHeight());
        bm=Bitmap.createScaledBitmap(bm, (int)scale*bm.getWidth(), (int)scale*bm.getHeight(),true);
        return bm;
    }

    public Bitmap ResizeBitmap(Bitmap bm, int newX, int newY){
        //bm = Bitmap.createBitmap(bm, 1, 1, newX,newY);
        bm = Bitmap.createScaledBitmap(bm, newX, newY,true);
        return bm;
    }

}
