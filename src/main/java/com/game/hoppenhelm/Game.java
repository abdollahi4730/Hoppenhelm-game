package com.game.hoppenhelm;
import javafx.application.Application;
import javafx.application.Platform; // work like Thread
import javafx.collections.ObservableList; // like arraylist in javafx
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
import javafx.scene.control.Alert;// for show massage
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;// use in score and timer
import javafx.scene.shape.Circle;

public class Game extends Application {

    private int playScore = 0;
    static private  Label scoreLable;
    static private Stage stage;
    static private Scene scene;
    private int numHearts; // for numbers of hearts
    private int widthScreen, heightScreen;
    private int widthScreenEnemy , heightScreenEnemy , centerXEnemy , centerYEnemey;
    static Timer timer= new Timer();
    static TimerTask Task = new MyTimerTask();
    int contrlSpace = 0;
    Random random = new Random();
    int randomEnemyInt = random.nextInt(10)+7; //

    Enemy enemy;
    Player player;

    static Label timerLabel;
    static int initialTime = 10; // first time
    static int timeLeft; // time left over
    static boolean gameOverBool = false;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {

        this.widthScreen = 720;
        this.heightScreen = 1280;
        player = new Player(80 , 652 , 50);
        numHearts = player.getNumbersOfHearts();
        // size enemy
        widthScreenEnemy = 70;
        heightScreenEnemy = 70 ;
        centerXEnemy = 1230 ;
        centerYEnemey = 635;
        this.enemy = new Enemy(widthScreenEnemy , heightScreenEnemy , centerXEnemy , centerYEnemey );
        Group root = new Group(player.getCircle()  ,this.enemy.getRectangle() );
        for (Node i : player.getHearts()){ // for add heart to screen
            root.getChildren().add(i);
        }
        this.scene = new Scene(root, this.heightScreen, this.widthScreen);
        this.stage = stage;
        scene.setFill(Color.BLACK); // color for background
        stage.setTitle("Hoppenhelm game");

        // create and add timer lable to root
        timerLabel = new Label("Time left: " + initialTime);
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setStyle("-fx-font-size: 35px;");
        timerLabel.setLayoutX(530);
        timerLabel.setLayoutY(20);
        root.getChildren().add(timerLabel);
        timeLeft = 10;// time for end

        scoreLable = new Label("Score: " + playScore);
        scoreLable.setLayoutX(10);
        scoreLable.setLayoutY(50);
        scoreLable.setStyle("-fx-text-fill: white; -fx-font-size: 30px;");
        root.getChildren().add(scoreLable);

        stage.setScene(scene); // set scene on stage
        Playground playground = new Playground(this.widthScreen, this.heightScreen , root);

        resetTimer();
        scene.setOnKeyPressed(e -> { // e is event
            if(e.getCode() == KeyCode.SPACE){
                contrlSpace++;
                playScore++; // Increase the score

                if ( contrlSpace == randomEnemyInt){// create new enemy

                    enemy.set(widthScreenEnemy , heightScreenEnemy , centerXEnemy , centerYEnemey );
                    randomEnemyInt =random.nextInt(10)+8;
                    root.getChildren().add(enemy.getRectangle());
                    contrlSpace = 0;
                }

                try{
//                    playground.movePlayground(root);
                    enemy.moverectangle();
//                    System.out.println("enemy.getCenterX(): "+enemy.getCenterX());
                    if(enemy.getCenterX() == 46 ){// damage enemy
                        // whene rectangle touch circle , rectangle is deleted and heart of player -1

                        numHearts -=1;
                        double biggerXHeart = 0;
                        int biggerXHeartIndex = 0;
                        ObservableList<Node> rootChildren = root.getChildren();

                        for (int i = 0; i < rootChildren.size(); i++) {
                            Node node = rootChildren.get(i);
                            if (node instanceof Circle) {
                                Circle circle = (Circle) node;
                                if (circle.getCenterY() == 20 && circle.getRadius() == 20) { // find big x of heart and save it in biggerXHeartIndex
                                    double nowCircleX = circle.getCenterX();
                                    biggerXHeart = biggerXHeart >= nowCircleX ? biggerXHeart : nowCircleX;
                                    biggerXHeartIndex = i;
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
                        if (biggerXHeart != 0 || biggerXHeartIndex != 0) {
//                            System.out.println("biggerXHeart: " + biggerXHeart + "biggerXHeartIndex: " + biggerXHeartIndex);
                            root.getChildren().remove(biggerXHeartIndex);
                            System.out.println("You lost a blood");

                            double targetMinusOpacity = 1.0 / (this.numHearts +1);
                            double targetOpacity =  player.getOpacity() - targetMinusOpacity;
                            player.minusOpacity(targetOpacity);
//                            System.out.println("player.getOpacity(): "+ player.getOpacity() + "tar: "+targetOpacity);
                        }

                        if (numHearts == 0) { // die
                            System.out.println("player is died");
                            scene.setFill(Color.RED);
                            gameOver();

                        }
                    }

                } catch (Exception exception){
                    System.out.println((exception.getMessage()));
                }

                resetTimer();

                scoreLable.setText("Score: " +playScore);//show score

            }
            if (e.getCode() == KeyCode.V) { // kill enemy
                ObservableList<Node> rootChildren = root.getChildren();

                    if (enemy.getCenterX() == 194) { // x location before touch player

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
        timeLeft = initialTime; // is 10
        timerLabel.setText("Time left: " + timeLeft);
        Task = new MyTimerTask();
        timer.scheduleAtFixedRate(Task, 0, 1000);

    }

    static void gameOver(){
        if (gameOverBool == false){
            gameOverBool = true;
            timer.cancel();
            System.out.println("Game Over");
            scene.setFill(Color.RED);// change background color to red
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Game Over \u2066(\u2060・\u2060_\u2060・)\u2069");
            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK){
//                    System.out.println("response: "+response);
                    stage.close();
                }
            });

        }

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
                }

            });
        }
    }

}
