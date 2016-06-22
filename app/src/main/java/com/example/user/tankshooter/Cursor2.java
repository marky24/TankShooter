package com.example.user.tankshooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by user on 6/16/2016.
 */
public class Cursor2 {
    static float x;
    static float y;
    static float r = (100f / 1920) * GlobalWars.W;


    private Paint joystickPaint;

    public Cursor2(float x, float y) {
        this.x = x;
        this.y = y;

        joystickPaint = new Paint();
        joystickPaint.setColor(Color.GRAY);
    }

    public void SetPosition(float x1, float y1) {
        x=x1;
        y=y1;
    }
    public static void povorot(){
        if (x>(200 / 1920f) * GlobalWars.W) {


        }
        if (x<(200 / 1920f) * GlobalWars.W) {



        }
        if ((x==(200 / 1920f) * GlobalWars.W) & (y<(870 / 1080f) * GlobalWars.H)) {



        }
        if ((x==(200 / 1920f) * GlobalWars.W) & (y>(870 / 1080f) * GlobalWars.H)) {



        }



    }
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, r, joystickPaint);
    }

}
