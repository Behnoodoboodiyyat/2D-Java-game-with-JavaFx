module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires javafx.media;


    opens com.example.game to javafx.fxml;
    exports com.example.game;
}