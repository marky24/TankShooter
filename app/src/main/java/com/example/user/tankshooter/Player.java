package com.example.user.tankshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by user on 6/15/2016.
 */
public class Player {
    RectF body;
    private double speed;
    private Paint paint;
    private Bitmap pl;
    private float r=GlobalWars.W/10;

    public Player(float x0, float y0, float speed,Bitmap image) {
        this.speed = speed;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        pl = image;
        body = new RectF(x0-r,  (y0-r), x0+r,  (y0 +r));
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(pl, null, body, paint);
    }
}