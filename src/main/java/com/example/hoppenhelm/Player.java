package com.example.hoppenhelm;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;

import java.lang.Thread;

public class Player {
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
        this.circle.setFill(Color.BLUE);
        this.circle.setCenterY(650);
        this.circle.setRadius(50);

    }
    public Circle getCircle() {
        return circle;
    }
    public void moveCircle() throws InterruptedException {
        System.out.println("hello");
        Thread.sleep(1000);
        System.out.println("bye");
//        for(double i = nowLocationY ; i > nowLocationY - 100 ; i = i - 1){
//            this.circle.setCenterY(i);
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
