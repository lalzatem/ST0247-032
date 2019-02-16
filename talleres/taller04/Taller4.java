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
    * @param v vertices 
    * @param w vertice
    * @return true si hay camino, false de lo contrario
    */
    public static boolean hayCamino(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux(g, o, d, visitados);
    }

    /**
    * Metodo que recorre el grafo por medio de dfs 
    * @param g grafo dado 
    * @param v vertices 
    * @param w vertice
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
    * Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
    * se quiere encontrar el de menor costo
    * @param g grafo dado 
    * @param inicio nodo desde el cual empieza el recorrido 
    * @param fin nodo donde termina el recorrido
    * @return cual es el costo que tiene ir desde inicio a fin
    */

    public static int hayCamino2(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux2(g, o, d, visitados);
    }
	   /**
    * Metodo auxiliar que llama al metodo recorrido posterior
    * con cada uno de los vertices
    * @param g grafo dado 
    * @return cual es el costo que tiene
    */
    private static int hayCaminoAux2(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        int costoMinimo = 900;
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
 


    /**
    * Metodo que recorre todo el grafo con la intencion de buscar un
    * camino que represente el menor costo pasando por todos los vertices exactamente
    * una vez y vuelva al nodo inicial
    * @param g grafo dado 
    * @param v vertice inicial
    * @param unvisited arreglo de nodos aun no visitados
    * @return cual es el costo que tiene
    */
    private static int recorrido(Digraph g, int o,int c, boolean[] unvisited) {
     
        unvisited[c] = true;
        int costoMinimo = 900;
                 int costoCamino=0;
        if (o == g.size()){
        unvisited[o] = false;
           return 0;
        }
        else{
           ArrayList<Integer> hijos = g.getSuccessors(o);          
                try{
                for (Integer hijo: hijos){
                if (!unvisited[hijo]){
                  costoCamino =g.getWeight(o,hijo)+ hayCaminoAux2(g, hijo, c+1, unvisited);
                  
                   if (costoCamino < costoMinimo)
                             { costoMinimo = costoCamino;}
                }
              
              
        
    
        }}
    catch(Exception e){}
}
          return costoMinimo;  
    }
    public int[] hola(int[] v,int posicion){
    v[posicion]=0;
    return v;
    }
}