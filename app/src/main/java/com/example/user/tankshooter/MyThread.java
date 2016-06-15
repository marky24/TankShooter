package com.example.user.tankshooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by user on 6/14/2016.
 */
public class MyThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private volatile boolean running = false;
    private int screenWidth;
    private int screenHeight;
    private Paint backgroundPaint;
    private Paint joystickPaint;

    private KillMe killMe;
    private Cursor cursor;

    public MyThread(SurfaceHolder surfaceHolder,
                    int screenWidth, int screenHeight) {
        this.surfaceHolder = surfaceHolder;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        GlobalWars.H=screenHeight;
        GlobalWars.W=screenWidth;

        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.WHITE);
        joystickPaint= new Paint();
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

        killMe = new KillMe(screenWidth);




        while (running)
        {
            try
            {
                canvas = surfaceHolder.lockCanvas();
                if (canvas != null)
                    synchronized (surfaceHolder) {
                        // рисовать на canvas
                        currentTime = System.currentTimeMillis() / 1000.0;
                        deltaT = currentTime - lastTime;
                        lastTime = currentTime;
                        updateAll(deltaT);
                        drawAll(canvas);
                    }
            }
            finally
            {
                if (canvas != null)
                    surfaceHolder.unlockCanvasAndPost(canvas);
                //add comment
            }
        }
    }

    private void updateAll(double deltaT)
    {
        killMe.update(deltaT);
    }

    private void drawAll(Canvas canvas)
    {
        canvas.drawRect(0, 0, screenWidth, screenHeight,
                backgroundPaint);
        killMe.draw(canvas);
        if (GlobalWars.A!=0) { cursor.draw(canvas);}
        canvas.drawCircle((1720/1920f)*GlobalWars.W,(870/1080f)*GlobalWars.H,(200f/1920)*GlobalWars.W, joystickPaint);
        canvas.drawCircle((1720/1920f)*GlobalWars.W,(870/1080f)*GlobalWars.H,(190f/1920)*GlobalWars.W, backgroundPaint);

    }

    public void touchAction(float x, float y) {
        //touchX = x;
        //touchY = y;
        killMe.setPos(x);
        GlobalWars.A=x;
        GlobalWars.B=y;
        if (GlobalWars.A!=0) {
            cursor = new Cursor(x,y);
        }





    }
}
