package sample;

import java.util.ArrayList;
import java.util.Arrays;



// INTENDED FOR LOGIC TESTING ONLY NO VALUE IN THE PROJECT'S STRUCTURE
public class Test {

    public static void main(String[] args){

        ArrayList<Integer> alphabetRankList = new ArrayList<>();
        String input = "abc".toLowerCase();
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i < input.length(); i++){
            alphabetRankList.add(alphabet.indexOf(input.charAt(i))+1);
        }


        for (int i = 0; i < alphabetRankList.size(); i++) {
        System.out.println(alphabetRankList.get(i));
        }

        for (Integer i : alphabetRankList) {
            
        }

        //int[] arr = new int[]{0, 4, 2, 1, 6,3};

        //bubblesort
        /*
        boolean changed = true;
        while (changed){
            changed = false;

            for (int i = 0; i < arr.length-1; i++) {

                final int current = arr[i];
                final int next = arr[i+1];



                if (next < current){
                    arr[i] = next;
                    arr[i+1] = current;
                    changed = true;


                }

            }



        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

         */


    }

    public boolean istVielFachesVon(int zahl1, int zahl2){
        if(zahl2 % zahl1 == 0){
            return true;
        }else {return false;}
    }

    public char[] ausschnitt(char[] kette, int start, int end){


        char[] neueKette = new char[end-start];

        if(start > end || end > kette.length || start > kette.length){
            return new char[0];
        }

        int i = 0;
        while (start < end){
            neueKette[i] = kette[start];
            start++;
            i++;
        }
        return neueKette;

    }

}
