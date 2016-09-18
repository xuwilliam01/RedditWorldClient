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
    public Bitmap[] playerSpritesRight = new Bitmap[5]; //stores the playerSprites
    public Bitmap[] playerSpritesLeft= new Bitmap[5];


    public int screenX, screenY; //width and height of the screen

    public Bitmap background, tree, rock, signpost;

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

        //load player sprites
        int scale=1;
        /*playerSpritesLeft[0]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_0),scale);
        playerSpritesLeft[1]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_1),scale);
        playerSpritesLeft[2]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_2),scale);
        playerSpritesLeft[3]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_3),scale);
        playerSpritesLeft[4]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_4),scale);

        playerSpritesRight[0]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_0),scale);
        playerSpritesRight[1]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_1),scale);
        playerSpritesRight[2]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_2),scale);
        playerSpritesRight[3]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_3),scale);
        playerSpritesRight[4]=ResizeBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_4),scale);*/

        playerSpritesLeft[0]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_0);
        playerSpritesLeft[1]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_1);
        playerSpritesLeft[2]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_2);
        playerSpritesLeft[3]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_3);
        playerSpritesLeft[4]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_4);

        playerSpritesRight[0]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_0);
        playerSpritesRight[1]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_1);
        playerSpritesRight[2]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_2);
        playerSpritesRight[3]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_3);
        playerSpritesRight[4]=BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_4);


        signpost= BitmapFactory.decodeResource(ctx.getResources(), R.drawable.signpostsmall);
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
