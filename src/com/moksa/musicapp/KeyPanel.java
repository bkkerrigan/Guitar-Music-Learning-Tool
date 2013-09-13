package com.moksa.musicapp;

import javax.swing.*;
import java.awt.event.*;

public class KeyPanel extends JPanel{

    Theory theory;

    private ButtonGroup bg;
    private JRadioButton keyA, keyASharp, keyB, keyC, keyCSharp, keyD, keyDSharp, keyE, keyF, keyFSharp, keyG, keyGSharp;

    public KeyPanel(Theory t){

        theory = t;
        bg = new ButtonGroup();
        RadioListener keyListener = new RadioListener();

        keyA = new JRadioButton("A");
        keyASharp = new JRadioButton("A#");
        keyB = new JRadioButton("B");
        keyC = new JRadioButton("C");
        keyCSharp = new JRadioButton("C#");
        keyD = new JRadioButton("D");
        keyDSharp = new JRadioButton("D#");
        keyE = new JRadioButton("E");
        keyF = new JRadioButton("F");
        keyFSharp = new JRadioButton("F#");
        keyG = new JRadioButton("G");
        keyGSharp = new JRadioButton("G#");

        keyA.addActionListener(keyListener);
        keyASharp.addActionListener(keyListener);
        keyB.addActionListener(keyListener);
        keyC.addActionListener(keyListener);
        keyCSharp.addActionListener(keyListener);
        keyD.addActionListener(keyListener);
        keyDSharp.addActionListener(keyListener);
        keyE.addActionListener(keyListener);
        keyF.addActionListener(keyListener);
        keyG.addActionListener(keyListener);
        keyGSharp.addActionListener(keyListener);


        bg.add(keyA);
        bg.add(keyASharp);
        bg.add(keyB);
        bg.add(keyC);
        bg.add(keyCSharp);
        bg.add(keyD);
        bg.add(keyDSharp);
        bg.add(keyE);
        bg.add(keyF);
        bg.add(keyFSharp);
        bg.add(keyG);
        bg.add(keyGSharp);

        add(keyA);
        add(keyASharp);
        add(keyB);
        add(keyC);
        add(keyCSharp);
        add(keyD);
        add(keyDSharp);
        add(keyE);
        add(keyF);
        add(keyFSharp);
        add(keyG);
        add(keyGSharp);





    }

    private class RadioListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            theory.setRoot(e.getActionCommand());

        }

    }


}