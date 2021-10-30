package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Controller {

    public static int characterNr = 0;

    private View view;
    private Model model;
    private int selectedCharNr;

    @FXML
    private VBox rootVbox;

    @FXML
    private MenuItem openMapButton;

    @FXML
    private MenuItem saveFile;

    @FXML
    private MenuItem openFile;

    @FXML
    private VBox characterDisplay;

    @FXML
    public VBox characterVboxWithButtons;

    @FXML
    private Button addChar;

    @FXML
    private Button removeChar;

    private Affine affine;

    private TileMap tileMap;

    private Canvas map;

    private GraphicsContext gc;

    private String currentMapObj;

    private List<String> mapObjTypeList;




    public Controller(){

        model = new Model();
        view = new View();
        selectedCharNr = 0;
        affine = new Affine();
        tileMap = new TileMap(10, 10);
        map = new Canvas(400, 400);
        gc = map.getGraphicsContext2D();
        currentMapObj = "LIGHTGRAY";
        mapObjTypeList = Arrays.asList("BLACK", "BLUE", "LIGHTGRAY", "YELLOW", "RED");
        affine.appendScale(400 / 10f, 400/ 10f);


    }

    public void setBackground(){
        BackgroundImage myBI = new BackgroundImage(new Image("https://wallpapercave.com/wp/wp4284471.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


        characterDisplay.setBackground(new Background((myBI)));
    }

    //grids and cells

    public void drawCells(){

        for (int x = 0; x < tileMap.width; x++) {
            for (int y = 0; y < tileMap.height; y++) {



                if(tileMap.board[x][y] == 1){
                    //last clicked tile becomes chosen color
                    //Image image = new Image("/sample/test.png");

                    //gc.drawImage(image, 1, 1);
                    gc.setFill(Color.web(currentMapObj));
                    gc.fillRect(x, y, 1, 1);


                    // empty tiles become light gray
                }
                if(tileMap.board[x][y] != 2 && tileMap.board[x][y] != 1 || tileMap.board[x][y] == 0){
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillRect(x, y, 1, 1);
                }
            }

        }

        //draw grids
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(0.02f);
        for (int x = 0; x <= tileMap.width; x++) {
            gc.strokeLine(x, 0, x, 10);
        }
        for (int y = 0; y <= tileMap.height ; y++) {
            gc.strokeLine(0, y, 10, y);
        }

    }

    public void createMap(){




        //tile is clicked event
        map.setOnMousePressed( e -> {
            double mouseX = e.getX();
            double mouseY = e.getY();

            System.out.println(mouseX + "  " + mouseY);

            //transforming 0-400 coords into 0-10 coords (in ratio to the tiles)
            try {
                Point2D clickedPoint = affine.inverseTransform(mouseX, mouseY);

                //cutting decimals behind 0. off (rounding to lowest integer)
                int intX = (int) clickedPoint.getX();
                int intY = (int) clickedPoint.getY();


                for (int x = 0; x < tileMap.width; x++) {
                    for (int y = 0; y < tileMap.height; y++) {
                        if(tileMap.board[x][y] == 1){
                            tileMap.board[x][y] = 2;
                        }

                    }

                }

                tileMap.board[intX][intY] = 1;


                System.out.println(intX + "  " + intY);
            } catch (NonInvertibleTransformException nonInvertibleTransformException) {
                System.out.println("couldnt transform");
            }
            System.out.println();
            drawCells();

        });

        gc.setTransform(affine);



        //gc.setFill(Color.LIGHTGRAY);
        //???
        //width and height
        //gc.fillRect(0,0,400, 400);




        drawCells();




}

    @FXML
    private void editClicked(ActionEvent event){
        setBackground();
    };

    @FXML
    private void generateDiceClicked(ActionEvent event){

        showDiceGenerator();

    }

    @FXML
    private void openMapClicked(ActionEvent event){


        createMap();


        List<Button> buttonList = new ArrayList<>();

        List<String> buttonNames = new LinkedList<String>(Arrays.asList("Obsticle", "Water", "Eraser", "Loot", "Enemy"));
        for (int r = 0; r < model.characterList.size() ; r++) {
            buttonNames.add(model.characterList.get(r).getName());
        }

        Button[] buttonArray = new Button[buttonNames.size()];

        for (int i = 0; i < buttonNames.size(); i++) {

            Button x = new Button(buttonNames.get(i));

            int finalI = i;



            String style = ("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 20 10 20;");

            x.setStyle(style);

            // standard map objects, players excluded
            if(i < mapObjTypeList.size()){
                x.setStyle(style + "\n-fx-text-fill: "+ mapObjTypeList.get(finalI));
                x.setOnAction(e -> {
                    currentMapObj = mapObjTypeList.get(finalI);
                });
            }
            //players included
            else{
                x.setOnAction(e -> {
                    currentMapObj = "PINK";
                });

            }

            x.setMinWidth(100);

            buttonArray[i] = x;
        }




        VBox toolBar = new VBox(buttonArray);
        HBox hbox = new HBox(map, toolBar);
        characterDisplay.getChildren().clear();
        characterDisplay.getChildren().add(hbox);
        //drawCells();






    }

    private void showDiceGenerator(){

        int sides = getDiceWithInput();

        int randomNum = ThreadLocalRandom.current().nextInt(1, sides + 1);
        System.out.println(randomNum);

        Label infoBox = new Label();
        infoBox.setText("Würfel Ergebnis:");
        infoBox.setStyle("-fx-border-color: grey;");

        Label diceResult = new Label();
        diceResult.setText("\t\t\t"+String.valueOf(randomNum));
        diceResult.setStyle("-fx-border-color: grey;");

        this.characterDisplay.getChildren().clear();
        this.characterDisplay.getChildren().addAll(infoBox, diceResult);




    }



    @FXML
    private void saveFileClicked(ActionEvent event){
        if(event.getSource() == saveFile) {

            System.out.println("save");
        }
    }

    @FXML
    private void openFileClicked(ActionEvent event){
        if(event.getSource() == openFile) {

            System.out.println("open");
        }
    }

    @FXML
    private void buttonClicked(ActionEvent event) {
        if(event.getSource() == addChar){

            System.out.println("add works");
            addCharacter();
        }



    }
    @FXML
    public void displayCharacter(int chaNr){


        ObservableList<Character> data = FXCollections.observableArrayList();
        data.add(model.characterList.get(chaNr));

        TableView<Character> table = new TableView<>();

        //name column
        TableColumn<Character, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        //characterNr column
        TableColumn<Character, String> nrCol = new TableColumn<>("CharacterNr");
        nrCol.setMinWidth(200);
        nrCol.setCellValueFactory(new PropertyValueFactory<>("characterNr"));

        //power column
        TableColumn<Character, String> powerCol = new TableColumn<>("Power");
        powerCol.setMinWidth(200);
        powerCol.setCellValueFactory(new PropertyValueFactory<>("power"));

        table.setMaxHeight(50);
        table.setMaxWidth(630);
        table.setItems(data);
        table.getColumns().addAll(nameCol, nrCol, powerCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TextArea characterDescription = new TextArea("this character is cool");




        this.characterDisplay.getChildren().clear();
        this.characterDisplay.getChildren().addAll(table, characterDescription);



    }

    public Integer getDiceWithInput(){
        TextInputDialog dialog = new TextInputDialog("New Dice");
        dialog.setTitle("New Dice");
        dialog.setHeaderText("Creating new Dice...");
        dialog.setContentText("Please enter the amount of sides:");


        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            return(Integer.parseInt(result.get()));

        }

        return(6);
    }

    public String getNameWithInput(){
        TextInputDialog dialog = new TextInputDialog("New Character");
        dialog.setTitle("New character");
        dialog.setHeaderText("Creating new Character...");
        dialog.setContentText("Please enter a name:");


        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            return(result.get());

        }

        return("no name given");
    }

    @FXML
    private void removeCharClicked(ActionEvent event) {
        if(event.getSource()==removeChar){

            characterVboxWithButtons.getChildren().remove(model.characterList.get(selectedCharNr).getButton());

            model.characterList.remove(this.selectedCharNr);

            this.characterDisplay.getChildren().clear();

            this.characterNr--;

            model.refreshCharacterNumbers();




            System.out.println("remove works");
        }

    }



    @FXML
    public void addCharacter(){

        String name = getNameWithInput();

        Button button = new Button();
        button.setText(name);
        button.setMaxWidth(Double.MAX_VALUE);

        Character x = new Character(name, characterNr, button);
        model.characterList.add(x);

        this.characterDisplay.getChildren().clear();

        button.setOnAction( e -> {
            System.out.println(button.getText() + " " + x.getName() + " " + x.getCharacterNr());
            if(button.getText().equals(x.getName())) {
                this.displayCharacter(x.getCharacterNr());
            }else{System.out.println("falsch");}
            this.selectedCharNr = x.getCharacterNr();


            model.refreshCharacterButtons();
            x.setChosen(true);


        });



        characterVboxWithButtons.getChildren().add(model.characterList.get(characterNr).getButton());

        characterNr++;
    }


}
