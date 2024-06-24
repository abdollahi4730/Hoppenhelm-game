package com.game.hoppenhelm;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle; // for use in earth of game
import javafx.util.Duration;

import java.lang.Thread;

public class Player extends Parent {


    // constructor
    private int CenterX , CenterY , Radius ;
    private AnimationTimer timer;
    private double targetY , currentY , deltaY;
    Circle circle;
    public Player(int CenterX , int CenterY , int Radius) {
        this.CenterX = CenterX ;
        this.CenterY = CenterY ;
        this.Radius = Radius ;

//        System.out.println(this.CenterX + " " + this.CenterY + " " + this.Radius);
        this.circle = new Circle();
        this.circle.setCenterX(80);
//        this.circle.setFill(Color.LIGHTGREEN);
        this.circle.setCenterY(652);
        this.circle.setRadius(50);
        this.circle.setStyle("-fx-fill: #e529f2 ; -fx-stroke: white; -fx-stroke-width: 3;"); // use stroke for border color

    }
    public Circle getCircle() {
        return circle;
    }

    public int getCenterX() {
        return CenterX;
    }

    public int getCenterY() {
        return CenterY;
    }

    public void moveCircle() throws InterruptedException {
        System.out.println("hello");
        double nowLocationY = circle.getCenterY();

        circle.setCenterY(nowLocationY -100 );


//        circle.getTransl
//        Thread.sleep(1000);

//        for(double i = nowLocationY ; i > nowLocationY - 200 ; i = i - 8) {
//            circle.setCenterY(i);
//            Thread.sleep(1);
//        }
//        Thread.sleep(500);
//        currentY = circle.getCenterY();
//        for(double i = currentY ; i < currentY + 200 ; i = i + 8) {
//            circle.setCenterY(i);
//            Thread.sleep(1 , 1);
////            Thread.sleep();
//        }
//        System.out.println("bye");

//        currentY = circle.getCenterY();
//        targetY = currentY - 100;
//        deltaY = targetY - currentY;
//
//        this.timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//
//                double speed = 5;
//                circle.setCenterY(targetY);
////                timer.stop();
//            }
//        };



    }

}
