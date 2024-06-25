package com.game.hoppenhelm;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;// for controll evnet with keyboard
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Alert;// for massage
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;// for score

import javafx.scene.shape.Circle;
public class Game extends Application {

    private int playScore = 0;
    static private  Label scoreLable;
    static private Stage stage;
    static private Scene scene;
    protected int numHearts;
    private int widthScreen, heightScreen;
    private int widthScreenEnemy , heightScreenEnemy , centerXEnemy , centerYEnemey;
    static Timer timer= new Timer();
    static TimerTask Task = new MyTimerTask();
    int contrl = 0;
    Random random = new Random();
    int temp = random.nextInt(10)+7;   // age inja tarif nemishod error midad majbur shodam inja tarif konam

    Enemy enemy;
    Player player;

    static Label timerLabel;
    static int initialTime = 10; // زمان اولیه به ثانیه
    static int timeLeft; // زمان باقی مانده به ثانیه
    static boolean gameOverBool = false;
    public static void main(String[] args) {
        launch();

//        timer.schedule(Task ,30000 , 0);

    }
    @Override
    public void start(Stage stage) throws IOException {

        this.widthScreen = 720;
        this.heightScreen = 1280;
        player = new Player(80 , 650 , 50);
        numHearts = player.getNumbersOfHearts();
        // size enemy
        widthScreenEnemy = 70;
        heightScreenEnemy = 70 ;
        centerXEnemy = 1230 ;
        centerYEnemey = 635;
        this.enemy = new Enemy(widthScreenEnemy , heightScreenEnemy , centerXEnemy , centerYEnemey );
        Group root = new Group(player.getCircle()  ,this.enemy.getRectangle() );
        for (Node i : player.getHearts()){
            root.getChildren().add(i);
        }
        System.out.println(player.getHearts());
        this.scene = new Scene(root, this.heightScreen, this.widthScreen); // 920 ix X and 720 ix y
        this.stage = stage;
        scene.setFill(Color.BLACK);
        stage.setTitle("Hoppenhelm game");

        // اضافه کردن تایمر لیبل به روت
        timerLabel = new Label("Time left: " + initialTime);
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setStyle("-fx-font-size: 35px;");
        timerLabel.setLayoutX(530);
        timerLabel.setLayoutY(20);
        root.getChildren().add(timerLabel);
        timeLeft = 10;

        scoreLable = new Label("Score: " + playScore);
        scoreLable.setLayoutX(10);
        scoreLable.setLayoutY(50);
//        scoreLable.setText("Score: 0" );
        scoreLable.setStyle("-fx-text-fill: white; -fx-font-size: 30px;");
        root.getChildren().add(scoreLable);

        stage.setScene(scene); // set scene on stage
        Playground playground = new Playground(this.widthScreen, this.heightScreen , root);

        resetTimer();

        Task = new MyTimerTask();
        timer.schedule(Task, 10000);

        scene.setOnKeyPressed(e -> {
//            timer.schedule(Task ,30000 , 0);
            if(e.getCode() == KeyCode.SPACE){
                contrl++; // tedad space mishmore ta ba temp barabar shod enemy besaze
                playScore++;// Increase the score
//                if(root.getChildren().get(1).getClass().getName() == "javafx.scene.shape.Circle"){
//                    System.out.println("yo");
//                }
                if ( contrl == temp){// sakht enemy jadid
//                    enemy.set(70 , 70 , 1100 , 595);
                    enemy.set(widthScreenEnemy , heightScreenEnemy , centerXEnemy , centerYEnemey );
                    temp=random.nextInt(10)+8;
//                    root.getChildren().set(1 , enemy.getRectangle()); // is a bug
                    root.getChildren().add(enemy.getRectangle());
                    contrl=0;


                }

//                System.out.println("you wone. such as ever");
                try{
//                    player.moveCircle();
                    playground.movePlayground(root);
                    enemy.moverectangle();
//                    System.out.println("enemy.getCenterX(): "+enemy.getCenterX());
                    if(enemy.getCenterX() == 46 ){// damage khordan
                        // whene rectangle touch circle , rectangle is deleted and heart of player -1

                        numHearts -=1;
                        double biggerXHeart = 0;
                        int biggerHeartIndex = 0;
                        ObservableList<Node> rootChildren = root.getChildren();

                        for (int i = 0; i < rootChildren.size(); i++) {
                            Node node = rootChildren.get(i);
                            if (node instanceof Circle) {
                                Circle circle = (Circle) node;
                                if (circle.getCenterY() == 20 && circle.getRadius() == 20) { // find big x of heart and save it in biggerHeartIndex
                                    double nowCircleX = circle.getCenterX();
                                    biggerXHeart = biggerXHeart >= nowCircleX ? biggerXHeart : nowCircleX;
                                    biggerHeartIndex = i;
                                }
                            } else if (node instanceof Rectangle) { // delete enemy that has touch player
                                Rectangle rec = (Rectangle) node;
                                if (rec.getY() == centerYEnemey && rec.getHeight() == heightScreenEnemy && rec.getWidth() == widthScreenEnemy){
//                                    System.out.println(rootChildren.get(i));
                                    root.getChildren().remove(i);
//                                    System.out.println("enemy killed !");
                                    enemy.set(0 , 0 , 0 , 0);

                                }
                            }

                        }
                        if (biggerXHeart != 0 || biggerHeartIndex != 0) {
//                            System.out.println("biggerXHeart: " + biggerXHeart + "biggerHeartIndex: " + biggerHeartIndex);
                            root.getChildren().remove(biggerHeartIndex);
                            System.out.println("You lost a blood");

                            double targetMinusOpacity = 1.0 / (this.numHearts +1);
                            double targetOpacity =  player.getOpacity() - targetMinusOpacity;
                            player.minusOpacity(targetOpacity);
//                            System.out.println("player.getOpacity(): "+ player.getOpacity() + "tar: "+targetOpacity);
                        }

                        if (numHearts == 0) { // die
                            System.out.println("you died");
//                            root.getChildren().remove(0);
                            //inja bayad barname tamum beshe
                            scene.setFill(Color.RED);
                            gameOver();

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

                resetTimer();

                scoreLable.setText("Score: " +playScore);//show score
//                root.getChildren().add(scoreLable);

            }
            if (e.getCode() == KeyCode.V) { // zarbe zadan tu yek khone aqab tar
//                System.out.println(enemy.getCenterX());
                ObservableList<Node> rootChildren = root.getChildren();

                    if (enemy.getCenterX() == 194) {// inja bayad age 3 second gozasht va V nazad ye jun kam beshe va daqiqan rectangle bere be 0v0 ke az junesh 2ta kam nashe


                        for (int i = 0; i < rootChildren.size(); i++) {
                            Node node = rootChildren.get(i);
                            if (node instanceof Rectangle) {
                                Rectangle rec = (Rectangle) node;
                                if (rec.getY() == centerYEnemey && rec.getHeight() == heightScreenEnemy && rec.getWidth() == widthScreenEnemy){
                                    System.out.println(rootChildren.get(i));
                                    root.getChildren().remove(i);
                                    System.out.println("enemy killed !");
                                    enemy.set(0 , 0 , 0 , 0);


                                }
                            }
                        }
                        playScore +=3;

                        scoreLable.setText("Score: " +playScore +"\u2066(\u2060•\u2060‿\u2060•\u2060)\u2069");//show score
//                        root.getChildren().add(scoreLable);

                    }
            }
        });


        stage.show();
    }

    private void resetTimer() {

        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timeLeft = initialTime;
        timerLabel.setText("Time left: " + timeLeft);
        Task = new MyTimerTask();
        timer.scheduleAtFixedRate(Task, 0, 1000);
    }

    static void gameOver(){
        if (gameOverBool == false){
            gameOverBool = true;
            timer.cancel();
            System.out.println("Game Over");
            scene.setFill(Color.RED);
            Alert alert = new Alert(  AlertType.INFORMATION);

            alert.setHeaderText(null);
            alert.setContentText("Game Over \u2066(\u2060・\u2060_\u2060・)\u2069");
            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK){
                    System.out.println("response: "+response);
                    stage.close();
                }
            });

        }


//        System.out.println("yoooooooooo test");
    }
    static class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            Platform.runLater( () -> {
                if (timeLeft > 0) {
                    timeLeft--;
                    timerLabel.setText("Time left: " + timeLeft);
                } else if (timeLeft == 0) {
                    timeLeft = -1;
                    gameOver();
                    timer.cancel();

                    System.out.println("timeLeft: "+timeLeft);

                }

            });
        }
    }

}
