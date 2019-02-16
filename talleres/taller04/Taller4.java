import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 4
 * 
 * @author Mauricio Toro, David Alzate, Laura Alzate
 */
public class Taller4 {

    /**
    * Metodo auxiliar para llamar el metodo hayCaminoDFS posterior
    * @param g grafo dado 
    * @param o vertices 
    * @param d vertice
    * @return true si hay camino, false de lo contrario
    */
    public static boolean hayCamino(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux(g, o, d, visitados);
    }

    /**
    * Metodo que recorre el grafo por medio de dfs 
    * @param g grafo dado 
    * @param o vertices 
    * @param d vertice
    * @param visitados ayuda a tener un conteo acerca de que nodos han sido
    * o no visitados
    * @return true si hay camino, false de lo contrario
    */
    private static boolean hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        if (o == d)
            return true;
            ArrayList<Integer> hijos = g.getSuccessors(o);          
          try{
            for (Integer hijo: hijos){
                if (!visitados[hijo] && hayCaminoAux(g,hijo,d,visitados))
                    {return true;}
            }      
        }
        catch(Exception e){}
        return false;
    }
 
  	   /**
    * Metodo auxiliar que llama al metodo recorrido posterior
    * con cada uno de los vertices
    * @param g grafo dado 
     * @param o nodo desde el cual empieza el recorrido 
    * @param d nodo donde termina el recorrido
    * @return cual es el costo que tiene
    */
   

    public static int hayCamino2(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux2(g, o, d, visitados);
    }
  /**
    * Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
    * se quiere encontrar el de menor costo
    * @param g grafo dado 
    * @param o nodo desde el cual empieza el recorrido 
    * @param d nodo donde termina el recorrido
    * @return cual es el costo que tiene ir desde inicio a fin
    */
    private static int hayCaminoAux2(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        int costoMinimo = 1000000;
                 int costoCamino=0;
        if (o == d){
        visitados[o] = false;
           return 0;
        }
        else{
           ArrayList<Integer> hijos = g.getSuccessors(o);          
                try{
                for (Integer hijo: hijos){
                if (!visitados[hijo]){
                  costoCamino =g.getWeight(o,hijo)+ hayCaminoAux2(g, hijo, d, visitados);
                  visitados[hijo]=false;
                   if (costoCamino < costoMinimo)
                             { costoMinimo = costoCamino;}
                }
              
              
        
    
        }}
    catch(Exception e){}
}
          return costoMinimo;  
    }
 

}
