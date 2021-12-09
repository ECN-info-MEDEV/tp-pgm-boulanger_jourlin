/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Boulanger
 */
public class PGMTest {
    
    public PGMTest() {
    }


    /**
     * Test of histogramme method, of class PGM.
     */
    @Test
    public void testHistogramme() {
        System.out.println("histogramme");
        PGM origine = new PGM(1,1);
        origine.getPixels()[0][0]=245;
        PGM sortie = new PGM(1,256);
        for(int i=0;i<256;i++){
            if(i!=245){
                sortie.getPixels()[0][i]=255;
            }
        }
        PGM histo =PGM.histogramme(origine);
        System.out.println(histo.getPixels()[0][245]);
        Assert.assertArrayEquals(sortie.getPixels(), histo.getPixels());
    }

    /**
     * Test of lecture method, of class PGM.
     */
    @Test
    public void testLecture() throws Exception {
        System.out.println("lecture");
        String path = "";
        PGM expResult = null;
        PGM result = PGM.lecture(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enregistrement method, of class PGM.
     */
    @Ignore
    @Test
    public void testEnregistrement() throws Exception {
        System.out.println("enregistrement");
        PGM pgm = null;
        String nomFichier = "";
        PGM.enregistrement(pgm, nomFichier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seuillage method, of class PGM.
     */
    @Ignore
    @Test
    public void testSeuillage() {
        System.out.println("seuillage");
        PGM image = null;
        int seuil = 0;
        PGM expResult = null;
        PGM result = PGM.seuillage(image, seuil);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class PGM.
     */
    @Ignore
    @Test
    public void testDifference() throws Exception {
        System.out.println("difference");
        PGM image1 = null;
        PGM image2 = null;
        PGM expResult = null;
        PGM result = PGM.difference(image1, image2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduction method, of class PGM.
     */
    @Ignore
    @Test
    public void testReduction() {
        System.out.println("reduction");
        PGM image = null;
        int facteur = 0;
        PGM expResult = null;
        PGM result = PGM.reduction(image, facteur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agrandissement method, of class PGM.
     */
    @Ignore
    @Test
    public void testAgrandissement() {
        System.out.println("agrandissement");
        PGM image = null;
        int facteur = 0;
        PGM expResult = null;
        PGM result = PGM.agrandissement(image, facteur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
