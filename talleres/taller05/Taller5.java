import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 5
 * 
 * @author Mauricio Toro, Camilo Paez, laura Alzate, David Alzate 
 */
public class Taller5 {

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color colors en la 
	* posicion c al nodo v, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param c indice de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
	    ArrayList<Integer> sucesoresDeV = g.getSuccessors(v);
	    for (Integer sucesor  : sucesoresDeV){
	        int queColorTieneElSucesor = colors[sucesor];
		if (queColorTieneElSucesor == c)
		  return false;
            }
            return true;
	}
}



	/**
	* Metodo que dado un grafo y un numero m, se asigna un color
	* a cada nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @return true si es posible, false de lo contrario
	*/
	public static boolean mColoring(Digraph g, int m) {
	    int colors[]=new int[g.size];
	    return mColoring(g,0,colors,m);
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color
	* al nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
	    if(v==g.size()){
	        return true;
	    }else{
	        for(int c=0; c<m; c++){
	            if(isSafe(g,v,colors,c)){
	                return mColoring(g,v+1,colors,m);
	            }
	        }
	        return false;
	    }
	}
