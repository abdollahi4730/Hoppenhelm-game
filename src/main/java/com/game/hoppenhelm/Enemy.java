package com.game.hoppenhelm;
import javafx.scene.shape.Rectangle;

public class Enemy {
    private double heightScreen , widthScreen , CenterX , CenterY ;

    Rectangle rectangle ;
    public Enemy(int widthScreen, int heightScreen, int CenterX , int CenterY) {
        this.heightScreen = heightScreen;
        this.widthScreen = widthScreen;
        this.rectangle = new Rectangle();
        this.rectangle.setHeight(heightScreen);
        this.rectangle.setWidth(widthScreen);
        // use stroke for border color . use arc-height and arc-width for corner rectangle.
        this.rectangle.setStyle("-fx-fill: green;-fx-arc-height: 50; -fx-arc-width:50;-fx-stroke: white;-fx-stroke-width: 2; ");
//        this.rectangle.setStyle("-fx-arc-height: 70; -fx-arc-width:70;-fx-stroke: white;-fx-stroke-width: 3; ");
        this.rectangle.setY(CenterY);
        this.rectangle.setX(CenterX);
        this.CenterX = CenterX;
        this.CenterY = CenterY;

    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public void moverectangle() {

        CenterX -=148;
        rectangle.setX(CenterX);
//        System.out.println(CenterX);
    }

    public double getCenterX() {
        return CenterX;
    }

    public void  set(int widthScreen, int heightScreen, int CenterX , int CenterY) {
        this.heightScreen = heightScreen;
        this.widthScreen = widthScreen;

        this.rectangle = new Rectangle();
        this.rectangle.setHeight(heightScreen);
        this.rectangle.setWidth(widthScreen);
        this.rectangle.setStyle("-fx-fill: green;-fx-arc-height: 50; -fx-arc-width:50;-fx-stroke: white;-fx-stroke-width: 2; ");
        this.rectangle.setY(CenterY);
        this.rectangle.setX(CenterX);
        this.CenterX = CenterX;
        this.CenterY = CenterY;

    }
}
