package com.moksa.musicapp;

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
