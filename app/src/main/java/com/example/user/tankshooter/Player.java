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

    public Player(float x0, float y0, float speed, float h, float w, Bitmap image) {
        this.speed = speed;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        pl = image;
        body = new RectF(x0, (float) (y0 - 2.5 * GlobalWars.H), x0 + 2 * GlobalWars.W, (float) (y0 - 0.3 * GlobalWars.W));
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(pl, null, body, paint);
    }
}