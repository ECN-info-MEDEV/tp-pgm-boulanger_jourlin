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
 * Classe GUIDifference qui lance un JDialog permettant de choisir deux images dont on peut calcul la différence
 * @author Boulanger
 */
public class GUIDifference extends JDialog {
    private PGM imageOld;
    private PGM imageNew;
    private PGM imageOld2;
    private String path,path2;
    private JTextField agrandText;
    private JLabel imageLabel;
    private JLabel imageLabel2;
    /**
     * Constructeur de GUIDifference
     * @param gui 
     */
    public GUIDifference(GUIPgm gui){
        super(gui,"Différence d'images",true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,200);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        
        //  GESTION DU SEUIL    \\
        JPanel paneSeuil= new JPanel();
        
        JLabel txtImageLabel=new JLabel("L'image N° 1 est au chemin d'accès suivant :");
        imageLabel = new JLabel(path);
        
       JLabel txtImageLabel2 = new JLabel("L'image n° 2 est au chemin d'accèsn suivant :");
       imageLabel2=new JLabel(path2);
    
        paneSeuil.add(txtImageLabel);
        paneSeuil.add(imageLabel);
        
        paneSeuil.add(txtImageLabel2);
        paneSeuil.add(imageLabel2);
        // GESTION DU CHARGEMENT DE L IMAGE \\
        
        JButton imageButton = new JButton("Selection de l'image n°1");
        imageButton.addActionListener((e)->ajoutImage());
        
        JButton imageButton2 = new JButton("Selection de l'image n°2");
        imageButton2.addActionListener((e)->ajoutImage2());
        
        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((e)->Enregistrer());
        
        JButton appliquerDifference = new JButton("Lancer la difference");
        appliquerDifference.addActionListener((e)->Difference());
        
        JPanel paneButton = new JPanel();
        paneButton.add(imageButton);
        paneButton.add(enregistrerButton);
        paneButton.add(imageButton2);
        paneButton.add(appliquerDifference);
        
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
            imageOld=PGM.lecture(choix.getSelectedFile().getAbsolutePath());
        }
    }
    
    /**
     * Méthode permettant d'ajouter une image à l'utilisateur et de la stockée dans oldImage2 (appui bouton)
     */    
    private void ajoutImage2(){
        JFileChooser choix = new JFileChooser("Choisir une image");
        FileFilter imagesFilter = new FileNameExtensionFilter("Images","pgm");
        choix.setFileFilter(imagesFilter);
        int retour = choix.showOpenDialog(this);

        if(retour ==JFileChooser.APPROVE_OPTION){
            //Chargement de l'image
            path2=choix.getSelectedFile().getAbsolutePath();
            imageLabel2.setText(path2);
            imageOld2=PGM.lecture(choix.getSelectedFile().getAbsolutePath());
        }
    }
    /**
     * Méthode permettant à l'utilisateur de sauvegarder l'image résultante sous un nom qu'il choisi (appui bouton)
     */  
    private void Enregistrer(){
        String inputValue = JOptionPane.showInputDialog("Indiquer le nom du fichier");
        PGM.enregistrement(imageNew,inputValue);
    }
    
    
    /**
     * Méthode qui calcul la difference entre deux images et la stock dans newImage
     */
    private void Difference(){
        imageNew=PGM.difference(imageOld,imageOld2)));
    }
}
