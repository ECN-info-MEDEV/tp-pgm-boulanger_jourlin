/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author asjou
 */
public class PGM {
    private int[][] pixels;
    private int dimX;
    private int dimY;

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
    
    public static PGM lecture(String path) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        
        String line = bf.readLine();
        
        line = bf.readLine(); //On supprime "P2" et on passe à la suivante (on suppose que cette méthode n'est lancée que sur un fichier du bon type, ce sera vérifié ailleurs)
        line = bf.readLine(); //On supprime "#" et on passe à la suivante, avec les dimensions
        StringTokenizer sT = new StringTokenizer(line, " ");
        int dim1= Integer.valueOf(sT.nextToken());
        int dim2= Integer.valueOf(sT.nextToken());
        PGM pgm = new PGM(dim1, dim2);
        
        line = bf.readLine(); //On supprime "255" et on passe à la suivante, avec les pixels
        
        //Construction du tableau avec les pixels
        Queue<Integer> q = new LinkedList<>();
        
        //On lit le fichier
        line = bf.readLine();
        while(line!=null){
            sT = new StringTokenizer(line, " ");
            while(sT.hasMoreTokens()) {
                q.add(Integer.valueOf(sT.nextToken()));
            }
            line = bf.readLine();
        }
        //On remplit le tableau pixels
        for(int i = 0; i<dim1; i++){
            for(int j =0; j<dim2; j++){
                try{
                    pgm.getPixels()[i][j]=q.remove();
                }
                catch (NoSuchElementException exception){
                    System.out.println("Il n'y a pas de pixel trouvé pour la position "+ i + ";" + j);
                    pgm.getPixels()[i][j]=255;
                }
            }
        }
        return pgm;
    }
    
    public static void enregistrement(PGM pgm, String nomFichier) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichier));
        //Lignes indiquant le type de fichier
        bw.write("P2\n#\n");
        //Entrer la taille de l'image
        bw.write(pgm.getDimX() + " " + pgm.getDimY());
        //Le plus sombre :
        bw.write("255\n");
        //Entrer les lignes, en veillant à la contrainte de 70 caractères
        for(int i = 0; i<pgm.getDimX(); i++){
            int j=0;
            int k=0; //Compteur pour contrainte 70 caractères (on a choisit de rentrer 12 valeurs par ligne au maximum
            while(j<pgm.getDimY()){
                if(k<12){
                    bw.write(pgm.getPixels()[i][j]+" ");
                    k++;
                }
                else{
                    bw.write("\n"+pgm.getPixels()[i][j]+" ");
                    k=1;
                }
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}
