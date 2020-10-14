/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lourhmati.main;

import javax.swing.SwingUtilities;
import com.Lourhmati.ihm.MainFrame;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * La classe du main, dans lequel le jeu va demarrer.
 *
 * @author 1739188 Oussama Lourhmati
 */
public class TP1 {

    /**
     * Le main, qui va simplement creer et demarrer le mainframe, pour que le
     * jeu fonctionne.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
            }
        });
    }
}
