import java.util.Scanner;
public class Main
{
    
    /**
     * Clase principal donde se ejecuta el programa.
     * @param args
     */
    public static void main(String[] args) {
        Scanner Teclado=new Scanner(System.in);
        int a=Teclado.nextInt();
        int b=Teclado.nextInt();
        nodos hola = new nodos(a,b);
        hola.pares();
       
        hola.coloreado();
       
    }
}
