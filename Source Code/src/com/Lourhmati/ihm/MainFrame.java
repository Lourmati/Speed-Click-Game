/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lourhmati.ihm;

import com.Lourhmati.ihm.JeuScore;
import com.Lourhmati.ihm.JeuPanel;
import com.Lourhmati.ihm.JeuMenu;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * La classe MainFrame contient le panel de jeu, le menu et le panel de score.
 *
 * @author 1739188 Oussama Lourhmati
 */
public class MainFrame extends JFrame {

    private JButton button;
    private JeuPanel jeuPanel;
    private JeuMenu menu;
    private JeuScore jeuScore;

    public MainFrame() {
        super("Jeu");

        //Mon panel
        jeuPanel = new JeuPanel();
        add(jeuPanel, BorderLayout.CENTER);
        setSize(750, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Le score
        jeuScore = new JeuScore();
        add(jeuScore, BorderLayout.SOUTH);

        //Mon menu
        menu = new JeuMenu("Menu", jeuPanel, jeuScore);
        add(menu, BorderLayout.NORTH);

        setVisible(true);

    }

}
