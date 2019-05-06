 import javafx.util.Pair;
 import javafx.util.Pair; 
  import java.util.Scanner; 
 import java.util.ArrayList;
import java.lang.Double; 
 /**
 * punto 2
 * 
 * @David Alzate Cardona Y laura Alzate Madrid 
 * 
 */
public class punto2
{
 public static int movimientos(Integer x, Integer y,Integer xi, Integer yi)
 {
     int cont=0;
     if(xi<x)
     {
        while(xi!=x)
        {
            cont++;
            xi++;
        }
     }
      else if(xi>x)
     {
        while(xi!=x)
        {
            cont++;
            xi--;
        }
     }
      if(yi<y)
     {
        while(yi!=y)
        {
            cont++;
            yi++;
        }
     }
      else if(yi>y)
     {
        while(yi!=y)
        {
            cont++;
            yi--;
        }
     }
        return cont;
    }
public static Pair<Integer,Integer> menor(ArrayList<Pair<Integer,Integer>> par,Pair<Integer,Integer> inicial)
{
    Pair<Integer,Integer> pareja=par.get(0);

for(int i=1;i<par.size();i++)
{
    int comparar=Double.compare(distancia(par.get(i).getKey(),par.get(i).getValue(),inicial.getKey(),inicial.getValue()),distancia(pareja.getKey(),pareja.getValue(),inicial.getKey(),inicial.getValue()));
    if(comparar<0)   
    {
          pareja=new Pair(par.get(i).getKey(),par.get(i).getValue());

    }
}
return pareja;
}    
public static double distancia(Integer a, Integer b,Integer a2, Integer b2)
{
double x = ((a-a2)*(a-a2)+(b-b2)*(b-b2));
double c = Math.sqrt(x);
return c;
}
public static void Main(String[] args)
{
    int movimientos=0;
    ArrayList<Pair<Integer,Integer>> puntos=new ArrayList<Pair<Integer,Integer>>();
    ArrayList<Integer> resultados=new ArrayList<Integer>();
    //cantidad de matrices
    Scanner teclado=new Scanner(System.in);
    int a=teclado.nextInt();
     String fds=teclado.nextLine();//para evitar el error por salto de linea
    int cont=0;
    String cadena="";
     Pair<Integer,Integer> inicial=new Pair(0,0);
    Pair<Integer,Integer> auxInicial=inicial;
    while(cont<a)
    {//tamaño de la matriz
    String tamanomatriz=teclado.nextLine();
    String[] tamanoaux=tamanomatriz.split(" ");
 
    Pair<Integer,Integer> matriz=new Pair(Integer.parseInt(tamanoaux[0]),Integer.parseInt(tamanoaux[1]));
    if(matriz.getKey()>20 && matriz.getValue()>20)
    {matriz=new Pair(20,20);}
    else if(matriz.getKey()>20)
    {
        matriz=new Pair(20,matriz.getValue());
    }
    else if(matriz.getValue()>20)
    {
        matriz=new Pair(matriz.getKey(),20);
    }
    //punto inicial
tamanomatriz=teclado.nextLine();
    tamanoaux=tamanomatriz.split(" ");
       
   inicial=new Pair(Integer.parseInt(tamanoaux[0]),Integer.parseInt(tamanoaux[1]));
  auxInicial=inicial;
   System.out.println("punto inicial listo");
    // puntos
    int cantidadP=teclado.nextInt();
    String cadenas=teclado.nextLine();
      System.out.println("coordenadas de los desechos");
    for(int i=0; i<cantidadP;i++){      
          cadena=teclado.nextLine();
       String[] aux=cadena.split(" ");
       if(matriz.getKey()>Integer.parseInt(aux[0]) || matriz.getValue()>Integer.parseInt(aux[1]))
       {System.exit(1);}
       puntos.add(new Pair(Integer.parseInt(aux[0]),Integer.parseInt(aux[1])));   
    }
    //arralist con cada solucion
    System.out.println("fin de puntos");
    
   while(!puntos.isEmpty())
    {
    Pair<Integer,Integer> auxp=menor(puntos,inicial);
    movimientos+=movimientos(auxp.getKey(),auxp.getValue(),inicial.getKey(),inicial.getValue());
    System.out.println(movimientos);
    System.out.println(auxp);
   inicial=auxp;
    puntos.remove(inicial);
    }
    movimientos+=movimientos(inicial.getKey(),inicial.getValue(),auxInicial.getKey(),auxInicial.getValue());
    resultados.add(movimientos);
    cont++;
}


for(int i=0;i<resultados.size();i++)
{
System.out.println("Matriz["+i+"] "+resultados.get(i));
}
}

}
