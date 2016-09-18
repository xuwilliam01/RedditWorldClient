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

    public Bitmap[] psr0 = new Bitmap[5]; //stores the playerSprites
    public Bitmap[] psl0= new Bitmap[5];

    public Bitmap[] psr1 = new Bitmap[5]; //stores the playerSprites
    public Bitmap[] psl1= new Bitmap[5];

    public Bitmap[] psr2 = new Bitmap[5]; //stores the playerSprites
    public Bitmap[] psl2= new Bitmap[5];

    public Bitmap[] psr3 = new Bitmap[5]; //stores the playerSprites
    public Bitmap[] psl3= new Bitmap[5];

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


        int rnd = (int)(Math.random() * 4);
        System.out.println(rnd);
        if(rnd == 0) {
            playerSpritesLeft[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_0);
            playerSpritesLeft[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_1);
            playerSpritesLeft[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_2);
            playerSpritesLeft[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_3);
            playerSpritesLeft[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_4);

            playerSpritesRight[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_0);
            playerSpritesRight[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_1);
            playerSpritesRight[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_2);
            playerSpritesRight[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_3);
            playerSpritesRight[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_4);
        }
        else if(rnd == 1){
            playerSpritesLeft[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_0);
            playerSpritesLeft[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_1);
            playerSpritesLeft[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_2);
            playerSpritesLeft[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_3);
            playerSpritesLeft[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_4);

            playerSpritesRight[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_0);
            playerSpritesRight[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_1);
            playerSpritesRight[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_2);
            playerSpritesRight[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_3);
            playerSpritesRight[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_4);
        }
        else if(rnd == 2){
            playerSpritesLeft[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_0);
            playerSpritesLeft[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_1);
            playerSpritesLeft[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_2);
            playerSpritesLeft[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_3);
            playerSpritesLeft[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_4);

            playerSpritesRight[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_0);
            playerSpritesRight[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_1);
            playerSpritesRight[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_2);
            playerSpritesRight[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_3);
            playerSpritesRight[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_4);
        }
        else {
            playerSpritesLeft[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_0);
            playerSpritesLeft[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_1);
            playerSpritesLeft[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_2);
            playerSpritesLeft[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_3);
            playerSpritesLeft[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_4);

            playerSpritesRight[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_0);
            playerSpritesRight[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_1);
            playerSpritesRight[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_2);
            playerSpritesRight[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_3);
            playerSpritesRight[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_4);
        }



        //other
        psl0[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_0);
        psl0[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_1);
        psl0[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_2);
        psl0[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_3);
        psl0[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_0_4);

        psr0[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_0);
        psr0[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_1);
        psr0[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_2);
        psr0[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_3);
        psr0[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_0_4);


        psl1[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_0);
        psl1[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_1);
        psl1[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_2);
        psl1[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_3);
        psl1[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_1_4);

        psr1[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_0);
        psr1[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_1);
        psr1[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_2);
        psr1[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_3);
        psr1[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_1_4);

        psl2[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_0);
        psl2[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_1);
        psl2[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_2);
        psl2[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_3);
        psl2[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_2_4);

        psr2[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_0);
        psr2[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_1);
        psr2[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_2);
        psr2[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_3);
        psr2[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_2_4);

        psl3[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_0);
        psl3[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_1);
        psl3[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_2);
        psl3[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_3);
        psl3[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.left_3_4);

        psr3[0] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_0);
        psr3[1] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_1);
        psr3[2] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_2);
        psr3[3] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_3);
        psr3[4] = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.right_3_3);



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
