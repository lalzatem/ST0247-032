import java.util.*;

/**
 * Clase en la cual se implementa los metodos del Taller de Clase # 2
 * 
* @autor Mauricio Toro, Mateo Agudelo, David Alzate, Laura Alzate
 */

public class nosecomollamaresto{


    /**
	* Metodo auxiliar que llama al metodo permutations posterios
	* 
	* @param  cadena la cadena a la cual se le haran las permutaciones
	* @return un ArrayList que contiene las permutaciones
	*/
    public static ArrayList<String> permutaciones(String cadena){
        ArrayList<String> respuesta = new ArrayList<String>();
		permutacionesAux("", cadena, respuesta);
        System.out.println(respuesta);
		return respuesta;
    }

    /**
	* Metodo para obtener las posibles permutaciones que se pueden hacer
	* con los caracteres de una cadena dada, recuerde que las letras no se 
	* repiten en este ejercicio
	* 
	* @param  loQueLlevo parte de la cadena que hace parte de la permutacion
	* @param loQueMeFalta parte de cadena que falta por calcular en una permutacion
	* @param list el conjunto que tiene todas las permutaciones
	* 
	*/	
    private static void permutacionesAux(String loQueLlevo, String loQueMeFalta, ArrayList<String> list){
        if(loQueMeFalta.isEmpty()){
           
            list.add(loQueLlevo);
        }
        else{
            for(int i=0;i<loQueMeFalta.length();i++)
            {
            permutacionesAux(loQueLlevo+loQueMeFalta.charAt(i),loQueMeFalta.substring(0,i)+loQueMeFalta.substring(i+1),list); 
            }
        }
    }
    

    /**
	* Metodo público que llama al metodo combinations posteriormente
	* 
	* @param cadena cadena sobre el cual se haran las combinaciones (o subconjuntos)
	
	*/	
    public  LinkedList<String> conjuntoPotencia(String cadena) {
	        LinkedList<String> respuesta = new LinkedList<String>();
		conjuntoPotenciaAux("", cadena, respuesta);
		System.out.println(respuesta);
                return respuesta;
    }
    
    /**
	* Metodo para obtener las posibles combinaciones (o subconjuntos) que se pueden hacer
	* con los elementos dados
	* 
	* @param  loQueLlevo cadena de caracteres con lo que ya se tiene del subconjunto
	* @param loQueMeFalta cadena de caracteres con lo que me falta por calcular del subconjunto
	* @param list lista de cadenas para almacenar las combinaciones (o subconjuntos)
	* 
	*/
    private  void conjuntoPotenciaAux(String loQueLlevo, String loQueMeFalta, LinkedList<String> list){
    
        if (loQueMeFalta.isEmpty()) 
            list.add(loQueLlevo);       
        else{
            conjuntoPotenciaAux(loQueLlevo,loQueMeFalta.substring(1),list);
            conjuntoPotenciaAux(loQueLlevo+loQueMeFalta.charAt(0),loQueMeFalta.substring(1),list);
            }
    }

        public static void main(String[] args){

            nosecomollamaresto hola=new nosecomollamaresto();
            System.out.println("COMBINATORIA");
            hola.conjuntoPotencia("abc");
            System.out.println("");
    
            System.out.println("PERMUTACION");
            ArrayList<String> arreglo = permutaciones("abcd");
            for(String s : arreglo)
                System.out.println(s + " " + AdvancedEncryptionStandard.desencriptarArchivo(s));
    }

}