package com.example.user.tankshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 6/14/2016.
 */
public class MyThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private volatile boolean running = false;
    private int screenWidth;
    private int screenHeight;
    public int b=0;
    private Paint backgroundPaint;
    private Paint joystickPaint;
    Map<String, Bitmap> images = new HashMap<String, Bitmap>();

    /*    private KillMe killMe;*/
    private Cursor cursor;
    private Cursor2 cursor2;
    private Player player;
    private Bashnya bashnya;
    private Field field;
    private Context context;
    public MyThread(Context context, SurfaceHolder surfaceHolder,
                    int screenWidth, int screenHeight) {
        this.context = context;
        this.surfaceHolder = surfaceHolder;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        GlobalWars.H = screenHeight;
        GlobalWars.W = screenWidth;

        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.WHITE);
        joystickPaint = new Paint();
        joystickPaint.setColor(Color.GRAY);
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        Canvas canvas = null;
        double lastTime = System.currentTimeMillis() / 1000.0;
        double currentTime;
        double deltaT;


        images.put("pl", BitmapFactory.decodeResource(context.getResources(), R.drawable.pl));
        images.put("bash", BitmapFactory.decodeResource(context.getResources(), R.drawable.bash));
    /*    killMe = new KillMe(screenWidth);*/
        cursor = new Cursor((1720 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H);
        cursor2 = new Cursor2((200 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H);
        Bitmap bm = images.get("pl");
        player=new Player(GlobalWars.W/2,GlobalWars.H/2,0,0,bm);
        Bitmap bm1 = images.get("bash");
        bashnya=new Bashnya(GlobalWars.W/2,GlobalWars.H/2,bm1);

        field = new Field();


        while (running) {
            try {
                canvas = surfaceHolder.lockCanvas();
                if (canvas != null)
                    synchronized (surfaceHolder) {
                        // рисовать на canvas
                        currentTime = System.currentTimeMillis() / 1000.0;
                        deltaT = currentTime - lastTime;
                        GlobalWars.T=deltaT;
                        lastTime = currentTime;
                        updateAll(deltaT);
                        drawAll(canvas);
                    }
            } finally {
                if (canvas != null)
                    surfaceHolder.unlockCanvasAndPost(canvas);
                //add comment
            }
        }
    }

    private void updateAll(double deltaT) {
        /*killMe.update(deltaT);*/
        if  (Player.IsM0ving==false) {player.update(GlobalWars.A,GlobalWars.B);}
    }

    private void drawAll(Canvas canvas) {
        canvas.drawRect(0, 0, screenWidth, screenHeight,
                backgroundPaint);
        canvas.drawCircle((1720 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H, (200f / 1920) * GlobalWars.W, joystickPaint);
        canvas.drawCircle((1720 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H, (190f / 1920) * GlobalWars.W, backgroundPaint);
        canvas.drawCircle((200 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H, (200f / 1920) * GlobalWars.W, joystickPaint);
        canvas.drawCircle((200 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H, (190f / 1920) * GlobalWars.W, backgroundPaint);
       /* killMe.draw(canvas);*/

            cursor.draw(canvas);
            cursor2.draw(canvas);
            player.draw(canvas);
            field.draw(canvas);
        bashnya.draw(canvas);



    }

    public void touchAction(int action, float x, float y) {
        //touchX = x;
        //touchY = y;
        /*killMe.setPos(x);*/




        switch (action) {
            case MotionEvent.ACTION_MOVE:

                if (x>GlobalWars.W/2) {
                    if (Math.sqrt(((x - (1720 / 1920f) * GlobalWars.W) * (x - (1720 / 1920f) * GlobalWars.W)) + (((870 / 1080f) * GlobalWars.H - y) * ((870 / 1080f) * GlobalWars.H - y))) <= (200f / 1920) * GlobalWars.W) {
                        cursor.SetPosition(x, y);
                    }
                }
                if (x<=GlobalWars.W/2){
                    if (Math.sqrt(((x-(200 / 1920f) * GlobalWars.W) * (x-(200 / 1920f) * GlobalWars.W)) + (((870 / 1080f) * GlobalWars.H - y) * ((870 / 1080f) * GlobalWars.H - y))) <= (200f / 1920) * GlobalWars.W) {
                                                  cursor2.SetPosition(x, y);
                                              }
                                          }
                 player.update(x,y);
            Player.IsM0ving=false;
                GlobalWars.A=x;
                GlobalWars.B=y;
                break;
            case MotionEvent.ACTION_UP:

               Player.IsM0ving=true;
                   cursor.SetPosition((1720 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H);
                    cursor2.SetPosition((200 / 1920f) * GlobalWars.W, (870 / 1080f) * GlobalWars.H);
        }
    }


}
