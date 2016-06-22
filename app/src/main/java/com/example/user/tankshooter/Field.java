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
    public float coorX;
    public float coorY;
    public float coorL;
    public float coorH;
    public int j;
    private Paint paint;

    public Field(float X, float Y, float L, float H) {
        this.coorX=X;
        this.coorY=Y;
        this.coorL=L;
        this.coorH=H;
        this.paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Style.FILL_AND_STROKE);
    }

    public void draw(float X, float Y, float L, float H, Canvas canvas) {
        //canvas.drawRect(new RectF(0,0,100,100), paint);
        this.coorX=X;
        this.coorY=Y;
        this.coorL=L;
        this.coorH=H;
        canvas.drawRect(new RectF(coorX,coorY,coorL,coorH), paint);
        }

}