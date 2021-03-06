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

    RectF body;
    double speedX;
    double speedY;
    private Paint paint;
    private Bitmap pl;
    Cursor c;
    public static float x=GlobalWars.W/2;
    public static float y=GlobalWars.H/2;
    public static boolean IsM0ving=true;

    private float r=GlobalWars.W/10;
    private float r1=GlobalWars.W/15;

    public Player(float x0, float y0, float speedX, float speedY, Bitmap image, Cursor cursor) {
        this.speedX = speedX;
        this.speedY = speedY;
        this.x0=x0;
        this.y0=y0;
        c = cursor;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        pl = image;
        body = new RectF(this.x0-r,  (this.y0-r1), this.x0+r,  (this.y0 +r1));
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(pl, null, body, paint);
    }


    public void update (float x2,float y2) {
        if (x> GlobalWars.W){
            x = 0;
        }
        if (x < 0){
            x = GlobalWars.W;
        }
        if(y<0){
            y = GlobalWars.H;
        }
        if (y>GlobalWars.H){
            y = 0;
        }
        speedX=(Math.sqrt((x2 - (1720 / 1920f) * GlobalWars.W) * (x2 - (1720 / 1920f) * GlobalWars.W)));
        speedY=(Math.sqrt(((870 / 1080f) * GlobalWars.H - y2) * ((870 / 1080f) * GlobalWars.H - y2)));

       /*if ((x+r-125/1920f*GlobalWars.W>=1/4f*GlobalWars.W) & (x-r+96/1920f*GlobalWars.W<=1/4f*GlobalWars.W+1/32f*GlobalWars.W) &
                (y+r1>=8/18f*GlobalWars.H) & (y-r1<=8/18f*GlobalWars.H+5/18f*GlobalWars.H)) {
            speedX = 0;
        }*/

        if ((x+r1>=14/32f*GlobalWars.W) & (x-r1<=14/32f*GlobalWars.W+5/32f*GlobalWars.W) & (y+r-96/1080f*GlobalWars.H>=4/18f*GlobalWars.H) & (y-r+90/1080f*GlobalWars.H<=4/18f*GlobalWars.H+1/18f*GlobalWars.H)) {
            speedY=0;

        }
        if ((x+r1>=18/32f*GlobalWars.W) & (x-r1<=18/32f*GlobalWars.W+5/32f*GlobalWars.W) & (y+r-96/1080f*GlobalWars.H>=13/18f*GlobalWars.H) & (y-r+90/1080f*GlobalWars.H<=13/18f*GlobalWars.H+1/18f*GlobalWars.H)) {
            speedY=0;
        }

        if (((x2>(1720 / 1920f) * GlobalWars.W && y2<(870 / 1080f) * GlobalWars.H  ))) {

            Log.e("Player", "speedX=" + speedX);

            x0 = (float)(x + speedX * GlobalWars.T);
            y0 = (float)(y - speedY * GlobalWars.T);
            x=x0;
            y=y0;
            Log.e("Player", "x=" + x);
            Log.e("UP","RIGHT");

            body = new RectF(x0-r,  (y0-r1), x0+r,  (y0 +r1));
            Bashnya.body=new RectF(x - Bashnya.r, (y - Bashnya.r1), x + Bashnya.r, (y + Bashnya.r1));

        }
        if (((x2<(1720 / 1920f) * GlobalWars.W && y2<(870 / 1080f) * GlobalWars.H  ))) {

            Log.e("Player", "speedX=" + speedX);
            Log.e("UP","LEFT");
            x0 = (float)(x - speedX * GlobalWars.T);
            y0 = (float)(y - speedY * GlobalWars.T);
            x=x0;
            y=y0;
            Log.e("Player", "x=" + x);
            if (x0<0){
                c.x = (1720 / 1920f) * GlobalWars.W;
            }
            if(y0<0){
                c.y = (870 / 1080f) * GlobalWars.H;
            }
            body = new RectF(x0-r,  (y0-r1), x0+r,  (y0 +r1));
            Bashnya.body=new RectF(x - Bashnya.r, (y - Bashnya.r1), x + Bashnya.r, (y + Bashnya.r1));

        }
        if (((x2<(1720 / 1920f) * GlobalWars.W && y2>(870 / 1080f) * GlobalWars.H  ))) {

            Log.e("Player", "speedX=" + speedX);
            Log.e("DOWN","LEFT");
            x0 = (float) (x - speedX * GlobalWars.T);
            y0 = (float) (y + speedY * GlobalWars.T);
            x = x0;
            y = y0;
            Log.e("Player", "x=" + x);
            if (x0< 0){
                c.x = (1720 / 1920f) * GlobalWars.W;
            }
            if(y0>GlobalWars.H){
                c.y = (870 / 1080f) * GlobalWars.H;

            }
            body = new RectF(x0 - r, (y0 - r1), x0 + r, (y0 + r1));
            Bashnya.body=new RectF(x - Bashnya.r, (y - Bashnya.r1), x + Bashnya.r, (y + Bashnya.r1));

        }
        if (((x2>(1720 / 1920f) * GlobalWars.W && y2>(870 / 1080f) * GlobalWars.H  ))) {

            Log.e("Player", "speedX=" + speedX);
            Log.e("DOWN","RIGHT");
            x0 = (float) (x + speedX * GlobalWars.T);
            y0 = (float) (y + speedY * GlobalWars.T);
            x = x0;
            y = y0;
            Log.e("Player", "x=" + x);
            if (x0> GlobalWars.W){
                c.x = (1720 / 1920f) * GlobalWars.W;

            }
            if(y0>GlobalWars.H){
                c.y = (870 / 1080f) * GlobalWars.H;

            }
            body = new RectF(x0 - r, (y0 - r1), x0 + r, (y0 + r1));
            Bashnya.body=new RectF(x - Bashnya.r, (y - Bashnya.r1), x + Bashnya.r, (y + Bashnya.r1));

        }




    }

     /*   if (x>=GlobalWars.W) {
            speedX=0;
            speedY=0;
        }
        if (x<=0) {
            speedX=0;
            speedY=0;

        }
        if (y>=GlobalWars.H) {
            speedY=0;
            speedX=0;

        }
        if (y<=0) {
            speedY=0;
            speedX=0;

        }
        */

    }


