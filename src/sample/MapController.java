package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MapController {





    @FXML
    public MenuItem closeButton;

    @FXML
    private Canvas mapCanvas;

    @FXML
    public void closeClicked(ActionEvent event){
        System.out.println("close");
    }


    public MapController(){

    };


    @FXML
    public void draw(){

        //mapCanvas = new Canvas(100, 100);

        GraphicsContext g = mapCanvas.getGraphicsContext2D();

        g.setFill(Color.LIGHTGRAY);

        //width and height
        g.fillRect(0,0,357, 233);



    }
}
