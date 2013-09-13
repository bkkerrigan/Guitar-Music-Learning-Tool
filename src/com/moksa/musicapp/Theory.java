package com.moksa.musicapp;

/*

The theory class is where all the "math" goes down. It will know nothing
of the user interface. With that said, this class should only be interacted
with set/get methods.

*/
public class Theory {

    private int root;
    private int[] scale;
    public String[] scaleNotes;

    Theory() {
        root = 0;
        int[] scale;
        String[] scaleNotes;
    }

    //Set/get root
    public void setRoot(String selectedKey) {

        switch(selectedKey){
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
    }

    public int getRoot(){
        return root;
    }

    //set mode
    public void setScale(String selectedScale) {

        switch(selectedScale){

            case "Major Scale":
                scale = Constants.MAJOR_SCALE;
                break;

            case "Minor Scale":
                scale = Constants.MINOR_SCALE;
                break;

        }
    }

    public String[] getScaleNotes(){

        return scaleNotes;

    }

    //Generate Scale Notes
    public void generateScaleNotes(){

        //Declare variables for this method
        int position;
        int steps;

        scaleNotes = new String[scale.length];

        position = root;

        for(steps = 0; steps < scale.length; steps++){

            position = position + scale[steps];

            if(position == 12){
                position = 0;
            }

            if(position == 13){
                position = 1;
            }

            if(position == 14){
                position = 2;
            }

            scaleNotes[steps] = Constants.NOTE_CIRCLE[position];
        }
    }
}