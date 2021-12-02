/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Boulanger
 */
public class GUIHistogramme extends JDialog {
    private PGM imageOld;
    private PGM imageNew;
    private String path;
    private JLabel imageLabel;
    
    /**
     * Constructeur de GUISeuillage qui affiche le JDialog et initialise toutes les fonctionnalités
     * @param pgm 
     */
    public GUIHistogramme(GUIPgm pgm){
        super(pgm,"Histogramme d'une image",true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,200);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        
        //  GESTION DU SEUIL    \\
        JPanel paneSeuil= new JPanel();
        JLabel txtImageLabel=new JLabel("L'image choisie est au chemin d'accès suivant :");
        imageLabel = new JLabel(path);
        
        paneSeuil.add(txtImageLabel);
        paneSeuil.add(imageLabel);    
        // GESTION DU CHARGEMENT DE L IMAGE \\
        
        JButton imageButton = new JButton("Selection de l'image");
        imageButton.addActionListener((e)->ajoutImage());
        
        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((e)->Enregistrer());
        
        JButton appliquerHistogramme = new JButton("Lancer l'histogramme");
        appliquerHistogramme.addActionListener((e)->Histogramme());
        JPanel paneButton = new JPanel();
        paneButton.add(imageButton);
        paneButton.add(enregistrerButton);
        paneButton.add(appliquerHistogramme);
        
        contentPane.add(paneSeuil);
        contentPane.add(paneButton);
        this.setVisible(true);
    }
    
    /**
     * Méthode permettant d'ajouter une image à l'utilisateur et de la stockée dans oldImage (appui bouton)
     */
    private void ajoutImage(){
        JFileChooser choix = new JFileChooser("Choisir une image");
        FileFilter imagesFilter = new FileNameExtensionFilter("Images","pgm");
        choix.setFileFilter(imagesFilter);
        int retour = choix.showOpenDialog(this);

        if(retour ==JFileChooser.APPROVE_OPTION){
            //Chargement de l'image
            path=choix.getSelectedFile().getAbsolutePath();
            imageLabel.setText(path);
            imageNew=PGM.lecture(choix.getSelectedFile().getAbsolutePath());
        }
    }
    
    /**
     * Méthode permettant à l'utilisateur de sauvegarder l'image résultante sous un nom qu'il choisi (appui bouton)
     */
    private void Enregistrer(){
        String inputValue = JOptionPane.showInputDialog("Indiquer le nom du fichier");
        PGM.enregistrement(ImageNew,inputValue);
    }
    
    /**
     * Méthode qui appliquer le seuillage sur l'image et remplacer imageNew (appui bouton)
     */
    private void Histogramme(){
        imageNew=PGM.histogramme(imageOld);
    }
}
