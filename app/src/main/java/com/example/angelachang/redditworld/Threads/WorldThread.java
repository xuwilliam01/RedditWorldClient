package com.example.angelachang.redditworld.Threads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by oscar on 9/17/16.
 */
public class WorldThread extends Thread{

    private boolean running = true;

    private final Object mRunLock = new Object(); // dafuq

    private Paint painter;

    int x = 0;

    private SurfaceHolder mSurfaceHolder;

    public WorldThread(SurfaceHolder surfaceHolder, Context context,
                       Handler handler) {

        mSurfaceHolder = surfaceHolder;
        painter = new Paint();
        painter.setAntiAlias(true);
        painter.setARGB(255, 0, 255, 0);

    }

    public void run() {
        while (running) {
            Canvas c = null;
            try {
                c = mSurfaceHolder.lockCanvas(null);
                synchronized (mSurfaceHolder) {
                    //game logic all calculation and data pulling goes here

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
    }

    public boolean onTouchEvent(MotionEvent e){
        x = (int) e.getX() ;
        return true;
    }




}
