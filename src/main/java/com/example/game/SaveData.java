package com.example.game;

import SQL.mySQL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import java.sql.*;

public class SaveData {
    int score = 100;
    @FXML
    private TextField name;
    String Name = name.getText();


    @FXML
    void save(MouseEvent event) {
        String sqlCommand = String.format("INSERT INTO statistic (name,score) + values('%s','%d')", Name, score);
        mySQL sql = new mySQL();
        sql.executeQuery(sqlCommand);
    }


}