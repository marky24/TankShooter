package com.example.user.tankshooter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by user on 6/14/2016.
 */
public class MySurface extends SurfaceView implements
        SurfaceHolder.Callback
{
    private MyThread myThread;

    public MySurface(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                myThread.touchAction(event.getAction(),event.getX(),event.getY());
//                return true;
//            case MotionEvent.ACTION_MOVE:
////			Toast.makeText(getContext(), "ACTION_MOVE", 10).show();
//                myThread.touchAction(event.getAction(),event.getX(),event.getY());
//                return true;
//            case MotionEvent.ACTION_UP:
////			Toast.makeText(getContext(), "ACTION_UP", 10).show();
//                myThread.touchAction(event.getAction(),event.getX(),event.getY());
//                return true;
//
//        }
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            myThread.touchEvent(event);
            return true;
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        myThread = new MyThread(getContext(),holder,width,height);
        myThread.setRunning(true);
        myThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        myThread.setRunning(false);
        while (retry)
        {
            try
            {
                myThread.join();
                retry = false;
            }
            catch (InterruptedException e)
            {
            }
        }
    }

}
