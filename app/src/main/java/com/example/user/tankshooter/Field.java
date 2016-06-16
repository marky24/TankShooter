package com.example.user.tankshooter;

/**
 * Created by user on 6/16/2016.
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public class Field {
    public float [] coorX = new float [4];
    public float [] coorY = new float [4];
    public float [] coorL = new float [4];
    public float [] coorH = new float [4];
    public int j;
    private Paint paint;

    public Field() {
        this.paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Style.FILL_AND_STROKE);
    }

    public void draw(Canvas canvas) {
        //canvas.drawRect(new RectF(0,0,100,100), paint);
        canvas.drawRect(new RectF(1/4f*GlobalWars.W, 8/18f*GlobalWars.H, 1/4f*GlobalWars.W+1/32f*GlobalWars.W, 8/18f*GlobalWars.H+5/18f*GlobalWars.H), paint);
        canvas.drawRect(new RectF(14/32f*GlobalWars.W, 4/18f*GlobalWars.H, 14/32f*GlobalWars.W+5/32f*GlobalWars.W, 4/18f*GlobalWars.H+1/18f*GlobalWars.H), paint);
        canvas.drawRect(new RectF(18/32f*GlobalWars.W, 13/18f*GlobalWars.H, 18/32f*GlobalWars.W+5/32f*GlobalWars.W, 13/18f*GlobalWars.H+1/18f*GlobalWars.H), paint);
    }

}