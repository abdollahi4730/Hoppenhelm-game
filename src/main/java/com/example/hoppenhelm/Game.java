package com.example.hoppenhelm;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;// for controll evnet with keyboard
import java.io.IOException;

public class Game extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Player player = new Player(80 , 650 , 50);
        Group root = new Group(player.getCircle());
        Scene scene = new Scene(root, 920, 720); // 920 ix X and 720 ix y
//        Scene scene = new Scene(fxmlLoader.load(), 920, 720);
        scene.setFill(Color.LIGHTGREEN);
        stage.setTitle("Hoppenhelm game");

        stage.setScene(scene); // set scene on stage

        scene.setOnKeyPressed(e -> {

            if(e.getCode() == KeyCode.SPACE){
//                System.out.println("you wone. such as ever");
                try{
                    player.moveCircle();

                } catch (Exception InterruptedException){
                    System.out.println((InterruptedException.getMessage()));
                }
//                System.out.println(circle.CenterY);
            }
        });

        stage.show();
    }


}