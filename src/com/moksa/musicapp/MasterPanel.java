package com.moksa.musicapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MasterPanel extends JFrame {

    private KeyPanel key;
    private ScalePanel scale;
    private Fretboard fretboard;
    private JButton generate;
    private Theory theory;

    public MasterPanel(Theory t){

        theory = t;
        setLayout(new GridLayout(3,4));
        key = new KeyPanel(theory);
        scale = new ScalePanel(theory);
        fretboard = new Fretboard(theory);

        generate = new JButton("Generate Notes");
        generate.addActionListener(new listener());

        add(key);
        add(fretboard);
        add(scale);
        add(generate);


    }

    public class listener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            theory.generateScaleNotes();

            fretboard.repaint();

        }

    }


}