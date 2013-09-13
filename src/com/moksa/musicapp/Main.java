package com.moksa.musicapp;

import javax.swing.*;

public class Main {

    public static void main(String[] args){


        Theory theory = new Theory();
        MasterPanel masterPanel = new MasterPanel(theory);

        masterPanel.setVisible(true);
        masterPanel.setResizable(false);
        masterPanel.setSize(500,300);
        masterPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
