/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * Classe GUISeuillage qui va afficher la fenêtre de dialogue permettant de choisir une image, un seuil et
 * d'enregistrer le résultat du seuillage de l'image 
 * @author Boulanger
 */
public class GUISeuillage extends JDialog{
    private PGM imageOld;
    private PGM imageNew;
    private String path;
    private JTextField seuilText;
    private JLabel imageLabel;
    
    /**
     * Constructeur de GUISeuillage qui affiche le JDialog et initialise toutes les fonctionnalités
     * @param pgm 
     */
    public GUISeuillage(GUIPgm pgm){
        super(pgm,"Seuillage d'une image",true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,200);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        
        //  GESTION DU SEUIL    \\
        JPanel paneSeuil= new JPanel();
        JLabel seuilLabel = new JLabel("Définir le seuil (entre 0 et 255)");
        seuilText = new JTextField("insérer un nombre ici");
        
        JLabel txtImageLabel=new JLabel("L'image choisie est au chemin d'accès suivant :");
        imageLabel = new JLabel(path);
        
       
    
        paneSeuil.add(seuilLabel);
        paneSeuil.add(seuilText);
        paneSeuil.add(txtImageLabel);
        paneSeuil.add(imageLabel);    
        // GESTION DU CHARGEMENT DE L IMAGE \\
        
        JButton imageButton = new JButton("Selection de l'image");
        imageButton.addActionListener((e)->{
            try {
                ajoutImage();
            } catch (IOException ex) {
                Logger.getLogger(GUISeuillage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((e)->{
            try {
                Enregistrer();
            } catch (IOException ex) {
                Logger.getLogger(GUISeuillage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        JButton appliquerSeuillage = new JButton("Lancer le seuillage");
        appliquerSeuillage.addActionListener((e)->Seuillage());
        JPanel paneButton = new JPanel();
        paneButton.add(imageButton);
        paneButton.add(enregistrerButton);
        paneButton.add(appliquerSeuillage);
        
        contentPane.add(paneSeuil);
        contentPane.add(paneButton);
        this.setVisible(true);
    }
    
    /**
     * Méthode permettant d'ajouter une image à l'utilisateur et de la stockée dans oldImage (appui bouton)
     */
    private void ajoutImage() throws IOException{
        JFileChooser choix = new JFileChooser("Choisir une image");
        FileFilter imagesFilter = new FileNameExtensionFilter("Images","pgm");
        choix.setFileFilter(imagesFilter);
        int retour = choix.showOpenDialog(this);

        if(retour ==JFileChooser.APPROVE_OPTION){
            //Chargement de l'image
            path=choix.getSelectedFile().getAbsolutePath();
            imageLabel.setText(path);
            imageOld=PGM.lecture(choix.getSelectedFile().getAbsolutePath());
        }
    }
    
    /**
     * Méthode permettant à l'utilisateur de sauvegarder l'image résultante sous un nom qu'il choisi (appui bouton)
     */
    private void Enregistrer() throws IOException{
        String inputValue = JOptionPane.showInputDialog("Indiquer le nom du fichier");
        PGM.enregistrement(imageNew,inputValue);
    }
    
    /**
     * Méthode qui appliquer le seuillage sur l'image et remplacer imageNew (appui bouton)
     */
    private void Seuillage(){
        imageNew=PGM.seuillage(imageOld,Integer.parseInt(seuilText.getText()));
    }
}
