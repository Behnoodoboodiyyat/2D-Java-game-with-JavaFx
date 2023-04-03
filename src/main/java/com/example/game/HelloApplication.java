package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.sql.*;
import javafx.scene.media.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 400);
        Image icon = new Image("C:\\Users\\Laptopkaran\\IdeaProjects\\game\\src\\main\\resources\\download (1).jpg");
        stage.getIcons().add(icon);
        stage.setTitle("BEHNOOD MODERN WARFARE :)");
        stage.setScene(scene);

        String path = "G:\\music\\James Brown - People Get Up And Drive Your Funky Soul (Remix.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);


        mediaPlayer.setAutoPlay(true);
        stage.setTitle("Playing Audio");

        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();

        String  URL = "jdbc:mysql://localhost:3306/game";
        String Username = "root";
        String Password = "behnood4228";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL , Username , Password);

        System.out.println("connected");
    }
}