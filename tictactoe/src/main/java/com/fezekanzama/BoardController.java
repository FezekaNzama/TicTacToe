package com.fezekanzama;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BoardController implements Initializable{

    //Player names
    @FXML
    private Label playerOneName;

    @FXML
    private Label playerTwoName;

    //current player - ie. whose turn it is
    @FXML
    private Label currentPlayer; 

    //Grid buttons
    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonNine;

    //List of buttons
    private ArrayList<Button> buttonList = new ArrayList<>();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL fxmlURL, ResourceBundle resource) {
        //set player one labels - name and moves
        playerOneName.setText(App.boardModel.players[0].getName());

        //set player two labels
        playerTwoName.setText(App.boardModel.players[1].getName());

        //set active player
        App.boardModel.setActive(App.boardModel.players[0]);

        //set active player on display
        currentPlayer.setText(App.boardModel.getActive().getName());

        //add buttons to a list of buttons  
        buttonList.add(buttonOne);
        buttonList.add(buttonTwo);
        buttonList.add(buttonThree);
        buttonList.add(buttonFour);
        buttonList.add(buttonFive);
        buttonList.add(buttonSix);
        buttonList.add(buttonSeven);
        buttonList.add(buttonEight);
        buttonList.add(buttonNine);
    }

    @FXML
    public void play(ActionEvent actionEvent) throws IOException{
        Button source = (Button)actionEvent.getSource();
        source.setText(App.boardModel.getActive().getSymbol().name());
        source.setDisable(true);
        App.boardModel.play(buttonList.indexOf(source));
        if(App.boardModel.getWinner()!=null){
            App.setRoot("Winner");
        }
        if(App.boardModel.getMovesRemainingInGame()==0){
            if(App.boardModel.getWinner()!=null){
                App.setRoot("Winner");
            }
            else{  
                App.setRoot("Draw");
            }
        }

        //set active player
        currentPlayer.setText(App.boardModel.getActive().getName());
    }
}