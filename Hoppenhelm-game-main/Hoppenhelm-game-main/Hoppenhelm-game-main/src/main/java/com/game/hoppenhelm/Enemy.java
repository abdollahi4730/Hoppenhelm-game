package com.game.hoppenhelm;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.shape.Circle;

public class Enemy {
    private double widthRec;
    private int widthScreen , CenterX , CenterY , Radius ;

    Rectangle rectangle ;
    public Enemy(int widthScreen, int heightScreen, int CenterX , int CenterY) {
        this.widthRec = heightScreen;
        this.widthScreen = widthScreen;

        this.rectangle = new Rectangle();
        this.rectangle.setHeight(heightScreen);
        this.rectangle.setWidth(widthScreen);
        this.rectangle.setFill(Color.RED);
        this.rectangle.setY(CenterY);
        this.rectangle.setX(CenterX);

    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    double nowLocationX = 1100;

    public void moverectangle() throws InterruptedException {
        System.out.println("hello");

        nowLocationX -=178;
        rectangle.setX(nowLocationX);
        System.out.println(nowLocationX);
    }
}
