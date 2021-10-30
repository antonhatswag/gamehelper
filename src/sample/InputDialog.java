package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class InputDialog {

    public static void main(String[] args) {



    }

    @FXML
    private TextField nameField;

    @FXML
    private TextField powerField;

    @FXML
    private Button doneButton;

    @FXML
    private void buttonClicked(ActionEvent event) {
        if(event.getSource() == doneButton){

            System.out.println("add works");

        }



    }



}
