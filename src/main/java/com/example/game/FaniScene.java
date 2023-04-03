package com.example.game;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FaniScene implements Initializable {

    @FXML
    private ImageView laptop;

    @FXML
    private ImageView laptop1;

    @FXML
    private Button DOWN;

    @FXML
    private Button UP;

    @FXML
    private ImageView pic1;

    @FXML
    private ImageView pic2;

    @FXML
    private ImageView nima;

    @FXML
    private ImageView Congrats;

    @FXML
    private Button NEXTLEVEL;

    @FXML
    private ImageView gameOver;


    private double x;
    private double y;
    private double positionX;
    private double positionY;
    private double width;
    private double height;

    @FXML
    void LEFT(MouseEvent event) {

        nima.setX(x -= 15);
    }

    @FXML
    void RIGHT(MouseEvent event) {
        nima.setX(x += 15);

    }

    @FXML
    void DOWN(MouseEvent event) {

        nima.setY(y += 15);
    }

    @FXML
    void UP(MouseEvent event) {
        nima.setY(y -= 15);

    }

    @FXML
    void SPECIALMOVE(MouseEvent event) {
        RotateTransition special = new RotateTransition();
        special.setNode(nima);
        special.setDuration(Duration.millis(800));
        special.setByAngle(360);
        special.play();
        thread tc2 = new thread(pic2);
        Thread t2 = new Thread(tc2);
        if (nima.getBoundsInParent().intersects(pic1.getBoundsInParent())) {
            pic1.setVisible(false);
            t2.run();
        }
        if (nima.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            t2.run();
        }
        if (pic1.getBoundsInParent().intersects(laptop1.getBoundsInParent()) || pic2.getBoundsInParent().intersects(laptop.getBoundsInParent())){
            TranslateTransition gameover = new TranslateTransition();
            gameover.setNode(gameOver);
            gameover.setDuration(Duration.millis(800));
            gameover.setByY(+400);
            gameover.play();
        }

        if (nima.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            TranslateTransition congrats = new TranslateTransition();
            congrats.setNode(Congrats);
            congrats.setDuration(Duration.millis(800));
            congrats.setByY(+400);
            congrats.play();
        }
    }

    @FXML
    void FITALITY(MouseEvent event) {

    }


    @FXML
    void NEXTLEVEL(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fabnSceneLvl2.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        thread tc1 = new thread(pic1);
        Thread t1 = new Thread(tc1);

        thread tc2 = new thread(pic2);
        Thread t2 = new Thread(tc2);

        t1.run();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


