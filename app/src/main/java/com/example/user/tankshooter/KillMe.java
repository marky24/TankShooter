
package com.example.user.tankshooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * Created by user on 6/14/2016.
 */

public class KillMe {
    private double x;
    private double y;
    private int a;
    private int b;
    private float x0;
    private float y0;
    double x1;
    double y1;
    private Field[] field = new Field[3];
    private float tg;
    private int screenWidth;
    private int screenHeigth;
    private double speed;
    private Paint paint;
    private float r=GlobalWars.W/10;
    private float r1=GlobalWars.W/15;

    public KillMe(float X, float Y,int screenWidth,int  screenHeigth) {
        this.screenWidth = screenWidth;
        this.screenHeigth = screenHeigth;
        x=X;
        y=Y;
        speed = screenWidth / 30f;
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }
    public void update(double deltaT) {
         boolean nokol=true;
        boolean no=true;
        x0 = Player.x;
        y0 = Player.y;
       if ((x+r-125/1920f*GlobalWars.W>=1/4f*GlobalWars.W-1/4*r) & (x-r+96/1920f*GlobalWars.W<=1/4f*GlobalWars.W+1/32f*GlobalWars.W) &
               (y+r1>=8/18f*GlobalWars.H) & (y-r1<=8/18f*GlobalWars.H+5/18f*GlobalWars.H)&(no==true)) {
           y1 = y - speed * deltaT;
           y=y1;
            //speed=0;
           nokol=false;
           no=true;
        }
        else{

           nokol=true;
           no=false;
        }


             if (((x+r1>=14/32f*GlobalWars.W) & (x-r1<=14/32f*GlobalWars.W+5/32f*GlobalWars.W) &
            (y+r-96/1080f*GlobalWars.H>=4/18f*GlobalWars.H) & (y-r+90/1080f*GlobalWars.H<=4/18f*GlobalWars.H+1/18f*GlobalWars.H)&(no==true))||((x+r1>=18/32f*GlobalWars.W) & (x-r1<=18/32f*GlobalWars.W+5/32f*GlobalWars.W) &
                (y+r-96/1080f*GlobalWars.H>=13/18f*GlobalWars.H) & (y-r+90/1080f*GlobalWars.H<=13/18f*GlobalWars.H+1/18f*GlobalWars.H)&(no==true))) {
            x1 = x + speed * deltaT;
            x=x1;
                 nokol=false;
                 no=false;
        }
        else{
                nokol=true;
                 no=true;
        }



      /* if (field[0].coorX>=x) {
            a=1;
        }
        else{
            if
        }

        for (int i=0;i<3;i++){
            tg=(float)(Math.abs(y0-y)/Math.abs(x0-x));
            if (i==1 || i==2) {
                if (x>=field[i].coorX && x<=field[i].coorL && y>=){

                }
            }
        }*/
        if(nokol==true){
            if (x>x0){
                if (y>y0){
                    x1 = x - speed * deltaT;
                    y1 = y - speed * deltaT;

                }
                else {
                    x1 = x - speed * deltaT;
                    y1 = y + speed * deltaT;
                }
            }
            else{
                if (y>y0){
                    x1 = x + speed * deltaT;
                    y1 = y - speed * deltaT;
                }
                else {
                    x1 = x + speed * deltaT;
                    y1 = y + speed * deltaT;
                }
            }
            x=x1;
            y=y1;
            nokol=false;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float)x,(float)y, 50, paint);
    }
}
