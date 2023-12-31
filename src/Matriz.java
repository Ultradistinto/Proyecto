import java.util.ArrayList;
import java.util.Random;

public class Matriz {
    private int[][] mat;
    public Historial historial;
    

    public void crearMat(int numero){
        mat = new int[numero][numero];
    }

    public int[][] getMat(){
        return this.mat;
    }

    public void iniciarHistorial(){
        historial = new Historial();
    }

    public Matriz(int numero){
        crearMat(numero);
        iniciarHistorial();

    }


    public void nuevoNumero(){
        ArrayList<Integer> ubiCeros = new ArrayList<Integer>();
        int cantCeros;
        Random rand = new Random();
        for(int i = 0; i < this.mat.length;i++){
            for(int j = 0; j < this.mat.length;j++){
                if(this.mat[i][j] == 0){
                    ubiCeros.add(i);
                    ubiCeros.add(j);
                }   
            }
        }
        cantCeros = ubiCeros.size();
        int int_random = rand.nextInt(cantCeros);
        int fila;
        int col;
        if(int_random%2 == 0){
            fila = ubiCeros.get(int_random);
            col = ubiCeros.get(int_random + 1);
        }
        else{
            col = ubiCeros.get(int_random);
            fila = ubiCeros.get(int_random - 1);
        }
        int dosOCuatro = rand.nextInt(10);
        int numero;

        if(dosOCuatro == 0){
            numero = 4;
        }
        else{
            numero = 2;
        }

        this.mat[fila][col] = numero;

    }

    public void Movimientos(String unMov){
        unMov = unMov.toUpperCase();
        if(unMov.equals("W")){
            for(int i = 1; i < this.mat.length;i++){
                for(int j = 0; j < this.mat.length;j++){
                    if(this.mat[i][j] != 0){
                        int k = i - 1;
                        while(k >= 0 && this.mat[k][j] == 0){
                            this.mat[k][j] = this.mat[k + 1][j];
                            this.mat[k + 1][j] = 0;
                            k--;
                        }
                        if( k >= 0 && this.mat[k][j] == this.mat[k + 1][j]){
                            this.mat[k][j] *= 2;
                            this.mat[k + 1][j] = 0;
                        }                      
                    }
                }
            }
        }

        if(unMov.equals("A")){
            for(int i = 0; i < this.mat.length; i++){
                for(int j = 1; j < this.mat.length; j++){
                    if(this.mat[i][j] != 0){
                        int k = j - 1;
                        while(k >= 0 && this.mat[i][k] == 0){
                            this.mat[i][k] = this.mat[i][k + 1];
                            this.mat[i][k + 1] = 0;
                            k--;
                        }
                        if( k >= 0 && this.mat[i][k] == this.mat[i][k + 1]){
                            this.mat[i][k] *= 2;
                            this.mat[i][k + 1] = 0;
                        }
                    }
                }
            }
        }

        if(unMov.equals("S")){
            for(int i = this.mat.length - 2; i >= 0; i--){
                for(int j = 0; j < this.mat.length; j++){
                    if(this.mat[i][j] != 0){
                        int k = i + 1; 
                        while(k < this.mat.length && this.mat[k][j] == 0){
                            this.mat[k][j] = this.mat[k - 1][j];
                            this.mat[k - 1][j] = 0;
                            k++;
                        }
                        if(k < this.mat.length && this.mat[k][j] == this.mat[k - 1][j]){
                            this.mat[k][j] *= 2;
                            this.mat[k - 1][j] = 0;
                        }
                    }
                }
            }
        }

        if(unMov.equals("D")){
            for(int i = 0; i < this.mat.length; i++){
                for(int j = this.mat.length - 2; j >= 0; j--){
                    if(this.mat[i][j] != 0){
                        int k = j + 1; 
                        while(k < this.mat.length && this.mat[i][k] == 0){
                            this.mat[i][k] = this.mat[i][k - 1];
                            this.mat[i][k - 1] = 0;
                            k++;
                        }
                        if(k < this.mat.length && this.mat[i][k] == this.mat[i][k - 1]){
                            this.mat[i][k] *= 2;
                            this.mat[i][k - 1] = 0;
                        }
                    }
                }
            }
        }
    }

    public void printearMatriz(){

        for(int i = 0; i < this.mat.length; i++){
            for(int j = 0; j < this.mat.length; j++){
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean perdio(){
        boolean perdio = true;
        for(int i = 0; i < this.mat.length && perdio; i++){
            for(int j = 0; j < this.mat.length; j++){
                if(this.mat[i][j] == 0){
                    perdio = false;
                }
                if (i + 1 < this.mat.length && this.mat[i][j] == this.mat[i + 1][j]) {
                    perdio = false;
                }

                if (j + 1 < this.mat.length && this.mat[i][j] == this.mat[i][j + 1]) {
                    perdio = false;
                }
                
                if (j - 1 >= 0 && this.mat[i][j] == this.mat[i][j - 1]) {
                    perdio = false;
                }

                if (i - 1 >= 0 && this.mat[i][j] == this.mat[i - 1][j]) {
                    perdio = false;
                }
            }
        }
        if(perdio){
            System.out.println("Perdio");
        }
        return perdio;
    }
    
    public void printearHistorial(){


        for(int k = 0; k < this.historial.getLista().size(); k++){
            ArrayList<int[][]> lista = this.historial.getLista();
            int[][] matrizLista = lista.get(k);
            for(int i = 0; i < matrizLista.length; i++){
                for(int j = 0; j < matrizLista.length; j++){
                    System.out.print(matrizLista[i][j] + " ");
                }
            System.out.println();
            }
            System.out.println("WAKALA");
            System.out.println("DIU");
        }
    }
}
