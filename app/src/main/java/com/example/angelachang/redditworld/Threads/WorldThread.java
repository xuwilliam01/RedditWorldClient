package com.example.angelachang.redditworld.Threads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.example.angelachang.redditworld.ImageResources;
import com.example.angelachang.redditworld.R;
import com.example.angelachang.redditworld.Views.WorldView;
import com.example.angelachang.redditworld.WorldStuff.Player;
import com.example.angelachang.redditworld.WorldStuff.Post;
import com.example.angelachang.redditworld.WorldStuff.WorldActivity;

import java.util.ArrayList;

/**
 * Created by oscar on 9/17/16.
 */
public class WorldThread extends Thread{

    private boolean running = true;

    private final Object mRunLock = new Object(); // dafuq

    private Paint painter;
    private Paint painter2;

    int x = 0;

    public static int xPos=32000;
    public static int yPos=32000;
    public float vx = 0;
    public float vy = 0;

    private int prevX=32000;
    private int prevY=32000;

    private long prevTime=0;
    String dir="left";//direction of player
    int curPlayerSprite=0; //indicates the index of playerSprite

    int moveSpeed=10;
    public boolean mleft, mright,mup, mdown;

    private SurfaceHolder mSurfaceHolder;

    private double prevDeltaTime=0;
    private double deltaTime=0;//time elapsed between frames

    ArrayList<Post> postList = new ArrayList<Post>();

    ArrayList<Player> playerList = new ArrayList<Player>();


    public String playerMessage ="";
    double messageTimeStart;
    double messageTimeElapsed;
    boolean displayMessage=false;

    ImageResources resources;
    public WorldThread(SurfaceHolder surfaceHolder, Context context, Handler handler) {
        mSurfaceHolder = surfaceHolder;
        painter = new Paint();
        painter.setAntiAlias(true);
        painter.setARGB(255, 0, 255, 0);
        painter2 = new Paint();
        painter2.setAntiAlias(true);
        painter2.setStrokeWidth(5);
        painter2.setARGB(255, 255, 255, 0);
        resources = new ImageResources(context);

        painter.setTypeface(Typeface.create("monospace",Typeface.BOLD));

        //test

        /*Post p = new Post(10,32200,32200,"test","This is a reddit post! This is a reddit post! This is a reddit post! This is a reddit post! This is a reddit post!",420);
        postList.add(p);

        Player pp = new Player(1,32400,32400,9);
        playerList.add(pp);*/

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
                            if (prevDeltaTime==0){//initialize
                                prevDeltaTime= System.currentTimeMillis();
                            }
                            deltaTime=System.currentTimeMillis()-prevDeltaTime;
                            prevDeltaTime = System.currentTimeMillis();
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



        displayPosts(canvas);
        displayPlayers(canvas);


        animatePlayer(canvas);

        if(sx != -1){
            canvas.drawCircle((float)sx,(float)sy,10,painter2);
            canvas.drawLine((float)sx,(float)sy,(float)sx-vx*20,(float)sy-vy*20,painter2);
        }
        //canvas.drawBitmap(resources.background, xPos,yPos,painter);


        prevX=xPos;
        prevY=yPos;


    }
    public void displayPosts(Canvas canvas){
        Post[] d = WorldActivity.getDataProvider().getPosts();
        //System.out.println("asdasd" + d.length);
        for (Post p : d){
            if(p != null){
                //System.out.println("sign created");
                p.Display(canvas,painter,xPos,yPos,resources.screenX, resources.screenY,resources.signpost);
            }
           // System.out.println("DEBUG");
            //p.Display(canvas,painter,xPos,yPos,resources.screenX, resources.screenY,resources.signpost);
        }

        tapx = -1;
        tapy = -1;
    }

    public void displayPlayers(Canvas canvas){
        for (Player p : WorldActivity.getDataProvider().getPlayers()){
            if(p == null)continue;
            if(p.getID() == WorldActivity.getDataProvider().getMyID())continue;
            //System.out.println("DRAWING PLAYERSSS");
            int i=p.getFrame();
            int type = p.getImage();
            if (type==0){
                if (i <5) {
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psl0[i]);
                }else{
                    i-=5;
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psr0[i]);
                }
            }else if(type==1){
                if (i <5) {
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psl1[i]);
                }else{
                    i-=5;
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psr1[i]);
                }
            }else if(type ==2){
                if (i <5) {
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psl2[i]);
                }else{
                    i-=5;
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psr2[i]);
                }
            }else{
                if (i <5) {
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psl3[i]);
                }else{
                    i-=5;
                    p.Display(canvas, painter, xPos, yPos, resources.screenX, resources.screenY, resources.psr3[i]);
                }
            }
        }
    }

    public int getSpriteNum(){
        if (dir.equals("left")){
            return curPlayerSprite;
        }else{//right
            return curPlayerSprite+5;
        }

    }

    public int getSpriteType(){
        return 0;
    }
    public void animatePlayer(Canvas canvas){


        long t = System.currentTimeMillis();
        if (t-prevTime>= 75){
            prevTime=t;
            curPlayerSprite+=1;
        }


        if (curPlayerSprite>4){
            curPlayerSprite=0;
        }

        if (xPos-prevX >0){//moving left
            dir="left";
            canvas.drawBitmap(resources.playerSpritesLeft[curPlayerSprite], resources.screenX/2 - resources.playerSpritesLeft[curPlayerSprite].getWidth()/2,resources.screenY/2- resources.playerSpritesLeft[curPlayerSprite].getHeight()/2,painter);

        }else if (xPos-prevX<0){//moving right
            dir="right";
            canvas.drawBitmap(resources.playerSpritesRight[curPlayerSprite], resources.screenX/2 - resources.playerSpritesRight[curPlayerSprite].getWidth()/2,resources.screenY/2- resources.playerSpritesRight[curPlayerSprite].getHeight()/2,painter);
        }else if(xPos-prevX==0 && yPos-prevY==0){ //still
            if (dir.equals("right")){
                canvas.drawBitmap(resources.playerSpritesRight[0], resources.screenX/2 - resources.playerSpritesRight[0].getWidth()/2,resources.screenY/2- resources.playerSpritesRight[0].getHeight()/2,painter);
            }else{
                canvas.drawBitmap(resources.playerSpritesLeft[0], resources.screenX/2 - resources.playerSpritesLeft[0].getWidth()/2,resources.screenY/2- resources.playerSpritesLeft[0].getHeight()/2,painter);
            }
        }else{//moving directly up or down
            if (dir.equals("right")){
                canvas.drawBitmap(resources.playerSpritesRight[curPlayerSprite], resources.screenX/2 - resources.playerSpritesRight[curPlayerSprite].getWidth()/2,resources.screenY/2- resources.playerSpritesRight[curPlayerSprite].getHeight()/2,painter);
            }else{
                canvas.drawBitmap(resources.playerSpritesLeft[curPlayerSprite], resources.screenX/2 - resources.playerSpritesLeft[curPlayerSprite].getWidth()/2,resources.screenY/2- resources.playerSpritesLeft[curPlayerSprite].getHeight()/2,painter);
            }
        }
        System.out.println(playerMessage);
        if (!playerMessage.equals("") && !displayMessage){
            displayMessage=true;
            messageTimeStart=System.currentTimeMillis();
            messageTimeElapsed = 3000 + 250 * playerMessage.length();
        }

        if(displayMessage){
            painter.setColor(Color.WHITE);
            painter.setTextSize(50);
            Rect r= new Rect();
            painter.getTextBounds(playerMessage,0,playerMessage.length(),r);
            canvas.drawText(playerMessage,resources.screenX/2 - r.width()/2,resources.screenY/2-200,painter);
        }

        if (displayMessage && System.currentTimeMillis()-messageTimeStart > messageTimeElapsed){
            messageTimeElapsed=0;
            messageTimeStart=0;
            displayMessage=false;
            playerMessage ="";
        }


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
        Bitmap player = resources.playerSpritesLeft[curPlayerSprite];
        Bitmap signpost = resources.signpost;
        Post collision = null;
        for (Post p : WorldActivity.getDataProvider().getPosts()){
            if(p == null)continue;
            if(xPos <= p.getX() + signpost.getWidth() &&
                    xPos + player.getWidth() >= p.getX() &&
                    yPos <= p.getY() + signpost.getHeight() &&
                    yPos + player.getHeight() >= p.getY())
                collision = p;
        }
        if (collision != null){
            //collision.Open();

        }

    }

    public double sx= 0;
    public double tapx = -1;
    public double tapy = -1;
    public double sy = 0;
    public long ts = System.currentTimeMillis();
    public boolean onTouchEvent(MotionEvent e){

        if(e.getActionMasked() == MotionEvent.ACTION_DOWN){
            sx = e.getX();
            sy = e.getY();
            ts = System.currentTimeMillis();
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
            sx = -1;
            sy = -1;
            if(System.currentTimeMillis()-ts < 350){

                tapx = e.getX();
                tapy = e.getY();

            }
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
        xPos += vx*(deltaTime/25f);
        yPos += vy*(deltaTime/25f);

    }




}
