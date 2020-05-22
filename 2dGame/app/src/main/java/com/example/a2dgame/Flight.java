package com.example.a2dgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.a2dgame.GameView.screenRatioX;
import static com.example.a2dgame.GameView.screenRatioY;

public class Flight {

    int toShoot = 0;
    boolean isGoingUp = false;
    int x, y, width, height, wingCounter = 0, shotCounter = 1;
    Bitmap viper, viper2, shoot1, shoot2, shoot3,shoot5, dead;
    private GameView gameView;

    Flight( GameView gameView, int screenY, Resources res){

        this.gameView = gameView;

        viper = BitmapFactory.decodeResource(res, R.drawable.viper);
        viper2 = BitmapFactory.decodeResource(res, R.drawable.viper);

        width = viper.getWidth();
        height = viper.getHeight();

        width /= 4;
        height /=4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        viper = Bitmap.createScaledBitmap(viper, width, height, false);
        viper2 = Bitmap.createScaledBitmap(viper2,width, height, false);

        shoot1 = BitmapFactory.decodeResource(res, R.drawable.shoot1);
        shoot2 = BitmapFactory.decodeResource(res, R.drawable.shoot2);
        shoot3 = BitmapFactory.decodeResource(res, R.drawable.shoot3);
        shoot5 = BitmapFactory.decodeResource(res,R.drawable.viper);

        shoot1 = Bitmap.createScaledBitmap(shoot1,width,height,false);
        shoot2 = Bitmap.createScaledBitmap(shoot2,width,height,false);
        shoot3 = Bitmap.createScaledBitmap(shoot3,width, height, false);
        shoot5 = Bitmap.createScaledBitmap(shoot5,width,height, false);

        dead = BitmapFactory.decodeResource(res, R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead,width, height, false);

        y = screenY /2;
        x = (int)(64 *screenRatioX);


    }

    Bitmap getFlight(){

        if (toShoot != 0){

            if (shotCounter == 1){
                shotCounter++;
                return shoot1;

            }

            if (shotCounter == 2) {
                shotCounter++;
                return shoot2;
            }
            if (shotCounter == 3) {
                shotCounter++;
                return shoot3;
            }

            shotCounter = 1;
            toShoot--;
            gameView.newBullet();

            return shoot5;

        }

        if (wingCounter == 0){
            wingCounter++;
            return viper;
        }

        wingCounter --;

        return viper2;

    }

    Rect getCollisonShape(){
        return new Rect (x,y,x + width,y+ height);
    }

    Bitmap getDead (){
        return dead;
    }


}
