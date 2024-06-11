package com.game.hoppenhelm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;// for controll evnet with keyboard
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.control.Alert;// for massage
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;




public class Game extends Application {
    protected int hp = 3;
    private int widthScreen, heightScreen;
    static Timer timer= new Timer();
    static TimerTask Task = new MyTimerTask();
    int contrl = 0;
    Random random = new Random();
    int temp = random.nextInt(10)+7;   // age inja tarif nemishod error midad majbur shodam inja tarif konam



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
        AtomicReference<Enemy> enemy1 = new AtomicReference<>(enemy);
            Group root = new Group(player.getCircle() , enemy1.get().getRectangle() );
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
                contrl++; // tedad space mishmore ta ba temp barabar shod enemy besaze
                if(root.getChildren().get(1).getClass().getName() == "javafx.scene.shape.Circle"){
                    System.out.println("yo");
                }
                if ( contrl == temp){// sakht enemy jadid
                    enemy1.get().set(90 , 110 , 1100 , 595);
                    temp=random.nextInt(10)+7;
                    root.getChildren().set(1 , enemy1.get().getRectangle());
                    contrl=0;
                }

//                System.out.println("you wone. such as ever");
                try{
//                    player.moveCircle();
                    playground.movePlayground(root);
                    enemy1.get().moverectangle();

                    if(enemy1.get().getCenterX() == 32 ){// damage khordan
                        hp-=1;

                        System.out.println(" ye hp cam shod");
                        if (hp == 0) { // die
                            System.out.println(" oh oh you died ");
                            root.getChildren().remove(0);
                            //inja bayad barname tamum beshe
                            Alert alert = new Alert(  AlertType.INFORMATION);

                            alert.setHeaderText(null);
                            alert.setContentText("Your life is over. you are killed :(");
                            alert.getButtonTypes().setAll(ButtonType.OK);
                            alert.showAndWait().ifPresent(response -> {
                                if(response == ButtonType.OK){
                                    stage.close();
                                }
                            });




                        }

                    }

//                    if(enemy1.get().getCenterX() == -324 ){
//
//                        root.getChildren().remove(1);
//                    }
//                    }

                } catch (Exception InterruptedException){
                    System.out.println((InterruptedException.getMessage()));
                }
//                System.out.println(circle.CenterY);
            }
            if (e.getCode() == KeyCode.V){ // zarbe zadan tu yek khone aqab tar

                if (enemy1.get().getCenterX() ==210) {// inja bayad age 3 second gozasht va V nazad ye jun kam beshe va daqiqan rectangle bere be 0v0 ke az junesh 2ta kam nashe
                    System.out.println(" baba benazam koshtish");
                    root.getChildren().remove(1);
                    enemy1.get().set(0 , 0 , 0 , 0);

                }
                enemy1.set(enemy);
            }




        });

        stage.show();
    }


}
