package sample;

import com.sun.glass.ui.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MapView {


    public void displayMap(){

        MapController controller = new MapController();


        try {
            Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Map");

            primaryStage.setScene(new Scene(root, 800, 400));


            primaryStage.show();
        } catch (Exception e) {
            System.out.println("cant load map");
        }

        controller.draw();

    }






}
