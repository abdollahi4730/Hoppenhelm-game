package com.game.hoppenhelm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label testText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application! . this message from onHelloButtonClick");
    }

    @FXML
    protected void onTestButtonClick() {
//        testText.setText("Hello this is a test.");
    System.out.println("helloooo");
    }

}