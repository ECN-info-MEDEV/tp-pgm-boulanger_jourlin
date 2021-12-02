/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

/**
 *
 * @author asjou
 */
public class PGM {
    public int[][] pixels;
    public int dimX;
    public int dimY;

    public int[][] getPixels() {
        return pixels;
    }

    public void setPixels(int[][] pixels) {
        this.pixels = pixels;
    }

    public int getDimX() {
        return dimX;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    public PGM(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.pixels = new int[dimX][dimY];
    }
    
    public PGM(PGM image){
        this.dimX = image.getDimX();
        this.dimY = image.getDimY();
        this.pixels = new int[dimX][dimY];
        for(int i = 0; i < dimX; i++){
            for(int j = 0; j < dimY; j++){
                this.pixels[i][j] = image.getPixels()[i][j];
            }
        }
    }
    
    /**
     * Fonction qui effectue une binarisation d'une image à partir d'un seuil
     * Les valeurs de gris supérieures ou égales au seuil vont devenir blanche
     * Les valeurs inférieures vont devenir noires
     * @param image L'image qui va être binarisée
     * @param seuil Le seuil sur lequel se base la comparaison
     * @return L'image binarisée
     */
    public static PGM seuillage(PGM image, int seuil){
        int[][] niveaux_gris_seuilles = new int[image.getDimX()][image.getDimY()];
        
        for(int i = 0; i < image.getDimX(); i++){
            for(int j = 0; j < image.getDimY() ; j++){
                if(image.getPixels()[i][j] < seuil){
                    niveaux_gris_seuilles[i][j] = 0;
                }
                else{
                    niveaux_gris_seuilles[i][j] = 255;
                }
            }
        }
        
        PGM new_image = new PGM(image.getDimX(), image.getDimY());
        new_image.setPixels(niveaux_gris_seuilles);
        
        return new_image;
    }
    
    /**
     * Fonction pour réduire la taile d'une image d'un facteur donné
     * @param image L'image à réduire
     * @param facteur Le facteur de réduction
     * @return L'image réduite
     */
    public static PGM reduction(PGM image, int facteur){
        int tailleX = (int)image.getDimX()/facteur;
        int tailleY = (int)image.getDimY()/facteur;
        int[][] niveaux_gris_reduits = new int[tailleX][tailleY];
        
        for(int i = 0; i < tailleX; i++){
            for(int j = 0; i < tailleY; j++){
                int moyenne = 0;
                for(int k = 0; k < facteur; k++){
                    for(int l = 0; l < facteur; l++){
                        moyenne += image.getPixels()[facteur * i + k][facteur * j + l];
                    }
                }
                moyenne = (int)(moyenne / (facteur * facteur));
                niveaux_gris_reduits[i][j] = moyenne;
            }
        }
        
        PGM image_reduite = new PGM(tailleX, tailleY);
        image_reduite.setPixels(niveaux_gris_reduits);
        
        return image_reduite;    
    }
    
    /**
     * Fonction qui agrandit une image donnée d'un facteur donné
     * @param image L'image à agrandir
     * @param facteur Le facteur d'agrandissement
     * @return L'image agrandie
     */
    public static PGM agrandissement(PGM image, int facteur){
        int tailleX = image.getDimX() * facteur;
        int tailleY = image.getDimY() * facteur;
        int[][] niveaux_gris_agrandis = new int[tailleX][tailleY];
        
        for(int i = 0; i < image.getDimX(); i++){
            for(int j = 0; i < image.getDimY(); j++){
                for(int k = 0; k < facteur; k++){
                    for(int l = 0; l < facteur; l++){
                        niveaux_gris_agrandis[facteur * i + k][facteur * j + l] = image.getPixels()[i][j];
                    }
                }
            }
        }
        
        PGM image_agrandie = new PGM(tailleX, tailleY);
        image_agrandie.setPixels(niveaux_gris_agrandis);
        
        return image_agrandie;
    }
}
