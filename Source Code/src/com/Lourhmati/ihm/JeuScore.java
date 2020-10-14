/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lourhmati.ihm;

import com.Lourhmati.ihm.JeuMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.lightGray;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.Lourhmati.thread.JeuThread;

/**
 * La classe JeuScore qui est un JPanel contient simplement un label, ou sera
 * affiche le resultat a chaque tour.
 *
 * @author 1739188 Oussama Lourhmati
 */
public class JeuScore extends JPanel {

    public JLabel labelScore;
    private JeuMenu menu;
    public int chance;
    private JeuThread jeuThread;

    /**
     * Constructeur qui instancie le labelScore initial, dans lequel le resultat
     * initial est affiche.
     *
     * @param aucun
     */
    public JeuScore() {

        labelScore = new JLabel("Tour " + chance + "/0. Score actuel: 0");
        add(labelScore, BorderLayout.NORTH);
        this.setBackground(new java.awt.Color(51, 153, 255));
        labelScore.setForeground(Color.white);

    }

}
