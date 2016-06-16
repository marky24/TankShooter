package com.example.user.tankshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by user on 6/15/2016.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by user on 6/15/2016.
 */
public class Player {
    float x0;
    float y0;
    float a=0;
    float b=0;
    RectF body;
    double speedX;
    double speedY;
    private Paint paint;
    private Bitmap pl;
    float x=GlobalWars.W/2;
    float y=GlobalWars.H/2;

    private float r=GlobalWars.W/10;
    private float r1=GlobalWars.W/15;

    public Player(float x0, float y0, float speedX, float speedY, Bitmap image) {
        this.speedX = speedX;
        this.speedY = speedY;
        this.x0=x0;
        this.y0=0;

        paint = new Paint();
        paint.setColor(Color.BLUE);
        pl = image;
        body = new RectF(x0-r,  (y0-r1), x0+r,  (y0 +r1));
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(pl, null, body, paint);
    }
   /* public void update (float x2,float y2) {



        if (x2>(1720 / 1920f) * GlobalWars.W && y2<(870 / 1080f) * GlobalWars.H ) {
            speedX=(Math.sqrt((x2 - (1720 / 1920f) * GlobalWars.W) * (x2 - (1720 / 1920f) * GlobalWars.W)));
            speedY=(Math.sqrt(((870 / 1080f) * GlobalWars.H - y2) * ((870 / 1080f) * GlobalWars.H - y2)));
            Log.e("Player", "speedX=" + speedX);
            x0 = (float)(x + speedX * GlobalWars.T);
            y0 = (float)(y - speedY * GlobalWars.T);
            x=x0;
            y=y0;
            Log.e("Player", "x=" + x);
            body = new RectF(x0-r,  (y0-r1), x0+r,  (y0 +r1));
            a=x2;
            b=y2;
        }


    }*/


}