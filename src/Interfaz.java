import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {
    public static void Start(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese tamaño de juego");
        int tamaño = input.nextInt();
        Matriz Tabla = new Matriz(tamaño);

        Tabla.nuevoNumero();
        Tabla.printearMatriz();
        Juego(Tabla);
    }
    public static int Opt(){
        boolean valido = false;
        int retorno = 0;
        while(!valido){
            try{
                Scanner input = new Scanner(System.in);
                int nuevo = input.nextInt();
                if( nuevo > 2 || nuevo<1){
                    System.out.println("Opcion no valida, ingresela nuevamente");
                }
                else{
                    valido = true;
                    retorno = nuevo;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Dato no valido, ingreselo nuevamente");
            }
        }
        return retorno;
    }

    public static void Juego(Matriz unaTabla){
        boolean perdi = unaTabla.perdio();
        Scanner input = new Scanner(System.in);
        while(!perdi){
            System.out.println("Ingrese su proximo movimiento (W,A,S,D)");
            String a = input.next();
            unaTabla.historial.agregarTablero(unaTabla.getMat());
            unaTabla.Movimientos(a);
            
            boolean sonIguales =  false;
            sonIguales = unaTabla.historial.sonIguales(unaTabla.getMat());
            //System.out.print(sonIguales);

            if(!sonIguales){
                unaTabla.historial.agregarTablero(unaTabla.getMat());
                perdi = unaTabla.perdio();
                unaTabla.nuevoNumero();
            }

        
            unaTabla.printearMatriz();
            //asdajdsjad 
        }
    }
}
