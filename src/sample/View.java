package sample;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class View extends Application implements EventHandler<ActionEvent> {

    Button button1;





    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller controller = new Controller();

        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("Helper");

        primaryStage.setScene(new Scene(root, 800, 500));



        primaryStage.show();



    }



    @Override
    public void handle(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
