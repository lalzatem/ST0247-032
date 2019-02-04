
import java.util.Scanner;

/**
 * Esta es la clase nodos, en ella se crea la matriz del grafo para poder
 * comprobar si este puede ser bicoloreable o no.
 * @author David Alzate Cardona
 * @author Laura Alzate Madrid
 */

public class nodos
{
    private int Nnodos;
    private int aristas;
    private int primero;
    private int[][] matriz;
    private int[] matriz2;


    /**
     * Constructor de la clase, que recibe como parametros:
     * @param Nnodos
     * @param aristas
     */
   public nodos(int Nnodos, int aristas)
    {
        this.Nnodos=Nnodos;
        this.aristas=aristas;
        this.matriz=new int[Nnodos][Nnodos];
       this.matriz2=new int[Nnodos];
    }

    /**
     * Este metodo nos permite verificar que el grafo tenga al menos un nodo,
     * y que el numero de aristas sea igual al numero de nodos o 1 menos.
     * @return true o false
     */
    public boolean verificador()
    {
        if((aristas==Nnodos || aristas==Nnodos-1) && Nnodos>1){
        System.out.println("Cantidad de filas de la matriz:" + matriz.length);

System.out.println("Cantidad de elementos de la primer fila:" + matriz[0].length);
        return true;
    }
        else
        return false;
    }

    /**
     * Este metodo nos permite escribir entre cuales nodos hay un arco que
     * los une, y valida que se halla escrito una posicion valida.
     */
    public void pares()
    {
        if(verificador())
        {
        Scanner Teclado=new Scanner(System.in);
        
        for(int i=0;i<aristas;++i)
        {
            
            String a=Teclado.nextLine();
           String[] b=a.split(" ",2);
            if(b[0].equals(b[1]) || (b[0].equals("0") && b.length<1 ))
            {
            System.out.println("Posición invalida");
            System.exit(0);
            }
            int uno=Integer.parseInt(b[0]);
            int dos=Integer.parseInt(b[1]);
             if(i==0)
            {
                matriz2[uno]=-1;
                matriz2[dos]=1;
            }else{
            matriz2[uno]=1;
                matriz2[dos]=1;
            
         
        }
         matriz[uno][dos]=-1;
        }
    }
    else
    {
  
    System.exit(0);
    }
    }

    /**
     * Este metodo es el que me permite saber si el grafo es bicoloreable o no.
     * (Metodo fallando)
     */
    public void coloreado(){
   
        String coloreable="BICOLORABLE";
        String nocoloreable="NOT BICOLORABLE";
      
            int[] verdadero=new int[Nnodos];
            
          
          for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if((matriz[i][j]==-1) && (matriz2[i]!=matriz2[j])){
                        if(matriz2[i]==-1 && (matriz2[j]==8 || matriz2[j]==1)){
                            matriz2[j] = 1;
                        
                        }
                        else if(matriz2[i]==1 && (matriz2[j]==8 || matriz2[j]==-1)){
                          
                            matriz2[j] = -1;
                        }
                       else{
                         System.out.println(nocoloreable);
                          
                            break;
                        }
                    }
                }
          
        
        
            
        }
            System.out.println(coloreable);
            
    }
   
}
        
        
    
   


