/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lourhmati.ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * La classe JeuPanel contient les boutons du jeu, sous forme de tableau. Ajout
 * d'un GridLayout, et d'un ActionListener sur les boutons (avec la méthode
 * buttonMethod). Avec la méthode genererRandom, generation au hasard d'un
 * boutton du tableau.
 *
 * @author 1739188 Oussama Lourhmati
 *
 */
public class JeuPanel extends JPanel {

    public JButton[][] tab;
    public int x;
    public int y;
    public int score;
    private GridLayout layout = new GridLayout(5, 5, 2, 2);

    /**
     * Constructeur qui contient la création des boutons du tableau avec une
     * boucle for, création du GridLayout et du ActionListener pour chaque
     * boutton.
     *
     * @param aucun
     */
    public JeuPanel() {
        tab = new JButton[5][5];
        setLayout(layout);
        this.setBackground(new java.awt.Color(51, 153, 255));
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = new JButton(new ImageIcon("twitter.gif"));
                tab[i][j].setEnabled(false);
                tab[i][j].setBorder(new LineBorder(Color.white));
                tab[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonMethod(e);
                    }
                });
                add(tab[i][j]);
            }
        }
    }

    /**
     * Methode pour generer aleatoirement le bouton qui sera activé et qui sera
     * a cliquer (avec setEnabled(true)).
     *
     * @param aucun
     */
    public void genererRandom(JButton[][] tab) {
        x = ThreadLocalRandom.current().nextInt(0, 4 + 1);
        y = ThreadLocalRandom.current().nextInt(0, 4 + 1);
        this.tab[x][y].setEnabled(true);
    }

    /**
     * Methode pour le actionevent, lorsque l'utilisateur clique sur le boutton,
     * le score va implementer de 1, et le boutton va se desactiver.
     *
     * @param ActionEvent e
     */
    public void buttonMethod(ActionEvent e) {
        score++;
        JButton button = (JButton) e.getSource();
        button.setEnabled(false);
    }
}
