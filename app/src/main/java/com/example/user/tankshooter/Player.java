package com.example.user.tankshooter;

import android.graphics.Bitmap;
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
    private Bitmap zomb;

    public Player(float x0, float y0, float speed, Bitmap image) {
        this.speed = speed;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        zomb = image;
        body = new RectF(x0, (float) (y0 - 2.5 * h), x0 + 2 * w, (float) (y0 - 0.3 * h));
    }
}