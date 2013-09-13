package com.moksa.musicapp;

import javax.swing.*;
import java.awt.*;

public class Fretboard extends Canvas {

    int STRING_ONE = 7;
    int STRING_TWO = 3;
    int STRING_THREE = 10;
    int STRING_FOUR = 5;
    int STRING_FIVE = 0;
    int STRING_SIX = 7;

    int w = getWidth();
    int h = getHeight();
    Theory theory;

    public Fretboard(Theory t) {

        theory = t;
        setPreferredSize(new Dimension(60,60));

    }

    public void paint(Graphics g){

        //Paint Background
        g.setColor(Color.WHITE);
        g.fillRect(0,0, 500, 500);

        //Paint Guitar Strings
        g.setColor(Color.BLACK);
        g.drawLine(0, h + 15, 500, 15);
        g.drawLine(0, h + 25, 500, 25);
        g.drawLine(0, h + 35, 500, 35);
        g.drawLine(0, h + 45, 500, 45);
        g.drawLine(0, h + 55, 500, 55);
        g.drawLine(0, h + 65, 500, 65);

        //Draw notes
        generateString(g, STRING_ONE, 10);
        generateString(g, STRING_TWO, 20);
        generateString(g, STRING_THREE, 30);
        generateString(g, STRING_FOUR, 40);
        generateString(g, STRING_FIVE, 50);
        generateString(g, STRING_SIX, 60);


    }

    private void generateString(Graphics g, int startPosition, int coordinates){

        int position = startPosition;

        for(int i = 0; i < 13; i++){

            for(String n : theory.getScaleNotes()){

                if(n == Constants.NOTE_CIRCLE[position]){

                    drawNote(g, i*20, coordinates, true, Constants.NOTE_CIRCLE[position]);
                }

                else{

                    drawNote(g, i*20, coordinates, false, null);
                }
            }

            position++;

            if(position == 12){
                position = 0;
            }

            if(position == 13){
                position = 1;
            }

            if(position == 14){
                position = 2;
            }


        }

    }

    private void drawNote(Graphics g, int x, int y, boolean isNote, String noteName){

        if(isNote == true){
            g.setColor(Color.black);
            g.fillOval(x, y, 13, 13);

            g.setColor(Color.white);
            g.drawString(noteName, x + 2, y + 11);
        }

        if(isNote == false){
            g.setColor(Color.black);
            g.drawOval(x, y, 9, 9);
        }

    }

}