package com.example.game;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class thread implements Runnable{
    ImageView nima;

    thread(ImageView nima) {
     this.nima = nima;
    }

    @Override
    public void run() {
        FadeTransition appear = new FadeTransition();
        appear.setNode(nima);
        appear.setDuration(Duration.millis(3000));
        appear.setInterpolator(Interpolator.LINEAR);
        appear.setFromValue(0);
        appear.setToValue(1);
        appear.play();

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(nima);
        translate.setDuration(Duration.millis(20000));
        translate.setByX(-300);
        translate.play();
    }
}
