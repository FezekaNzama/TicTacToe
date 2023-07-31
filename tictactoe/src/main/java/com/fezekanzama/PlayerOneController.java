package com.fezekanzama;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fezekanzama.Model.Player;
import com.fezekanzama.Model.Symbol;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PlayerOneController implements Initializable{
    @FXML
    private Label playerNamePrompt;

    @FXML
    private TextField playerNameTextField;

    @FXML
    private Label playerNameAlert;

    @FXML
    private Button submit;

    private Boolean submitReady; 

    public void setSubmitReady(Boolean submitReady){
        this.submitReady = submitReady;
    }

    public Boolean isSubmitReady() {
        return this.submitReady;
    }

    public Boolean getSubmitReady() {
        return this.submitReady;
    }

    @Override
    public void initialize(URL fxmlURL, ResourceBundle resource) {
        //ensure player name alert is off initially
        alertLabelVisibility(playerNameAlert, false);
    }

    //setting alert label visibility
    private void alertLabelVisibility(Label label, Boolean visibility){
        label.setVisible(visibility);
        label.managedProperty().bind(label.visibleProperty());
    }

    //check name texfiled validity - if valid ie. not empty return true
    private Boolean checkTextInput(){
        if(playerNameTextField.getText().trim().isEmpty()){
            alertLabelVisibility(playerNameAlert, true);
            return false;
        }

        return true;
    }

    //Submit form
    @FXML
    private void onSubmit() throws IOException{
        setSubmitReady(checkTextInput());
        if(submitReady){     
            App.boardModel.players[0]=new Player(playerNameTextField.getText().trim(), Symbol.X); 
            App.setRoot("PlayerTwo");
        }
    }
}
