import java.util.*;

public class nosecomollamaresto{

    public static LinkedList<String> permutaciones(String cadena){
      LinkedList<String> respuesta = new LinkedList<String>();
		permutacionesAux("", cadena, respuesta);
                System.out.println(respuesta);
		return respuesta;
            }
    private static void permutacionesAux(String loQueLlevo, String loQueMeFalta, LinkedList<String> list){
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
    
    public  LinkedList<String> conjuntoPotencia(String cadena) {
	        LinkedList<String> respuesta = new LinkedList<String>();
		conjuntoPotenciaAux("", cadena, respuesta);
		System.out.println(respuesta);
                return respuesta;
	}
    
    private  void conjuntoPotenciaAux(String loQueLlevo, String loQueMeFalta, LinkedList<String> list){
    
        if (loQueMeFalta.isEmpty()) 
            list.add(loQueLlevo);       
        else{
            conjuntoPotenciaAux(loQueLlevo,loQueMeFalta.substring(1),list);
            conjuntoPotenciaAux(loQueLlevo+loQueMeFalta.charAt(0),loQueMeFalta.substring(1),list);
            }
    }

}
