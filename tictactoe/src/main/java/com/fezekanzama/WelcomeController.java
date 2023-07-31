package com.fezekanzama;

import java.io.IOException;

import javafx.fxml.FXML;

public class WelcomeController {

    @FXML
    private void start() throws IOException {
        App.setRoot("PlayerOne");
    }
    
}

