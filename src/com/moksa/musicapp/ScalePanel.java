package com.moksa.musicapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScalePanel extends JPanel{


    Theory theory;

    int[] selectedScale;

    private ButtonGroup bg;
    private JRadioButton majorScale;
    private JRadioButton minorScale;


    public ScalePanel(Theory t){

        theory = t;
        bg = new ButtonGroup();
        RadioListener scaleListener = new RadioListener();

        majorScale = new JRadioButton("Major Scale");
        minorScale = new JRadioButton("Minor Scale");

        majorScale.addActionListener(scaleListener);
        minorScale.addActionListener(scaleListener);

        bg.add(majorScale);
        bg.add(minorScale);

        add(majorScale);
        add(minorScale);

    }

    private class RadioListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            theory.setScale(e.getActionCommand());

        }

    }
}
