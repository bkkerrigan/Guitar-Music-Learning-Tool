package com.moksa.musicapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Brendan Kerrigan
 * Date: 4/9/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fretboard implements ActionListener{

    ImageIcon white = new ImageIcon(getClass().getResource("white.jpg"));
    ImageIcon black = new ImageIcon(getClass().getResource("black.jpg"));
    ImageIcon red = new ImageIcon(getClass().getResource("red.jpg"));
    
    
    
    ArrayList<ArrayList<JButton>> guitarStrings;
    ArrayList stringOne;
    ArrayList stringTwo;
    ArrayList stringThree;
    ArrayList stringFour;
    ArrayList stringFive;
    ArrayList stringSix;


    Fretboard(){


    }


    public ArrayList getString(String[] notes, String[] gString){

        ArrayList<JButton> buttonsArray = new ArrayList<JButton>();

        String[] notesInScale = notes;
        String[] guitarString = gString;

        String currentNote;
        boolean noteFound;

        for(int f = 0; f < guitarString.length; f++){

            noteFound = false;
            currentNote = guitarString[f];
            JButton note = new JButton();

            for(int n = 0; n < notesInScale.length; n++){

                if(notesInScale[n].equals(currentNote)) {
                    note.setIcon(black);
                    noteFound = true;
                }

            }

            if(noteFound != true){
                note.setIcon(white);
            }
            else{
                noteFound = false;
            }

            note.setName("Button" + Integer.toString(f));
            note.addActionListener(new chordListener);
            buttonsArray.add(note);
        }

        return buttonsArray;
    }

    private class chordListener implements ActionListener{

        public void actionPerformed(ActionEvent cA) {
            
            
            ArrayList<JButton> currentString;
            JButton currentNote;
            
            for(int f = 0; f < 6; f++){
                
                currentString = guitarStrings.get(f);
                
                for(int p = 0; p < 3; p++){
                    
                    currentNote = currentString.get(p);
                    
                    for(int n = 0; n < lengthOfNotes; n++){
                        
                        if(currentNote.getActionCommand == scaleNotes[n]){
                            
                            currentNote.setIcon("red.jpg");
                            
                        }
                        
                    }
                     
                    
                }
                
                
            }


        }

    }


}
