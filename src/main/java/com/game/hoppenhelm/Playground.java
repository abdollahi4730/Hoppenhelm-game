package com.game.hoppenhelm;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

//import
public class Playground {
    private int widthScreen ;
    private double widthRec;


    Playground(int widthScreen , int heightScreen , Group root) {
        this.widthRec = heightScreen / 10.0;
//        Rectangle[] rectangles = new Rectangle[10];
//        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>(10);

//        for(int i = 0 ; i < 10 ; i++){
//            System.out.println(rectangles.get(i));

//            Rectangle rec = rectangles[i];

//            rec.setX(10);
//            System.out.println(rec.getX());
        for (int i = 0 ; i < this.widthRec ; i++){
            if ( i % 2 == 0){

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.BLACK);
                rectangle.setWidth(50);
                rectangle.setHeight(15);
                rectangle.setY(widthScreen - 15);
                rectangle.setX(heightScreen - (i * 50));
                root.getChildren().add(rectangle);

            }

        }
//
//        }
        System.out.println("i created");
    }
//    public Rectangle[] movePlayground(){
//        return this.rectangles;
//    }

}
