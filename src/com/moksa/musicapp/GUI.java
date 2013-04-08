package com.moksa.musicapp;


import sun.plugin.javascript.navig.ImageArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import java.io.*;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class GUI extends JFrame  {

    Scale scale = new Scale();

    String path = "C:/black";
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 300;

    //SECTION ONE SECTION ONE SECTION ONE SECTION ONE SECTION ONE SECTION ONE
    private JPanel sectionOne;
    //KEY PANEL
    private JPanel keyPanel;
    private ButtonGroup keyButtonGroup;
    //Radio buttons to chose what key to play in [KEY PANEL]
    private JRadioButton keyA;
    private JRadioButton keyAsharp;
    private JRadioButton keyB;
    private JRadioButton keyC;
    private JRadioButton keyCsharp;
    private JRadioButton keyD;
    private JRadioButton keyDsharp;
    private JRadioButton keyE;
    private JRadioButton keyF;
    private JRadioButton keyFsharp;
    private JRadioButton keyG;
    private JRadioButton keyGsharp;

    //MODE PANEL
    private JPanel modePanel;
    private ButtonGroup modeButtonGroup;
    private JRadioButton majorScale;
    private JRadioButton minorScale;

    //RESULT PANEL
    private JPanel resultPanel;
    private JButton generateData;
    private JButton generateBoard;
    private JLabel scaleNotesOut;

    //SECTION TWO SECTION TWO SECTION TWO SECTION TWO SECTION TWO SECTION TWO
    private JPanel sectionTwo;
    //FRET BOARD
    private JPanel fretPanel;
    private JLabel stringSix;
    private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();


    public GUI(){

        setTitle("Music Learning Tool");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2,0));


        buildSectionOne();
        buildSectionTwo();

        add(sectionOne);
        add(sectionTwo);

        setVisible(true);
    }

    /*
    SECTION ONE
    SECTION ONE
    SECTION ONE
    SECTION ONE
    SECTION ONE
     */
    private void buildSectionOne(){

        buildKeyPanel();
        buildModePanel();
        buildResultPanel();

        sectionOne = new JPanel();
        sectionOne.setLayout(new GridLayout(1,0));

        sectionOne.add(keyPanel);
        sectionOne.add(modePanel);
        sectionOne.add(resultPanel);

    }
    private void buildKeyPanel(){

        //Create key buttons
        keyA = new JRadioButton("A");
        keyAsharp = new JRadioButton("A#");
        keyB = new JRadioButton("B");
        keyC = new JRadioButton("C");
        keyCsharp = new JRadioButton("C#");
        keyD = new JRadioButton("D");
        keyDsharp = new JRadioButton("D#");
        keyE = new JRadioButton("E");
        keyF = new JRadioButton("F");
        keyFsharp = new JRadioButton("F#");
        keyG = new JRadioButton("G");
        keyGsharp = new JRadioButton("G#");

        //Group the radio buttons
        keyButtonGroup = new ButtonGroup();
        keyButtonGroup.add(keyA);
        keyButtonGroup.add(keyAsharp);
        keyButtonGroup.add(keyB);
        keyButtonGroup.add(keyC);
        keyButtonGroup.add(keyCsharp);
        keyButtonGroup.add(keyD);
        keyButtonGroup.add(keyDsharp);
        keyButtonGroup.add(keyE);
        keyButtonGroup.add(keyF);
        keyButtonGroup.add(keyFsharp);
        keyButtonGroup.add(keyG);
        keyButtonGroup.add(keyGsharp);

        //Add action listeners to radio buttons
        keyA.addActionListener(new keyRadioListener());
        keyAsharp.addActionListener(new keyRadioListener());
        keyB.addActionListener(new keyRadioListener());
        keyC.addActionListener(new keyRadioListener());
        keyCsharp.addActionListener(new keyRadioListener());
        keyD.addActionListener(new keyRadioListener());
        keyDsharp.addActionListener(new keyRadioListener());
        keyE.addActionListener(new keyRadioListener());
        keyF.addActionListener(new keyRadioListener());
        keyFsharp.addActionListener(new keyRadioListener());
        keyG.addActionListener(new keyRadioListener());
        keyGsharp.addActionListener(new keyRadioListener());

        //Create Key panel
        keyPanel = new JPanel();

        //BoxLayout lets me list the keys vertically or horizontally. I picked vertically
        //keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.Y_AXIS));

        keyPanel.setLayout(new FlowLayout());

        //Add the key radio buttons to the panel
        keyPanel.add(keyA);
        keyPanel.add(keyAsharp);
        keyPanel.add(keyB);
        keyPanel.add(keyC);
        keyPanel.add(keyCsharp);
        keyPanel.add(keyD);
        keyPanel.add(keyDsharp);
        keyPanel.add(keyE);
        keyPanel.add(keyF);
        keyPanel.add(keyFsharp);
        keyPanel.add(keyG);
        keyPanel.add(keyGsharp);

    }
    private void buildModePanel(){

        //Create mode buttons
        majorScale = new JRadioButton("Major Scale");
        minorScale = new JRadioButton("Minor Scale");

        //Create radio group
        modeButtonGroup = new ButtonGroup();

        //Group radio buttons
        modeButtonGroup.add(majorScale);
        modeButtonGroup.add(minorScale);

        //Add action listeners to radio buttons
        majorScale.addActionListener(new modeRadioListener());
        minorScale.addActionListener(new modeRadioListener());

        modePanel = new JPanel();

        //modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
        modePanel.setLayout(new FlowLayout());

        //Add the key radio buttons to the panel
        modePanel.add(majorScale);
        modePanel.add(minorScale);

    }
    private void buildResultPanel(){

        generateData = new JButton("Get notes");
        generateBoard = new JButton("Get board");
        scaleNotesOut = new JLabel("");

        generateData.addActionListener(new generateDataNotesListener());
        generateBoard.addActionListener(new generateDataFretListener());
        resultPanel = new JPanel();

        resultPanel.add(generateData);
        resultPanel.add(generateBoard);
        resultPanel.add(scaleNotesOut);

    }

        /*
    SECTION TWO
    SECTION TWO
    SECTION TWO
    SECTION TWO
    SECTION TWO
     */
    private void buildSectionTwo(){

        buildFretPanel();

        sectionTwo = new JPanel();

        sectionTwo.add(fretPanel);


    }

    private void buildFretPanel(){

        stringSix = new JLabel();

        fretPanel = new JPanel();

        fretPanel.add(stringSix);

    }

    /*
    LISTENERS
    LISTENERS
    LISTENERS
    LISTENERS
    LISTENERS
     */

    //KEY PANEL
    private class keyRadioListener implements ActionListener{

        public void actionPerformed(ActionEvent kA) {
            scale.setRoot(kA.getActionCommand());
        }
    }
    //MODE PANEL
    private class modeRadioListener implements ActionListener{

        public void actionPerformed(ActionEvent mB) {

           scale.setMode(mB.getActionCommand());

        }
    }
    //RESULT PANEL
    private class generateDataNotesListener implements ActionListener{

        public void actionPerformed(ActionEvent gA){

            String displayedNotes;
            displayedNotes = "";
            scale.getScale(scale.root, scale.mode);

            for(int i = 0; i < scale.scaleNotes.length; i++){
                displayedNotes = displayedNotes + " " + scale.scaleNotes[i];
            }

            scaleNotesOut.setText(displayedNotes);

        }

    }
    public class generateDataFretListener implements ActionListener{

        public void actionPerformed(ActionEvent gB){

            String currentNote;
            String fullOutput = "";

            for(int f = 0; f < Constants.SIXTH_STRING.length; f++){

                currentNote = Constants.SIXTH_STRING[f];

                for(int n = 0; n < scale.scaleNotes.length; n++){

                        if(scale.scaleNotes[n] == currentNote) {
                            fullOutput = fullOutput + "-1-";
                        }
                }

            }

           stringSix.setText(fullOutput);
        }
    }


    /*
    MAIN
    MAIN
    MAIN
    MAIN
     */
    public static void main(String[] args) throws IOException  {
        new GUI();
    }
}
