package com.example.game;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FaniSceneDR implements Initializable {

    @FXML
    private ImageView congrat;

    @FXML
    private ImageView Congrats;

    @FXML
    private ImageView pic1;

    @FXML
    private ImageView pic2;

    @FXML
    private ImageView ramezani;

    @FXML
    private ImageView laptop1;

    @FXML
    private ImageView laptop2;


    private double x;
    private double y;
    boolean st = false;



    @FXML
    void NEXTLEVEL(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("faniSceneDrLvl2.fxml")));//لول دو رد rxml رو بساز
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
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
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic1.setVisible(false);
            thread tc2 = new thread(pic2);
            Thread t2 = new Thread(tc2);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent()))
            pic2.setVisible(false);
        if (pic1.getBoundsInParent().intersects(laptop1.getBoundsInParent()) || pic2.getBoundsInParent().intersects(laptop2.getBoundsInParent())){
            TranslateTransition gameover = new TranslateTransition();
            gameover.setNode(congrat);
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
        if (ramezani.getBoundsInParent().intersects(pic1.getBoundsInParent())) {
            pic1.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            t2.run();
        }
        if (ramezani.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            TranslateTransition congrats = new TranslateTransition();
            congrats.setNode(Congrats);
            congrats.setDuration(Duration.millis(800));
            congrats.setByY(+400);
            congrats.play();
        }
    }


    @FXML
    void UP(MouseEvent event) {
        ramezani.setY(y -= 15);
    }


    @FXML
    void DOWN(MouseEvent event) {
        ramezani.setY(y += 15);
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
