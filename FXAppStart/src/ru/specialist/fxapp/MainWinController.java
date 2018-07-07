package ru.specialist.fxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWinController {

    @FXML
    private Label labelHello;

    @FXML
    private TextField txtUserName;

    @FXML
    void onHello(ActionEvent event) {
    	String userName = txtUserName.getText();
    	String result = String.format("Welcome, %s!", userName);
    	labelHello.setText(result);
    }

}