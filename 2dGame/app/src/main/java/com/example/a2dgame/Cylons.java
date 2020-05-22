package com.example.a2dgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.a2dgame.GameView.screenRatioX;
import static com.example.a2dgame.GameView.screenRatioY;

public class Cylons {

    public int speed = 30;
    public boolean wasShot = true;
    int x = 0, y, width, height, cylonCounter = 1;
    Bitmap cylon1, cylon2, cylon3, cylon4;

    Cylons (Resources res){

        cylon1 = BitmapFactory.decodeResource(res, R.drawable.cylon1);
        cylon2 = BitmapFactory.decodeResource(res, R.drawable.cylon1);
        cylon3 = BitmapFactory.decodeResource(res, R.drawable.cylon1);
        cylon4 = BitmapFactory.decodeResource(res, R.drawable.cylon1);

        width = cylon1.getWidth();
        height = cylon1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        cylon1 = Bitmap.createScaledBitmap(cylon1, width, height, false);
        cylon2 = Bitmap.createScaledBitmap(cylon2, width, height, false);
        cylon3 = Bitmap.createScaledBitmap(cylon3, width, height, false);
        cylon4 = Bitmap.createScaledBitmap(cylon4, width, height, false);
 // this makes the cylon begin off the screen in the very beginning of the game
        y = -height;
    }

    Bitmap getCylon (){

        if (cylonCounter  == 1){
            cylonCounter++;
            return cylon1;
        }
        if (cylonCounter  == 2){
            cylonCounter++;
            return cylon2;
        }
        if (cylonCounter  == 3){
            cylonCounter++;
            return cylon3;
        }
        // if none of those are true we set it to cylonCounter 1
        cylonCounter = 1;

        return cylon4;


    }

    Rect getCollisonShape(){
        return new Rect (x,y,x + width,y+ height);
    }


}
