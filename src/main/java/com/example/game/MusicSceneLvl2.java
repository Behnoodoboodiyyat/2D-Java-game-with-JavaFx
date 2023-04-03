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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MusicSceneLvl2 implements Initializable {

    private double x;
    private double y;

    @FXML
    private ImageView Congrats;

    @FXML
    private Button DOWN;

    @FXML
    private Button FINISH;

    @FXML
    private Button UP;

    @FXML
    private ImageView con;

    @FXML
    private ImageView laptop;

    @FXML
    private ImageView laptop1;

    @FXML
    private ImageView laptop2;

    @FXML
    private ImageView nima;

    @FXML
    private ImageView pic1;

    @FXML
    private ImageView pic2;

    @FXML
    private ImageView pic3;

    @FXML
    void DOWN(MouseEvent event) {
        nima.setY(y += 15);

    }

    @FXML
    void FINISH(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("saveData.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void FITALITY(MouseEvent event) {

    }

    @FXML
    void LEFT(MouseEvent event) {
        nima.setX(x -= 15);
    }

    @FXML
    void RIGHT(MouseEvent event) {
        nima.setX(x += 15);
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
        thread tc3 = new thread(pic3);
        Thread t3 = new Thread(tc3);
        if (nima.getBoundsInParent().intersects(pic1.getBoundsInParent())) {
            pic1.setVisible(false);
            t2.run();
        }
        if (nima.getBoundsInParent().intersects(pic2.getBoundsInParent())) {
            pic2.setVisible(false);
            t2.run();
        }
        if (nima.getBoundsInParent().intersects(pic3.getBoundsInParent())) {
            pic3.setVisible(false);
            t2.run();
        }

        if (pic3.getBoundsInParent().intersects(laptop.getBoundsInParent()) || pic2.getBoundsInParent().intersects(laptop1.getBoundsInParent()) ||
                pic3.getBoundsInParent().intersects(laptop2.getBoundsInParent())) {
            TranslateTransition Con = new TranslateTransition();
            Con.setNode(Congrats);
            Con.setDuration(Duration.millis(800));
            Con.setByY(+400);
            Con.play();
        }

        if (nima.getBoundsInParent().intersects(pic3.getBoundsInParent())) {
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
        nima.setY(y -= 15);

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

