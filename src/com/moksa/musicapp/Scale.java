package com.moksa.musicapp;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Brendan Kerrigan
 * Date: 4/9/13
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Scale {

    int root;
    int[] mode;
    String[] scaleNotes;

    public Scale(){
        root = 0;
        int[] mode;
        String[] scaleNotes;
    }

    public String[] getScale(int key, int[] mode){

        scaleNotes = new String[mode.length];

        final String[] tones = Constants.NOTE_CIRCLE; //Note Circle
        final int[] scale = mode; //2 = Whole Step, 1 = Half Step
        int position;
        int steps;

        position = key;

        for(steps = 0; steps < scale.length; steps++){

            position = position + scale[steps];

            if(position == 12) {
                position = 0;
            }

            if(position == 13) { //Cut these ifs down in size
                position = 1;
            }

            if(position == 14) {
                position = 2;
            }

            scaleNotes[steps] = tones[position];
        }
        return scaleNotes;
    }
    public ArrayList getChord(String actionCommand){

        String chordRoot = actionCommand;

        int[] chordType = new int[3];
        ArrayList<String> chordNotes = new ArrayList<String>();

        int scalePosition;
        int position;

        int steps;
        int n;
        for( n = 0; n < 7; n++){

            if(chordRoot == scaleNotes[n]){
                scalePosition = n;
                if(mode == Constants.MAJOR){
                    System.arraycopy(Constants.MAJOR_CHORD_PROGRESSION, n, chordType, n, Constants.MAJOR_CHORD_PROGRESSION.length);
                }
                if(mode == Constants.MINOR){
                    System.arraycopy(Constants.MINOR_CHORD_PROGRESSION, n, chordType, n, Constants.MINOR_CHORD_PROGRESSION.length);
                }

            }
        }

        int t;
        for(t = 0; t < 3; t++){

            System.out.print(chordType[t]);

        }

        for(steps = 0; steps < 3; steps++){

            position = chordType[steps];

            if(position == 6) {
                position = 0;
            }

            if(position == 7) { //Cut these ifs down in size
                position = 1;
            }

            if(position == 8) {
                position = 2;
            }

            if(position == 9){
                position = 3;
            }

            chordNotes.set(steps, scaleNotes[position]);

        }
        System.out.print(chordNotes.get(0) + chordNotes.get(1) + chordNotes.get(2));
        return chordNotes;
    }
    public int setRoot(String rootLetter){
        switch(rootLetter){
            case "A":
                root = 0;
                break;
            case "A#":
                root = 1;
                break;
            case "B":
                root = 2;
                break;
            case "C":
                root = 3;
                break;
            case "C#":
                root = 4;
                break;
            case "D":
                root = 5;
                break;
            case "D#":
                root = 6;
                break;
            case "E":
                root = 7;
                break;
            case "F":
                root = 8;
                break;
            case "F#":
                root = 9;
                break;
            case "G":
                root = 10;
                break;
            case "G#":
                root = 11;
                break;
        }
        return root;
    }
    public int[] setMode(String modeString){

        switch(modeString){
            case "Major Scale":
                mode = new int[Constants.MAJOR.length];
                mode = Constants.MAJOR;
                break;
            case "Minor Scale":
                mode = new int[Constants.MINOR.length];
                mode = Constants.MINOR;
                break;
            case "Pentatonic Scale":
                mode = new int[Constants.PENTATONIC.length];
                mode = Constants.PENTATONIC;
                break;
        }
        return mode;
    }

}
