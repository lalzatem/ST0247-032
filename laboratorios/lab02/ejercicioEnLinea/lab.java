import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.util.Pair; 
/**
 * Clase en la cual se implementan los metodos del laborotarorio 2 punto 1
 * 
 * @author Mauricio Toro, Mateo Agudelo,David Alzate Cardona, Laura Alzate Madrid
 */
public class lab {
    
    private static int numS;
    
    private static boolean puedoPonerReina(int r, int[] tablero,ArrayList<Pair<Integer,Integer>> matriz) {
 
        for(int i = 0; i < r; i++){
           if(tablero[i] == tablero[r])
               { return false;}
           if(Math.abs(tablero[i] - tablero[r]) == Math.abs(i - r))
                {return false;}
            for(Pair<Integer,Integer> n : matriz){
                if ((int)n.getKey() == tablero[r] && (int)n.getValue() ==r )
                    {return false;}
                }
        }
        return true;
    }
    
    public static void nReinas(int n,ArrayList<Pair<Integer,Integer>> matriz) {
        numS = 0;
        int[] tablero = new int[n];
   
        System.out.println(nReinas(0, n, tablero,matriz));
    }
    
    private static int nReinas(int r, int n, int[] tablero,ArrayList<Pair<Integer,Integer>> matriz) {
        if (r == n){
           //imprimirTablero(tablero);
         
           numS++;
        }else{
            
            for(int i = 0; i < n; i++){
                tablero[r] = i;
                if(puedoPonerReina(r, tablero,matriz))
                    nReinas(r+1, n, tablero,matriz);
            }
        }
        return numS;
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
         
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[j] == i ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

        public static void CrearTablero() {

        try {
      
            File Archivo = new File("hola.txt");
            FileReader Arichivo2=new FileReader(Archivo);
            BufferedReader b = new BufferedReader(Arichivo2);
            String linea=b.readLine();
          ArrayList<Pair<Integer,Integer>> hola=new ArrayList<Pair<Integer,Integer>>();
             int reinas = Integer.parseInt(linea);
                 
            while (reinas!=0){
        
                hola.clear();
                   linea=b.readLine();


                    for(int i=0;i<reinas;i++){
                       for(int j=0;j<reinas;j++){ 
                           if(linea.charAt(j)=='*')
                            {
                  
                                hola.add(new Pair(i,j));
                            }   
                        
                    }
                      linea = b.readLine();
               
                }
            
            System.out.print("numero de reinas: " + reinas + " cantidad de mapas "); nReinas(reinas,hola);
            reinas = Integer.parseInt(linea);
        }
      
        } catch (IOException e) {
            System.out.println(e);
            
        } 
       
    }
}