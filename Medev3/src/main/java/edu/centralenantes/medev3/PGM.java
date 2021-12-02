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
    
    public PGM seuillage(PGM image, int seuil){
        int[][] niveaux_gris_seuilles = new int[image.getDimX()][image.getDimY()];
        
        for(int i = 0; i < dimX; i++){
            for(int j = 0; j < dimY; j++){
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
    
}
