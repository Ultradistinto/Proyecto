import java.util.ArrayList;

public class Historial {
    private ArrayList<int[][]> listaHistorial;


    public void crearLista(){
        listaHistorial = new ArrayList<int[][]>();
    }

    public void agregarTablero(int[][] mat){
        int [][] mate = new int[mat.length][mat.length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                mate[i][j] = mat[i][j];
            }
        }
        listaHistorial.add(mate);
    }

    public ArrayList<int[][]> getLista(){
        return listaHistorial;
    }

    public Historial(){
        crearLista();   
    }

    public boolean sonIguales(int[][] mat1){
        boolean flag = true;
        int[][] mat2 = this.listaHistorial.get(this.listaHistorial.size() - 1);
        for(int i = 0; i < mat1.length; i++){
            for(int j = 0; j < mat1.length; j++){
                if(mat1[i][j] != mat2[i][j]){
                    flag = false;
                }
            }
        }
        return flag;
    }
}
