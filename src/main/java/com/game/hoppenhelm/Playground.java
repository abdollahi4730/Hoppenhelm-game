package com.game.hoppenhelm;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

//import
public class Playground {
    private int widthScreen ;
    private double widthRec;
    private int movingRectIndex;


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
//                rectangle.setFill(Color.BLACK);
                rectangle.setStyle("-fx-fill: black; -fx-stroke: green; -fx-stroke-width: 2;");
                rectangle.setWidth(50);
                rectangle.setHeight(15);
                rectangle.setY(widthScreen - 15);
                rectangle.setX(heightScreen - (i * 50));
                root.getChildren().add(rectangle);

            }else {
                Rectangle rectangle = new Rectangle();
//                rectangle.setFill(Color.WHITE);
                rectangle.setStyle("-fx-fill: white; -fx-stroke: #3ed03e; -fx-stroke-width: 2;"); // use stroke for border color and use fill for shape color
                rectangle.setWidth(50);
                rectangle.setHeight(15);
                rectangle.setY(widthScreen - 15);
                rectangle.setX(heightScreen - (i * 50));
                root.getChildren().add(rectangle);
            }
//            System.out.println(root.getChildren());

        }
//
//        }
//        System.out.println("i created");
        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                changeBlocksColor(root);
            }
        });

        root.requestFocus();
    }
    private void changeBlocksColor(Group root) {
        for (Node node : root.getChildren()) {
            if (node instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) node;
                Color currentColor = (Color) rectangle.getFill();

                if (currentColor == Color.BLACK) {
                    rectangle.setFill(Color.WHITE);
                } else if (currentColor == Color.WHITE) {
                    rectangle.setFill(Color.BLACK);
                }
            }
        }
    }

public void movePlayground(Group root){
//        for ( i : root.getChildren()){
//
//        }

//        System.out.println(root.getChildren().get(0).getClass().getName() );

     //   for (Node childIndex : root.getChildren() ){
//            childIndex.toString().charAt()



//        int[]t = new int[10];

    }

}
