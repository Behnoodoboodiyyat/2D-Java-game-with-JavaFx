package com.example.game;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MuScene2 implements Initializable {

    private double x;
    private double y;
    boolean st = false;

    @FXML
    private ImageView Congrats1;

    @FXML
    private Button NEXTLEVEL;

    @FXML
    private ImageView brucelee;

    @FXML
    private ImageView gameOver;

    @FXML
    private ImageView laptop;

    @FXML
    private ImageView laptop1;

    @FXML
    private ImageView ramezani;

    @FXML
    private ImageView pic2;

    @FXML
    void DOWN(MouseEvent event) {
        ramezani.setY(y += 15);
    }

    @FXML
    void LEFT(MouseEvent event) {
        ramezani.setX(x -= 15);
    }

    @FXML
    void NEXTLEVEL(MouseEvent event) {

    }

    @FXML
    void RIGHT(MouseEvent event) {
        ramezani.setX(x += 15);
    }

    @FXML
    void SPECIALMOVE(MouseEvent event) {
        TranslateTransition special = new TranslateTransition();
        special.setNode(ramezani);
        special.setDuration(Duration.millis(800));
        special.setCycleCount(TranslateTransition.INDEFINITE);
        special.setByY(-200);
        special.setAutoReverse(true);
        special.play();
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            brucelee.setVisible(false);
            thread tc2 = new thread(pic2);
            Thread t2 = new Thread(tc2);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent()))
            pic2.setVisible(false);
        if (brucelee.getBoundsInParent().intersects(laptop1.getBoundsInParent()) || pic2.getBoundsInParent().intersects(laptop.getBoundsInParent())){
            TranslateTransition gameover = new TranslateTransition();
            gameover.setNode(Congrats1);
            gameover.setDuration(Duration.millis(800));
            gameover.setByY(+400);
            gameover.play();
        }
    }

    @FXML
    void SPECIALMOVE2(MouseEvent event) {
        RotateTransition special = new RotateTransition();
        special.setNode(ramezani);
        special.setDuration(Duration.millis(800));
        special.setByAngle(360);
        special.play();
        thread tc2 = new thread(pic2);
        Thread t2 = new Thread(tc2);
        if (ramezani.getBoundsInParent().intersects(brucelee.getBoundsInParent())) {
            brucelee.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            TranslateTransition congrats = new TranslateTransition();
            congrats.setNode(gameOver);
            congrats.setDuration(Duration.millis(800));
            congrats.setByY(+400);
            congrats.play();
        }
    }

    @FXML
    void UP(MouseEvent event) {
        ramezani.setY(y -= 15);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        thread tc1 = new thread(brucelee);
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
