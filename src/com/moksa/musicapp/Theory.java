package com.moksa.musicapp;

/*

The theory class is where all the "math" goes down. It will know nothing
of the user interface.

TODO: Make generateNotes() a non void method

*/

public class Theory {

    private int root;
    private int[] scale;
    public String[] scaleNotes;

    Theory() {
        root = 0;
    }

    /**
     *  Takes a string value from the actionCommand of key button from
     *  the KeyPanel class and converts it to its value on the note circle.
     *
     * @param selectedKey - String name of the note selected on the KeyPanel
     *
     */

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

    /**
     * Returns the value of the root/key based on it's position in the note circle.
     *
     * @return the value of the root/key
     */

    public int getRoot(){
        return root;
    }

    /**
     * Takes a string value from the actionCommand of a button from the
     * the ScalePanel class and changes the scale variable to an array
     * version of the scale, obtained from the CONSTANTS class
     *
     * @param selectedScale - String name of the the selected scale
     */

    public void setScale(String selectedScale) {

        switch(selectedScale){

            case "Major Scale":
                scale = CONSTANTS.MAJOR_SCALE;
                break;

            case "Minor Scale":
                scale = CONSTANTS.MINOR_SCALE;
                break;

        }
    }

    /**
     * Gets the array of of scale notes that are in a string array.
     *
     * @return scaleNotes
     */

    public String[] getScaleNotes(){

        return scaleNotes;

    }

    /**
     * Generates musical notes in a scale:
     *
     * Using the selected key/root as the starting position, this method
     * uses a loop, with length of the selected scale as max iterations,
     * and takes steps to the following note on the selected scales
     * step method. The scale note is then assigned a value based on its
     * position in the NoteCircle
     *
     * Whole steps and half steps for dummies:
     * http://www.dummies.com/how-to/content/understanding-half-steps-and-whole-steps.html
     */
    public void generateScaleNotes(){

        int position;
        int steps;

        scaleNotes = new String[scale.length];

        position = root;

        for(steps = 0; steps < scale.length; steps++){

            position = position + scale[steps];

            /*
            Because the note circle is an endless loop, the position of the generator
            must be reset to a lower value if it steps outside the bounds of the
            Note Circle array.
             */

            if(position == 12){
                position = 0; //A
            }

            if(position == 13){
                position = 1; //A#
            }

            if(position == 14){
                position = 2; //B
            }

            scaleNotes[steps] = CONSTANTS.NOTE_CIRCLE[position];
        }
    }
}