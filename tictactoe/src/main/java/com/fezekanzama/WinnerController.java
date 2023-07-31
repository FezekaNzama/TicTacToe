package com.fezekanzama;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class WinnerController implements Initializable{

    @FXML
    Label winnerName;

    @Override
    public void initialize(URL fxmlUrl, ResourceBundle resource) {
        winnerName.setText(App.boardModel.getWinner().getName());
    }

    @FXML
    private void keepPlaying() throws IOException {
        App.boardModel.resetBoard();
        App.setRoot("Board");
    }

    @FXML
    private void endGame() throws IOException {
        App.setRoot("Goodbye");
    }
    
}