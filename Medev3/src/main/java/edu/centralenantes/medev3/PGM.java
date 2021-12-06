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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Classe gérant les fichiers PGM
 * @author asjou
 */
public class PGM {
    
    /**
     * Le tableau des niveaux de gris de chaque pixel de l'image
     */
    private int[][] pixels;
    /**
     * La dimension en X de l'image
     */
    private int dimX;
    /**
     * La dimension en Y de l'image
     */

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
    
    /**
     * Méthode statique qui renvoie l'histogramme d'un fichier PGM placé en entrée
     * @param pgmOrigine
     * @return
     */
    public static PGM histogramme(PGM pgmOrigine){
        int[] nbPixels = new int[256];
        for(int i=0; i<pgmOrigine.getDimX();i++){
            for (int j = 0; j < pgmOrigine.getDimY(); j++) {
                nbPixels[pgmOrigine.getPixels()[i][j]]+=1;
            }
        }
        int maxValue = Arrays.stream(nbPixels).max().getAsInt();
        PGM pgmHisto = new PGM(maxValue,256);
        for (int i = 0; i < maxValue; i++) {
            for(int j = 0 ; j<256 ; j++){
                if(maxValue-i>nbPixels[j]){
                    pgmHisto.getPixels()[i][j]=255;
                }
                else{
                    pgmHisto.getPixels()[i][j]=0;
                }
            }
        }
        return pgmHisto;
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
     * Méthode statique qui permet de lire un fichier PGM qui se trouve à l'emplacement indiqué en paramètre
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static PGM lecture(String path) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        
        String line = bf.readLine();
        
        line = bf.readLine(); //On supprime "P2" et on passe à la suivante (on suppose que cette méthode n'est lancée que sur un fichier du bon type, ce sera vérifié ailleurs)
        line = bf.readLine(); //On supprime "#" et on passe à la suivante, avec les dimensions
        StringTokenizer sT = new StringTokenizer(line, " ");
        int dim2= Integer.valueOf(sT.nextToken());
        int dim1= Integer.valueOf(sT.nextToken());
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
    

    /**
     * Méthode statique qui enregistre l'élément de la classe PGM placé en entrée dans un fichier nommé suivant le String en entrée
     * @param pgm
     * @param nomFichier
     * @throws IOException
     */
    public static void enregistrement(PGM pgm, String nomFichier) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichier+".pgm"));
        //Lignes indiquant le type de fichier
        bw.write("P2\n#\n");
        //Entrer la taille de l'image
        bw.write(pgm.getDimX() + " " + pgm.getDimY() + "\n");
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
                j++;
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
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
     * Fonction qui calcul la différence des niveaux de gris de deux images
     * @param image1 
     * @param image2
     * @return L'image différence
     * @throws java.lang.Exception
     */
    public static PGM difference(PGM image1, PGM image2) throws Exception{
        
        if( !(image1.getDimX()==image2.getDimX()) || !(image1.getDimY()==image2.getDimY()) ){
            throw new Exception();
        }
        else
        {
            int[][] niveaux_gris_difference = new int[image1.getDimX()][image1.getDimY()];

            for(int i = 0; i < image1.getDimX(); i++){
                for(int j = 0; j < image1.getDimY(); j++){
                    int diff = image1.getPixels()[i][j] - image2.getPixels()[i][j];
                    if (diff < 0){
                        diff = 0;
                    }
                    niveaux_gris_difference[i][j] = diff;
                }
            }

            PGM image_diff = new PGM(image1.getDimX(), image1.getDimY());
            image_diff.setPixels(niveaux_gris_difference);

            return image_diff;
        }
    }
    
    /**
     * Fonction pour réduire la taile d'une image d'un facteur donné
     * @param image L'image à réduire
     * @param facteur Le facteur de réduction
     * @return L'image réduite
     */
    public static PGM reduction(PGM image, int facteur){
        int tailleX = (int)(image.getDimX()/facteur);
        int tailleY = (int)(image.getDimY()/facteur);
        int[][] niveaux_gris_reduits = new int[tailleX][tailleY];
        
        for(int i = 0; i < tailleX; i++){
            for(int j = 0; j < tailleY; j++){
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
            for(int j = 0; j < image.getDimY(); j++){
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
