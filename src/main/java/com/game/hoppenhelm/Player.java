package com.game.hoppenhelm;
import javafx.scene.Parent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Player extends Parent {

    // constructor
    private int CenterX , CenterY , Radius ;
    private double targetY , currentY , deltaY;
    Circle circle;

    private int numbersOfHearts = 3;
    private int sizeHeart = 20;
    Circle[] hearts = new Circle[numbersOfHearts];

    public Player(int CenterX , int CenterY , int Radius) {
        this.CenterX = CenterX ;
        this.CenterY = CenterY ;
        this.Radius = Radius ;

//        System.out.println(this.CenterX + " " + this.CenterY + " " + this.Radius);
        this.circle = new Circle();
        this.circle.setCenterX(this.CenterX);
        this.circle.setCenterY(this.CenterY);
        this.circle.setRadius(this.Radius);
        this.circle.setOpacity(1);
        this.circle.setStyle("-fx-fill: #e529f2 ; -fx-stroke: white; -fx-stroke-width: 3;"); // use stroke for border color

        // create heart of Circle
        for (int i = 0 ; i < numbersOfHearts ; i++){
            Circle heart = new Circle( (i + 0.5)*2* this.sizeHeart , this.sizeHeart ,this.sizeHeart);// x , y , size
            heart.setFill(Color.RED);
            heart.setStyle("-fx-fill: red;-fx-arc-height: 100; -fx-arc-width:100 ; -fx-stroke: white;-fx-stroke-width: 2; ");
            hearts[i] = heart;
        }
    }
    public Circle getCircle() { return circle; }
    public int getCenterX() {
        return CenterX;
    }
    public int getCenterY() {
        return CenterY;
    }
    public int getNumbersOfHearts() { return numbersOfHearts;}
    public Circle[] getHearts() { return hearts; }

    public void minusOpacity(double targetOpacity){
        circle.setOpacity(targetOpacity);
    }

}
