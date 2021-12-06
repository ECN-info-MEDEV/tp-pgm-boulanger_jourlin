/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import java.io.IOException;

/**
 *
 * @author asjou
 */
public class testHistogramme {
    public static void main(String[] args) throws IOException {
        PGM pgm = PGM.lecture("C:\\Users\\asjou\\Documents\\Documents\\Info\\MEDEV\\Travail avec Netbeans-20211202\\Images Test PGM\\coins.pgm");
        PGM toHisto =PGM.histogramme(pgm);
        PGM.enregistrement(toHisto, "TestHistoCoin.pgm");
    }
}
