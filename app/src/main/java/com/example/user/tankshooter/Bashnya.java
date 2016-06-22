package com.example.user.tankshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Марк on 17.06.2016.
 */
public class Bashnya {
    private Paint paint;
    private Bitmap bash;
    float x;
    static float ugol;

    static RectF body;
    static float r = GlobalWars.W / 20;
    static float r1 = GlobalWars.W / 30;
    float y;

    public Bashnya(float x, float y, Bitmap image) {
        this.x = x;
        this.y = y;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        bash = image;
        body = new RectF(x - r, (y - r1), x + r, (y + r1));


    }

    public void draw(Canvas canvas) {

        Matrix matrix = new Matrix();

        matrix.postRotate(ugol);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bash, 100, 100, false);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        Bitmap bash = rotatedBitmap;
        canvas.drawBitmap(bash, null, body, paint);


    }
}
