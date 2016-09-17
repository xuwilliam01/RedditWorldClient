package com.example.angelachang.redditworld.Threads;

import android.content.Context;
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

    public int backgroundX=0;
    public int backgroundY=0;

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
                        if (running) doDraw(c);
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
        canvas.drawBitmap(resources.background, backgroundX,backgroundY,painter);


    }

    private void gameLogic(){

    }

    public boolean onTouchEvent(MotionEvent e){
        x = (int) e.getX() ;
        return true;
    }




}
