package com.game.hoppenhelm;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;// for controll evnet with keyboard
import java.io.IOException;

import javafx.scene.shape.Rectangle;
public class Game extends Application {
    private int widthScreen, heightScreen;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        this.widthScreen = 720;
        this.heightScreen = 1280;
        Player player = new Player(80 , 650 , 50);

        Group root = new Group(player.getCircle());
        Scene scene = new Scene(root, this.heightScreen, this.widthScreen); // 920 ix X and 720 ix y
        scene.setFill(Color.LIGHTGREEN);
        stage.setTitle("Hoppenhelm game");


        stage.setScene(scene); // set scene on stage
        Playground playground = new Playground(this.widthScreen, this.heightScreen , root);
//        Rectangle []rectangles = playground.movePlayground();

//        root.getChildren().add(rectangle);

        scene.setOnKeyPressed(e -> {

            if(e.getCode() == KeyCode.SPACE){
                if(root.getChildren().get(1).getClass().getName() == "javafx.scene.shape.Circle"){
                    System.out.println("yo");
                }
//                System.out.println("you wone. such as ever");
                try{
                    player.moveCircle();
                    playground.movePlayground(root);
//                    }

                } catch (Exception InterruptedException){
                    System.out.println((InterruptedException.getMessage()));
                }
//                System.out.println(circle.CenterY);
            }
        });



        stage.show();
    }


}
