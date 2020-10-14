/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lourhmati.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.Lourhmati.thread.JeuThread;
import javax.swing.UIManager;

/**
 * La classe JeuMenu contient mon menu, avec démarrer et quitter. Ajout des
 * ActionListener sur chaque menuItem. Finalement, ajout du menu, menuDemarrer
 * et menuQuitter avec add.
 *
 * @author 1739188 Oussama Lourhmati
 */
public class JeuMenu extends JMenuBar {

    private JMenu menu;
    private JMenuItem menuDemarrer;
    private JMenuItem menuQuitter;
    private JeuPanel jeuPanel;
    private JeuThread jeuThread;
    private JeuScore jeuScore;

    /**
     * Constructeur vide
     */
    public JeuMenu() {
    }

    /**
     * Constructeur avec paramètres qui va contenir l'ensemble des menu, et ma
     * méthode InitaliserMenu().
     *
     * @param titre,jeuPanel,jeuScore
     */
    public JeuMenu(String titre, JeuPanel jeuPanel, JeuScore jeuScore) {
        this.jeuPanel = jeuPanel;
        this.jeuScore = jeuScore;
        this.menu = new JMenu("Menu");
        this.setBackground(new java.awt.Color(51, 153, 255));
        menu.setForeground(Color.white);
        initialiserMenu();
        add(menu);
        menu.add(menuDemarrer);
        menu.add(menuQuitter);
    }

    /**
     * Méthode qui va tout simplement initialiser mon menu, avec démarrer et
     * quitter. Ajout des ActionListener sur les boutons du menu. Dans le
     * démarrer, le thread va commencer.
     *
     * @param aucun
     */
    private void initialiserMenu() {
        //Démarrer
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        this.menuDemarrer = new JMenuItem("Démarrer");
        menuDemarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = true, commencerThread = true;

                while (b) {
                    try {
                        String message
                                = JOptionPane.showInputDialog("Combien de chances voulez-vous avoir?", 15);
                        if (message == null) {
                            message = "0";
                        }
                        jeuScore.chance = Integer.parseInt(message);
                        b = false;
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Entrez un nombre.");
                        b = true;
                    }
                    if (jeuScore.chance < 0) {
                        JOptionPane.showMessageDialog(null, "Entrez un nombre positif.");
                    }
                    if (jeuScore.chance == 0) {
                        b = false;
                        commencerThread = false;
                    }
                }
                if (commencerThread) {
                    jeuPanel.score = 0;
                    jeuThread = new JeuThread(jeuScore.chance, jeuPanel, jeuScore);
                    jeuThread.start();
                }

            }
        });

        //Quitter
        this.menuQuitter = new JMenuItem("Quitter");
        menuQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
