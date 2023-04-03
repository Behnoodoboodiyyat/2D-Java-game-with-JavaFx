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

public class FaniSceneDrLvl2 implements Initializable {

    private double x;
    private double y;

    @FXML
    private ImageView Congrats;

    @FXML
    private Button FINISH;

    @FXML
    private ImageView con;

    @FXML
    private ImageView laptop;

    @FXML
    private ImageView laptop1;

    @FXML
    private ImageView laptop2;

    @FXML
    private ImageView pic1;

    @FXML
    private ImageView pic2;

    @FXML
    private ImageView pic3;

    @FXML
    private ImageView ramezani;

    @FXML
    void DOWN(MouseEvent event) {
        ramezani.setY(y += 15);

    }

    @FXML
    void FINISH(MouseEvent event) {

    }

    @FXML
    void LEFT(MouseEvent event) {
        ramezani.setX(x -= 15);

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

        thread tc2 = new thread(pic2);
        Thread t2 = new Thread(tc2);
        thread tc3 = new thread(pic3);
        Thread t3 = new Thread(tc3);


        if (ramezani.getBoundsInParent().intersects(pic1.getBoundsInParent())) {
            pic1.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic3.getBoundsInParent())) {
            pic3.setVisible(false);
            t2.run();
        }
        if (pic1.getBoundsInParent().intersects((laptop2.getBoundsInParent())) || pic2.getBoundsInParent().intersects(laptop1.getBoundsInParent()) ||
                pic3.getBoundsInParent().intersects(laptop.getBoundsInParent())) {
            TranslateTransition gameover = new TranslateTransition();
            gameover.setNode(Congrats);
            gameover.setDuration(Duration.millis(800));
            gameover.setByY(+400);
            gameover.play();
        }
        if (ramezani.getBoundsInParent().intersects(pic3.getBoundsInParent())) {
            pic2.setVisible(false);
            TranslateTransition congrats = new TranslateTransition();
            congrats.setNode(con);
            congrats.setDuration(Duration.millis(800));
            congrats.setByY(+400);
            congrats.play();
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
        thread tc3 = new thread(pic3);
        Thread t3 = new Thread(tc3);


        if (ramezani.getBoundsInParent().intersects(pic1.getBoundsInParent())) {
            pic1.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
        }
        if (ramezani.getBoundsInParent().intersects(pic3.getBoundsInParent())) {
            pic3.setVisible(false);
            t2.run();
        }
        if (pic1.getBoundsInParent().intersects((laptop2.getBoundsInParent())) || pic2.getBoundsInParent().intersects(laptop1.getBoundsInParent()) ||
                pic3.getBoundsInParent().intersects(laptop.getBoundsInParent())) {
            TranslateTransition gameover = new TranslateTransition();
            gameover.setNode(Congrats);
            gameover.setDuration(Duration.millis(800));
            gameover.setByY(+400);
            gameover.play();
        }
        if (ramezani.getBoundsInParent().intersects(pic3.getBoundsInParent())) {
            pic2.setVisible(false);
            TranslateTransition congrats = new TranslateTransition();
            congrats.setNode(con);
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
        thread tc1 = new thread(pic1);
        Thread t1 = new Thread(tc1);

        thread tc2 = new thread(pic2);
        Thread t2 = new Thread(tc2);

        thread tc3 = new thread(pic3);
        Thread t3 = new Thread(tc3);

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
        t3.run();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
