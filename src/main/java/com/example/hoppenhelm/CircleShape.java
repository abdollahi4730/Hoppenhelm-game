package com.example.hoppenhelm;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.lang.Thread;

public class CircleShape {
    // constructor
    public int CenterX , CenterY , Radius ;
    Circle circle;
    public CircleShape(int CenterX , int CenterY , int Radius) {
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
    public void moveCircle() {
        double nowLocationY = this.circle.getCenterY();
        for(double i = nowLocationY ; i > nowLocationY - 100 ; i = i - 1){
            this.circle.setCenterY(i);
//            this.circle.set
////            TimeUnit.SECONDS(1);
//            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this.circle);
////            transition.stop();
//            transition.setToY( transition.getByY() -100);
//            transition.setAutoReverse(true);
//            Thread thread = new Thread();
////            Thread.sleep(1);
//            transition.play();
//            circle.setCenterY(circle.getCenterY() - 100);
//            transition.setCycleCount(TranslateTransition.INDEFINITE);
//            System.out.println(circle.getCenterY());
//            transition.setToY(500);
//            transition.setAutoReverse(true);
//            transition.play();
        // 1716383680 445
        }

    }
}
