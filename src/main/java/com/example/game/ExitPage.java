package com.example.game;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ExitPage implements Initializable {

    @FXML
    private Label ONE;

    @FXML
    private Label TA;

    @FXML
    private Label TWO;

    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(ONE);
        translate.setDuration(Duration.millis(10000));
        translate.setByY(+120);
        translate.play();
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(TWO);
        translate1.setDuration(Duration.millis(10000));
        translate1.setByY(+120);
        translate1.play();
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(TA);
        translate2.setDuration(Duration.millis(10000));
        translate2.setByY(+120);
        translate2.play();

        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(3000));
        fade.setFromValue(0.1);
        fade.setToValue(10);
        fade.setCycleCount(1000);
        fade.setAutoReverse(true);
        fade.setNode(image);
        fade.play();
    }
}

