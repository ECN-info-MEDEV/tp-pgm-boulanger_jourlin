/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *Classe GUIPgm, permettant d'afficher l'application qui modifie des images au format PGM
 * On peut appliquer différentes modifications (sauvegardable, sans modification du fichier)
 * réduction
 * différence
 * agrandissement
 * Seuillage
 * @author Boulanger
 */
public class GUIPgm extends JFrame {
    private JPanel contentPanel;
    /**
     * Constructeur deGUIPgm, qui va initialiser la frame et ajouter les différents boutons
     */
    public GUIPgm(){
        super("Modification PGM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        contentPanel=(JPanel)this.getContentPane();
        contentPanel.setLayout(new GridLayout(3,2));
        createButtons();
        this.setVisible(true);
    }
    
    private void createButtons(){
        
        JButton seuillageButton = new JButton("Seuillage");
        seuillageButton.addActionListener((e)->Seuillage());
        
        
        JButton differenceButton = new JButton("Différence");
        differenceButton.addActionListener((e)->Difference());
        
        JButton agrandissementButton = new JButton("Agrandissement");
        agrandissementButton.addActionListener((e)->Agrandissement());
        
        JButton reductionButton = new JButton("Reduction");
        reductionButton.addActionListener((e)->Reduction());
        
        JButton histoButton = new JButton("Histogramme");
        histoButton.addActionListener((e)->Histogramme());
        
        contentPanel.add(seuillageButton);
        contentPanel.add(differenceButton);
        contentPanel.add(agrandissementButton);
        contentPanel.add(reductionButton);
        contentPanel.add(histoButton);
        
        
    }
    
    /**
     * Méthode appelée lors de l'appuie sur le bouton Seuillage
     * cette méthode va lancer un dialogue GUISeuillage afin d'appliquer un seuillage à un image
     */
    private void Seuillage(){
        GUISeuillage GI = new GUISeuillage(this);
    }
    
   /**
    * Méthode appelée lor de l'appuien sur le bouton Difference
    * cette méthode va lancer un dialogue GUIDifference afin d'appliquer une différence sur deux images
    */
    private void Difference(){
        GUIDifference GD = new GUIDifference(this);
    }
    
    /**
     * Méthode appelée lors de l'appuie sur le bouton Aggrandissement
     * cette méthode va lancer un dialogue GUIAgrandissement afin d'appliquer un agrandissement d'une image
     */
    private void Agrandissement(){
        GUIAgrandissement GA= new GUIAgrandissement(this);
    }
    
    /**
     * Méthode appelée lors de l'appuie sur le bouton Réduction
     * cette méthode va lancer un dialogue GUIReduction afin d'appliquer une réduction à une image
     */
    private void Reduction(){
        GUIReduction GR = new GUIReduction(this);
    }
    
    /**
     * Méthode appelée lors de 
     */
    private void Histogramme(){
        GUIHistogramme GH = new GUIHistogramme(this);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        GUIPgm gui= new GUIPgm();
    }
    
}
