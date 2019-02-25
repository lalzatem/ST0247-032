import java.util.ArrayList;
/**
 * camino hamiltoniano por feurza bruta
 * 
 * @author David Alzate Cardona, Laura Alzate Madrid 
 * 
 */
public class Recorrido
{
public static int hayCamino2(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux2(g, o, d, visitados, 0);
    }
  /**
    * Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
    * se quiere encontrar el de menor costo
    * @param g grafo dado 
    * @param o nodo desde el cual empieza el recorrido 
    * @param d nodo donde termina el recorrido
    * @param visitados este verifica si ya fue o no visitado el nodo
    * @param v  este valdia si ya se pasó por todos los nodos
    * @return cual es el costo que tiene ir desde inicio a fin
    */
    private static int hayCaminoAux2(Digraph g, int o, int d, boolean[] visitados, int v) { 
        if(v!=visitados.length)
        {v++;}
        visitados[o] = true;
        int costoMinimo = 1000000;
                 int costoCamino=0;
        if (o == d && v==visitados.length){
        visitados[o] = false;
           return 0;
        }
        else{
           ArrayList<Integer> hijos = g.getSuccessors(o);          
                try{
                for (Integer hijo: hijos){
                if (!visitados[hijo] ||(o == d && v==visitados.length)){
                  costoCamino =g.getWeight(o,hijo)+ hayCaminoAux2(g, hijo, d, visitados, v);
                  visitados[hijo]=false;
                   if (costoCamino < costoMinimo)
                             { costoMinimo = costoCamino;}
                }
              
              
        
    
        }}
    catch(Exception e){}
}
          return costoMinimo;  
    }
 
     public static void main(String[] args) {
        DigraphAM g1 = new DigraphAM(5);
        g1.addArc(0, 1, 22);
        g1.addArc(0, 2, 42);
        g1.addArc(0, 3, 10);
        g1.addArc(1, 0, 24);
        g1.addArc(1, 2, 32);
        g1.addArc(1, 3, 12);
        g1.addArc(2, 0, 12);
        g1.addArc(2, 1, 33);
        g1.addArc(2, 3, 23);
        g1.addArc(3, 0, 12);
        g1.addArc(3, 1, 21);
        g1.addArc(3, 2, 21);

        System.out.println(hayCamino2(g1,0,0));
    }

}
