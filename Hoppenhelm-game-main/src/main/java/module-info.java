module com.example.hoppenhelm {
    requires javafx.controls;
    requires javafx.fxml;
//    requires java.desktop;


    opens com.game.hoppenhelm to javafx.fxml;
    exports com.game.hoppenhelm;
}