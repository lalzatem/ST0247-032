import java.util.ArrayList;

class punto1_1

{
    
    public static int hayCamino(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux(g, o, d, visitados);
    }
  /**
    * Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
    * se quiere encontrar el de menor costo
    * @param g grafo dado 
    * @param o nodo desde el cual empieza el recorrido 
    * @param d nodo donde termina el recorrido
    * @return cual es el costo que tiene ir desde inicio a fin
    */
    private static int hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
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
                  costoCamino =g.getWeight(o,hijo)+ hayCaminoAux(g, hijo, d, visitados);
                 
                   if (costoCamino < costoMinimo)
                  
                             {
                                  System.out.println(hijo);
                                 costoMinimo = costoCamino;}
                }

        }}
    catch(Exception e){}
}
          return costoMinimo;  
    }
}

