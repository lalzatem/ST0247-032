import java.util.ArrayList;
import java.util.Arrays;

public class Taller7 {


    public static int[] dijkstra(Digraph g, int v){
        int[] tabla = new int [g.size];
        Arrays.fill(tabla,Integer.MAX_VALUE);
        tabla[v] = 0;
        int actual = v;
        boolean[] visitados = new boolean[g.size()];
        for (int i = 0; i < g.size() -1 ; i++) {
            actual = elMasPequenoNoVisitado(g, visitados, tabla);
            visitados[actual] = true;
            actualizarLosPesosDeLaTablaConElValorActual(g, actual, tabla);
        }
        return tabla;
    }
    
    private  static int elMasPequenoNoVisitado(Digraph g, boolean [] visitados ,int[] tabla){
        int min = Integer.MAX_VALUE;
        int minIndex = -1 ;
        for (int i = 0; i < g.size; i++) {
            if (tabla[i] <= min && !visitados[i]){
                min = tabla[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void actualizarLosPesosDeLaTablaConElValorActual(Digraph g ,int v, int [] tabla){
        if(tabla[v] != Integer.MAX_VALUE){
            ArrayList<Integer> adyacentes = g.getSuccessors(v);
            int peso = tabla[v];
            for (Integer u: adyacentes){
                int w =  g.getWeight(v,u);
                if (v != u &&  w !=Integer.MAX_VALUE && (w+peso) < tabla[u])
                    tabla[u]= w+peso;

            }
        }

    }
}