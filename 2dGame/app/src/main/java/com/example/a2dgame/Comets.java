package com.example.a2dgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.a2dgame.GameView.screenRatioX;
import static com.example.a2dgame.GameView.screenRatioY;

public class Comets {

    public int speed = 30;
    public boolean wasShot = true;
    int x = 0, y, width, height, cometCounter = 1;
    Bitmap comet1,comet2;

    Comets (Resources res){

        comet1 = BitmapFactory.decodeResource(res, R.drawable.comet1);
        comet2 = BitmapFactory.decodeResource(res, R.drawable.comet1);


        width = comet1.getWidth();
        height = comet1.getHeight();

        width /= 8;
        height /= 8;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        comet1 = Bitmap.createScaledBitmap(comet1, width, height, false);

        y = -height;

}
    Bitmap getComet (){
        if (cometCounter  == 1){
            cometCounter++;
            return comet1;
        }
        // if none of those are true we set it to cometCounter 1
        cometCounter = 1;

        return comet2;


    }
    Rect getCollisonShape(){
        return new Rect (x,y,x + width,y+ height);
    }


    }
