package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;


public class Character {

    private String name;
    public Button button;
    private int characterNr;
    private int power;
    private static Controller controller;
    private boolean isChosen;


    public Character(String name, int characterNr, Button buttonNew){


        //this.controller = new Controller();
        this.name = name;
        this.characterNr = characterNr;
        this.power = 100;
        this.isChosen = false;



        button = buttonNew;
        //button.setText(name);
        //button.setMaxWidth(Double.MAX_VALUE);
        //button.setOnAction( e -> {

        //    controller.displayCharacter(this.characterNr);
        //    System.out.println(this.name);
        //});




    }
    public ArrayList<ArrayList<String>> getData(){
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data.add(new ArrayList<String>()); data.get(0).add("name"); data.get(0).add(String.valueOf(this.name));
        data.add(new ArrayList<String>()); data.get(1).add("Character"); data.get(1).add(String.valueOf(this.characterNr));
        data.add(new ArrayList<String>()); data.get(2).add("power"); data.get(2).add(String.valueOf(this.power));
        return(data);
    }

    public boolean getIsChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        if(chosen == true) {
            button.setStyle("-fx-background-color: grey;");
        }
        isChosen = chosen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacterNr(int characterNr) {
        this.characterNr = characterNr;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public Button getButton() {
        return button;
    }

    public int getCharacterNr() {
        return characterNr;
    }
}
