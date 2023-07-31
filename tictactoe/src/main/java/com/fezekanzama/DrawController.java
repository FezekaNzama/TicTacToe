package com.fezekanzama;

import java.io.IOException;

import javafx.fxml.FXML;


public class DrawController {

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

