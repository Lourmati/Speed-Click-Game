/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lourhmati.thread;

import com.Lourhmati.ihm.JeuScore;
import com.Lourhmati.ihm.JeuPanel;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe JeuThread va demarrer le jeu en generant aleatoirement un bouton a
 * chaque tour, tout en faisant un sleep. A chaque tour, le labelScore de la
 * classe JeuScore va se mettre a jour avec un setText et le nombre de tours va
 * augmenter.
 *
 * @author 1739188 Oussama Lourhmati
 */
public class JeuThread extends Thread {

    private int chance;
    private JeuPanel jeuPanel;
    protected int nbTours;
    private JeuScore jeuScore;

    /**
     * Constructeur avec parametre, dans lequel j'instancie le tout
     *
     * @param chance, jeuPanel, jeuScore
     */
    public JeuThread(int chance, JeuPanel jeuPanel, JeuScore jeuScore) {
        this.chance = chance;
        this.jeuPanel = jeuPanel;
        this.jeuScore = jeuScore;

    }

    @Override
    public void run() {

        while (true) {

            for (int i = 0; i < chance; i++) {
                nbTours++;
                jeuPanel.genererRandom(jeuPanel.tab);

                try {
                    sleep(ThreadLocalRandom.current().nextInt(500, 1199 + 1));
                    jeuPanel.tab[jeuPanel.x][jeuPanel.y].setEnabled(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JeuThread.class.getName()).log(Level.SEVERE, null, ex);
                }

                jeuScore.labelScore.setText("Tour " + nbTours + "/"
                        + jeuScore.chance + ". Score actuel: " + jeuPanel.score);

            }
            break;

        }
    }

}
