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
 *
 * @author Boulanger
 */
public class GUIPgm extends JFrame {
    private JPanel contentPanel;
    
    public GUIPgm(){
        super("Modification PGM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        contentPanel=(JPanel)this.getContentPane();
        contentPanel.setLayout(new GridLayout(2,2));
        createButtons();
        this.setVisible(true);
    }
    
    private void createButtons(){
        
        JButton seuillageButton = new JButton("Seuillage");
        seuillageButton.addActionListener((e)->Seuillage());
        
        
        JButton differenceButton = new JButton("Différence");
        differenceButton.addActionListener((e)->Difference());
        
        JButton agrandissementButton = new JButton("Agrandissement");
        agrandissementButton.addActionListener((e)->Aggrandissement());
        
        JButton reductionButton = new JButton("Reduction");
        reductionButton.addActionListener((e)->Reduction());
        
        contentPanel.add(seuillageButton);
        contentPanel.add(differenceButton);
        contentPanel.add(agrandissementButton);
        contentPanel.add(reductionButton);
        
        
    }
    
    //TODO
    private void Seuillage(){
        GUISeuillage GI = new GUISeuillage(this);
    }
    
    //TODO
    private void Difference(){
        
    }
    
    //TODO
    private void Aggrandissement(){
        
    }
    
    //TODO
    private void Reduction(){
        
    }
    
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        GUIPgm gui= new GUIPgm();
    }
    
}
