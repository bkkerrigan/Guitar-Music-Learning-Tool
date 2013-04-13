package com.moksa.musicapp;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;

import java.util.*;

public class GUI extends JFrame  {




    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 400;

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
    private JRadioButton pentatonic;

    //RESULT PANEL
    private JPanel resultPanel;
    private JButton generateBoard;
    private JLabel scaleNotesOut;

    //SECTION TWO SECTION TWO SECTION TWO SECTION TWO SECTION TWO SECTION TWO
    private JPanel sectionTwo;
    //FRET BOARD
    private JPanel fretPanel;

    private JPanel stringOne;
    private JPanel stringTwo;
    private JPanel stringThree;
    private JPanel stringFour;
    private JPanel stringFive;
    private JPanel stringSix;
    private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();

    Scale s;
    Fretboard f;

    public static void main(String[] args) throws IOException  {

        Scale scale = new Scale();
        Fretboard fretboard = new Fretboard(scale);

        new GUI(scale, fretboard);
    }

    public GUI(Scale scale, Fretboard fretboard){

        s = scale;
        f = fretboard;

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
        pentatonic = new JRadioButton("Pentatonic Scale");

        //Create radio group
        modeButtonGroup = new ButtonGroup();

        //Group radio buttons
        modeButtonGroup.add(majorScale);
        modeButtonGroup.add(minorScale);
        modeButtonGroup.add(pentatonic);

        //Add action listeners to radio buttons
        majorScale.addActionListener(new modeRadioListener());
        minorScale.addActionListener(new modeRadioListener());
        pentatonic.addActionListener((new modeRadioListener()));

        modePanel = new JPanel();

        //modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
        modePanel.setLayout(new FlowLayout());

        //Add the key radio buttons to the panel
        modePanel.add(majorScale);
        modePanel.add(minorScale);
        modePanel.add(pentatonic);

    }
    private void buildResultPanel(){

        generateBoard = new JButton("Get board");
        scaleNotesOut = new JLabel("");

        generateBoard.addActionListener(new generateDataFretListener());
        resultPanel = new JPanel();

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

        fretPanel = new JPanel();
        fretPanel.setLayout(new GridLayout(6,0));

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
            s.setRoot(kA.getActionCommand());
        }
    }
    //MODE PANEL
    private class modeRadioListener implements ActionListener{

        public void actionPerformed(ActionEvent mB) {

            s.setMode(mB.getActionCommand());

        }
    }
    //RESULT PANEL
    public class generateDataFretListener implements ActionListener{

        public void actionPerformed(ActionEvent gB){


            ////////////////////////////ACTION ONE

            String displayedNotes;
            displayedNotes = "";
            s.getScale(s.root, s.mode);

            for(int i = 0; i < s.scaleNotes.length; i++){
                displayedNotes = displayedNotes + " " + s.scaleNotes[i];
            }


            scaleNotesOut.setText(displayedNotes);

            ////////////////////////////// ACTION TWO

            updateBoard(gB.getActionCommand());



        }
    }

    public void updateBoard(String root){

        String chordRoot = root;

        fretPanel.removeAll();

        int fret;

        stringOne = new JPanel();
        stringTwo = new JPanel();
        stringThree = new JPanel();
        stringFour = new JPanel();
        stringFive = new JPanel();
        stringSix = new JPanel();

        fretPanel.add(stringOne);
        fretPanel.add(stringTwo);
        fretPanel.add(stringThree);
        fretPanel.add(stringFour);
        fretPanel.add(stringFive);
        fretPanel.add(stringSix);

        f.stringOne = f.getString(s.scaleNotes,Constants.FIRST_STRING);
        f.stringTwo = f.getString(s.scaleNotes,Constants.SECOND_STRING);
        f.stringThree = f.getString(s.scaleNotes,Constants.THIRD_STRING);
        f.stringFour = f.getString(s.scaleNotes,Constants.FOURTH_STRING);
        f.stringFive = f.getString(s.scaleNotes,Constants.FIFTH_STRING);
        f.stringSix = f.getString(s.scaleNotes,Constants.SIXTH_STRING);


        for(fret = 0; fret < 13; fret++){

            stringOne.add((JButton) f.stringOne.get(fret));
            stringTwo.add((JButton) f.stringTwo.get(fret));
            stringThree.add((JButton) f.stringThree.get(fret));
            stringFour.add((JButton) f.stringFour.get(fret));
            stringFive.add((JButton) f.stringFive.get(fret));
            stringSix.add((JButton) f.stringSix.get(fret));

        }

        s.getChord(chordRoot);

    }


    /*
    MAIN
    MAIN
    MAIN
    MAIN
     */


}
