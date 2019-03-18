import java.util.Scanner;

/**
 * Esta es nuestra clase Reinas, aqui vamos a elaborar toda la logica del codigo
 * esta clase tambien contiene al main, donde se ejecuta el algoritmo
 */
public class Reinas{
    /**
     * Creacion de un array de enteros, donde almacenaremos el tablero
     */
    int [] tablero;

    /**
     * Constructor de la clase encargado de crear un tablero.
     * @param n
     */
    public Reinas(int n){
        tablero=new int[n];
        nReinas(n,tablero,0);
    }

    /**
     * Este metodo es el encargado de preguntar arreglo por arreglo 
     * para poder situar a cada una de las reinas en el tablero
     * @param n
     * @param tablero
     * @param c
     * @return boolean
     */
    private static boolean nReinas(int n, int []tablero, int c){
        if (c == n) {
            return false;
        }
        boolean impresion = false;
        while(true) {
                if (tablero[c] < n) {
                    tablero[c] = tablero[c] + 1;
                }
                if (seAtacanHastaIoNo(tablero, c)) {
                    if (c != n - 1) {
                        impresion = nReinas(n, tablero, c+1);
                        if (impresion==false) {
                            tablero[c + 1] = 0;
                        }
                    } else {
                        impresion = true;
                    }
                }
                if ((tablero[c] == n) || (impresion == true)) { 
                    break;
                }
            }
        return impresion;
    }

    /**
     * Este metodo esta encargado de comprobar si tablero(nuestro vector),
     * es un posible lugar "seguro", es decir, si la reina puede estar en
     * esa posicion, y que no este en amenaza
     */
    public static boolean seAtacanHastaIoNo(int[] tablero, int elI){
        for(int i = 0; i < elI; i++){
				if(Math.abs(tablero[i]-tablero[elI])==Math.abs(i-elI) || (tablero[i] == tablero[elI])){
                    return false;}
        }
        return true;
    }

    /**
     * Este metodo es el encargado de imprimir el tablero
     * es una de las posibles soluciones para el problema, 
     * recibe el numero de reinas por medio de scanner y 
     * si se coloca un numero invalido se pide de nuevo 
     * este numero
     */
    public static void imprimirTablero(){
        Scanner numero = new Scanner(System.in);
        System.out.print("Digite el numero de reinas: ");
        int num = numero.nextInt();
        if((num==1) || (num>=4)){
            Reinas objeto = new Reinas(num);
            int n = objeto.tablero.length;
		    System.out.print("\n    ");
		    for(int i=0;i<n;++i){
                System.out.print(i+" ");
            }
	        System.out.println("\n");
		    for (int i = 0; i < n; ++i) {
			    System.out.print(i + "   ");
			    for (int j = 0; j < n; ++j){
				    System.out.print((objeto.tablero[i] == j+1 ? "Q" : "#") + " ");}
			    System.out.println();
		    }
		System.out.println();
        }
        else{
            System.out.println("Error: Numero invalido de Reinas");
            imprimirTablero();
        }
    }
    
    /**
     * Este es nuestro metodo principal, es el encargado de ejecutar
     * todo nuestro algoritmo! :D
     * @param args
     */
    public static void main(String[] args){
        imprimirTablero();
    }
}

