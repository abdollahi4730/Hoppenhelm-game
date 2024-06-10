package com.game.hoppenhelm;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;// for controll evnet with keyboard
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Game extends Application {
    protected int hp = 3;
    private int widthScreen, heightScreen;
    static Timer timer= new Timer();
    static TimerTask Task = new MyTimerTask();
    int contrl = 0;

    Random random = new Random();
    int temp = random.nextInt(10)+7;



    public static void main(String[] args) {
        launch();

//        timer.schedule(Task ,30000 , 0);

    }
    @Override
    public void start(Stage stage) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        this.widthScreen = 720;
        this.heightScreen = 1280;
        Player player = new Player(80 , 650 , 50);
        Enemy enemy = new Enemy(90 , 110 , 1100 , 595 );
        Enemy enemy1 = enemy;
            Group root = new Group(player.getCircle() , enemy1.getRectangle() );
        Scene scene = new Scene(root, this.heightScreen, this.widthScreen); // 920 ix X and 720 ix y
        scene.setFill(Color.DARKBLUE);
        stage.setTitle("Hoppenhelm game");

        stage.setScene(scene); // set scene on stage
        Playground playground = new Playground(this.widthScreen, this.heightScreen , root);
//        Rectangle []rectangles = playground.movePlayground();

//        root.getChildren().add(rectangle);


        scene.setOnKeyPressed(e -> {
//            timer.schedule(Task ,30000 , 0);
            if(e.getCode() == KeyCode.SPACE){
                contrl++;
                if(root.getChildren().get(1).getClass().getName() == "javafx.scene.shape.Circle"){
                    System.out.println("yo");
                }
                System.out.println("jump" + contrl );
                if ( contrl == temp){
                    enemy1.set(90 , 110 , 1100 , 595);
                    temp=random.nextInt(10)+7;
                    root.getChildren().set(1 ,enemy1.getRectangle());
                    contrl=0;
                }

//                System.out.println("you wone. such as ever");
                try{
//                    player.moveCircle();
                    playground.movePlayground(root);
                    enemy1.moverectangle();

                    if(enemy1.getCenterX() == 32 ){
                        hp-=1;
                        System.out.println(" ye hp cam shod");
                        if (hp == 0) {
                            System.out.println(" oh oh you died ");
                            root.getChildren().remove(0);
                        }

                    }

                    if(enemy1.getCenterX() == -324 ){

                        root.getChildren().remove(1);
                    }
//                    }

                } catch (Exception InterruptedException){
                    System.out.println((InterruptedException.getMessage()));
                }
//                System.out.println(circle.CenterY);
            }
            if (e.getCode() == KeyCode.V){
                if (enemy1.getCenterX() ==210) {
                    System.out.println(" baba benazam koshtish");
                    root.getChildren().remove(1);

                    enemy1.set(0 , 0 , 0 , 0);
                }
                enemy1=enemy;
            }




        });

        stage.show();
    }


}
