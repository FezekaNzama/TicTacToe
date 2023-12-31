package com.fezekanzama;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.fezekanzama.Model.BoardModel;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static BoardModel boardModel;


    @Override
    public void start(Stage stage) throws IOException {
        boardModel = new BoardModel();
        scene = new Scene(loadFXML("Welcome"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}