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
    
    
}
