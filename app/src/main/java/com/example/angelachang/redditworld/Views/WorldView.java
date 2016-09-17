package com.example.angelachang.redditworld.Views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.example.angelachang.redditworld.Threads.WorldThread;

/**
 * Created by oscar on 9/17/16.
 */
public class WorldView  extends SurfaceView implements SurfaceHolder.Callback{

    WorldThread thread;

    public WorldView(Context context, AttributeSet attrib) {
        super(context, attrib);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        // create thread only; it's started in surfaceCreated()
        thread = new WorldThread(holder, context, new Handler() {
            @Override
            public void handleMessage(Message m) {

            }
        });
        setFocusable(true); // make sure we get key events
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        return thread.onTouchEvent(e);
    }
}
