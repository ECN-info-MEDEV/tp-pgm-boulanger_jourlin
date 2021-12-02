/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
  * Classe GUIReduction qui va afficher la fenêtre de dialogue permettant de choisir une image, un facteur de reduction et
 * d'enregistrer le résultat du seuillage de l'image 
 * @author Boulanger
 */
public class GUIReduction extends JDialog {
        //private PGM imageOld;
    //private PGM imageNew;
    private String path;
    private JTextField seuilText;
    private JLabel imageLabel;
    
    /**
     * Constructeur de GUISeuillage qui affiche le JDialog et initialise toutes les fonctionnalités
     * @param pgm 
     */
    public GUIReduction(GUIPgm pgm){
        super(pgm,"Réduction d'une image",true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,200);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        
        //  GESTION DU SEUIL    \\
        JPanel paneSeuil= new JPanel();
        JLabel seuilLabel = new JLabel("Définir le coeff de réduction");
        seuilText = new JTextField("insérer un entier ici");
        
        JLabel txtImageLabel=new JLabel("L'image choisie est au chemin d'accès suivant :");
        imageLabel = new JLabel(path);
        
       
    
        paneSeuil.add(seuilLabel);
        paneSeuil.add(seuilText);
        paneSeuil.add(txtImageLabel);
        paneSeuil.add(imageLabel);    
        // GESTION DU CHARGEMENT DE L IMAGE \\
        
        JButton imageButton = new JButton("Selection de l'image");
        imageButton.addActionListener((e)->ajoutImage());
        
        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((e)->Enregistrer());
        
        JButton appliquerReduction = new JButton("Lancer la réduction");
        appliquerReduction.addActionListener((e)->Reduction());
        JPanel paneButton = new JPanel();
        paneButton.add(imageButton);
        paneButton.add(enregistrerButton);
        paneButton.add(appliquerReduction);
        
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
            //image=PGM.lecture(choix.getSelectedFile().getAbsolutePath());
        }
    }
    /**
     * Méthode permettant à l'utilisateur de sauvegarder l'image résultante sous un nom qu'il choisi (appui bouton)
     */    
    private void Enregistrer(){
        String inputValue = JOptionPane.showInputDialog("Indiquer le nom du fichier");
        //PGM.enregistrement(newImage,inputValue);
    }
    
    /**
     * Méthode qui appliquer la réduction sur l'image et remplacer imageNew (appui bouton)
     */    
    private void Reduction(){
        //imageNew=PGM.reduction(imageOld,Integer.parseInt(seuilText.getText()));
    }
}
