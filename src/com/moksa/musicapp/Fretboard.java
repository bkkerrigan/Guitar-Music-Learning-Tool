package com.moksa.musicapp;

/**
 * Created with IntelliJ IDEA.
 * User: Brendan Kerrigan
 * Date: 4/8/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fretboard {



    Fretboard(){

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
