package com.example.angelachang.redditworld.Threads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.example.angelachang.redditworld.ImageResources;

/**
 * Created by oscar on 9/17/16.
 */
public class WorldThread extends Thread{

    private boolean running = true;

    private final Object mRunLock = new Object(); // dafuq

    private Paint painter;

    int x = 0;

    public int xPos=0;
    public int yPos=0;
    public float vx = 0;
    public float vy = 0;

    private int prevX=0;
    private int prevY=0;

    int moveSpeed=10;
    public boolean mleft, mright,mup, mdown;

    private SurfaceHolder mSurfaceHolder;

    ImageResources resources;
    public WorldThread(SurfaceHolder surfaceHolder, Context context,
                       Handler handler) {

        mSurfaceHolder = surfaceHolder;
        painter = new Paint();
        painter.setAntiAlias(true);
        painter.setARGB(255, 0, 255, 0);
        resources = new ImageResources(context);
    }

    public void run() {
        while (running) {
            Canvas c = null;
            try {
                c = mSurfaceHolder.lockCanvas(null);
                synchronized (mSurfaceHolder) {
                    //game logic all calculation and data pulling goes here
                    gameLogic();

                    synchronized (mRunLock) { //dafuq does this do? mrunlock is just a generic new obj
                        if (running){
                            doDraw(c);
                            doScroll();
                        }
                    }
                }
            } finally {
                //cleaning up so as to not leaving hanging state
                if (c != null) {
                    mSurfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
}

    private void doDraw(Canvas canvas) {
        // Draw the background image. Operations on the Canvas accumulate
        // so this is like clearing the screen.
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(20,30,x++,50,painter);
       // System.out.println(backgroundX+" "+backgroundY);

        //draw the background!

        scrollBackground(canvas); //draws the background accordingly



        //canvas.drawBitmap(resources.background, xPos,yPos,painter);

        //System.out.println(prevX+" "+prevY+" "+xPos+" "+yPos);
        prevX=xPos;
        prevY=yPos;


    }


    public void scrollBackground(Canvas canvas) {
        int x;
        int y;

        int offX=xPos;
        int offY=yPos;
        Bitmap bg = resources.background;
        if (offX > 0) {
            for (x = offX; x > 0; x -= bg.getWidth()) ;
        }else {
            for (x = offX; x < 0; x += bg.getWidth()) ;
            x -= bg.getWidth();
        }
        if (offY > 0) {
            for (y = offY; y > 0; y -= bg.getHeight()) ;
        }else {
            for (y = offY; y < 0; y += bg.getHeight());
            y -= bg.getHeight();
        }

        for (int i = x; i < resources.screenX; i += bg.getWidth()) {
            for (int j = y; j < resources.screenY; j += bg.getHeight()) {

                canvas.drawBitmap(resources.background, i,j,painter);
            }
        }
    }
    private void gameLogic(){

    }

    private double sx= 0;
    private double sy = 0;

    public boolean onTouchEvent(MotionEvent e){

        if(e.getActionMasked() == MotionEvent.ACTION_DOWN){
            sx = e.getX();
            sy = e.getY();
        }
        double dx = (int)(e.getX()-sx);
        double dy = (int)(e.getY()-sy);
        vx = (int)( -0.05 * dx);
        vy =(int)( -0.05 * dy);
        if(Math.sqrt(Math.pow(vx,2) + Math.pow(vy,2))  > moveSpeed) {
            float factor = (float) (moveSpeed / Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
            vx = -factor * (float)dx;
            vy = -factor * (float)dy;
        }
        if(e.getActionMasked() == MotionEvent.ACTION_UP) {
            vx = 0;
            vy = 0;

        }

        return true;
    }

    public void doScroll(){
       /* if (mleft){
            xPos+=moveSpeed;
        }
        if (mright){
            xPos-=moveSpeed;
        }

        if (mup){
            yPos+=moveSpeed;
        }

        if(mdown){
            yPos-=moveSpeed;
        }*/
        xPos += vx;
        yPos += vy;

    }



}
