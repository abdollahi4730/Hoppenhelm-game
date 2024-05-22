module com.example.hoppenhelm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.hoppenhelm to javafx.fxml;
    exports com.example.hoppenhelm;
}