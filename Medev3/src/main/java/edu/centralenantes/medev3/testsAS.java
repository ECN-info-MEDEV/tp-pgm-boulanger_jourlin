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
public class testsAS {
    public static void main(String[] args) throws IOException {
        PGM pgm = PGM.lecture("C:\\Users\\Boulanger\\Downloads\\baboon.pgm");
        System.out.println(pgm.getDimX());
        System.out.println(pgm.getDimY());
        System.out.println(pgm.getPixels()[0][0]);
        System.out.println(pgm.getPixels()[1][0]);
        pgm= PGM.histogramme(pgm);
        PGM.enregistrement(pgm, "TesthistBABOON.pgm");
    }
}
