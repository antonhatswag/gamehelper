package sample;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public static List<Character> characterList;



    public Model(){

        characterList = new ArrayList<Character>();

    }

    public void refreshCharacterButtons(){
        for(int i = 0; i < characterList.size(); i++){

            characterList.get(i).button.setStyle("");
            characterList.get(i).setChosen(false);


        }


    }

    public void refreshCharacterNumbers(){

        for(int i = 0; i < characterList.size(); i++){

            characterList.get(i).setCharacterNr(i);

        }


    }




}
