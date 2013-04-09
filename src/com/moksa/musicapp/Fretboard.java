package com.moksa.musicapp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Brendan Kerrigan
 * Date: 4/8/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fretboard {

    ArrayList stringOne;
    List stingTwo;
    List stringThree;
    List stringFour;
    List stringFive;
    List stringSix;

    Fretboard(){

        stringOne = new ArrayList(initButtons(Constants.FIRST_STRING));



    }





    public ArrayList initButtons(String[] gString){

        String[] guitarString = gString;
        ArrayList<JButton> buttonsArray = new ArrayList<JButton>();

        int button = 1;

        int numberOfButtons = 12;

        for(int i = 0;i < 12;i++){
            JButton jButton = new JButton();
            jButton.setText(guitarString[i]);
            jButton.setName("button" + Integer.toString(button));
            buttonsArray.add(jButton);
            button++;
        }

        return buttonsArray;

    }


    public String getString(String[] notes, String[] gString){

        String[] notesInScale = notes;
        String[] guitarString = gString;

        String currentNote;
        String fullOutput = "";
        boolean noteFound;

        for(int f = 0; f < guitarString.length; f++){
            noteFound = false;
            currentNote = guitarString[f];
            System.out.println("Current Letter: " + currentNote);

            for(int n = 0; n < notesInScale.length; n++){

                if(notesInScale[n].equals(currentNote)) {
                    fullOutput = fullOutput + "|--*--";
                    noteFound = true;
                }

                System.out.print("Scale letter" + notesInScale[n] + ": ");
                System.out.println(noteFound);

            }

            if(noteFound != true){
                fullOutput = fullOutput + "|-----";
            }
            else{
                noteFound = false;
            }

        }

        return fullOutput;
    }

}
