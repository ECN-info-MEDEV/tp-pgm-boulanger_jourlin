/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

/**
 *
 * @author Louis
 */
public class LouisTest {
    
    public static void main(String[] args) throws Exception{
        
        PGM baboon = PGM.lecture("C:\\Users\\Louis\\Desktop\\Centrale\\INFO\\MEDEV\\baboon.pgm");
        
        PGM baboon_binarise = PGM.seuillage(baboon, 127);
        PGM.enregistrement(baboon_binarise, "C:\\Users\\Louis\\Desktop\\Centrale\\INFO\\MEDEV\\baboon_binarise.pgm");
        
        PGM baboon_reduit = PGM.reduction(baboon, 2);
        PGM.enregistrement(baboon_reduit, "C:\\Users\\Louis\\Desktop\\Centrale\\INFO\\MEDEV\\baboon_reduit.pgm");

        PGM baboon_augmente = PGM.agrandissement(baboon, 2);
        PGM.enregistrement(baboon_augmente, "C:\\Users\\Louis\\Desktop\\Centrale\\INFO\\MEDEV\\baboon_augmente.pgm");
        
        PGM pas_baboon = PGM.difference(baboon, baboon);
        PGM.enregistrement(pas_baboon, "C:\\Users\\Louis\\Desktop\\Centrale\\INFO\\MEDEV\\pas_baboon.pgm");
        
        PGM baboons_moins_binaire = PGM.difference(baboon, baboon_binarise);
        PGM.enregistrement(baboons_moins_binaire, "C:\\Users\\Louis\\Desktop\\Centrale\\INFO\\MEDEV\\baboon_moins_coins.pgm");
        
    }
    
}
