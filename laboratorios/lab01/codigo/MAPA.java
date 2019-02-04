import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import javafx.util.Pair;

/**
 * Este es nuestra clase Mapa, aquí creamos el HashMap y lo mostramos
 *
 * @author David Alzate Cardona
   @author Laura Alzate Madrid
 */
public class MAPA {

    private HashMap<String, Nodos> grafo = new HashMap<String, Nodos>();

    /**
     * Este es nuestro metodo para crear el mapa, el cual nos lee el 
     * archivo y lo separa por lineas, para luego separar los vertices con 
     * ayuda del split y tener el id, coordenada x, coordenada y, nombre.
     * When se encuentre la palabra "Arcos", para tener id, id, distancia, nombre.
     * 
     * "grafo.put" me permite colocar a vertice en el Mapa
     * "grafo.get" me permite tomar informacion del arco, el vertice del 
     * inicio y el vertice final
     * 
     * En este metodo tambien se hallan los caminos conexos que esta mas cerca
     */
    public void CrearMapa() {
       
        try {
            File Archivo = new File("medellin_colombia-grande.txt");
            FileReader Arichivo2=new FileReader(Archivo);
             BufferedReader b = new BufferedReader(Arichivo2);
            String linea=b.readLine();

            while ((linea=b.readLine())!=null){
                if (linea.length() > 0) {
                    if (linea.contains("Arcos")){break;}
                    String[]  nodito=linea.split(" ");
                    String nombre="";
                    
                    if ((nodito.length > 3)) {
                        nombre = nodito[3];
                    }
                    Nodos vertice = new Nodos(nodito[0], nodito[1], nodito[2], nombre);
                    grafo.put(vertice.getid(), vertice);
                }
                
            }
           while ((linea=b.readLine())!=null){
                
                    String nombre="";
                    String[] nodito=linea.split(" ", 4);
                    if ((nodito.length > 3)) {
                     nombre=nodito[3];
                    }
                    Arco arco=new Arco(nodito[0], nodito[1], Double.parseDouble(nodito[2]), nombre);
                    
                    grafo.get(arco.GetVertice1()).cercano(arco.GetVertice2(), arco);
                    
                
            }
        } catch (IOException e) {
            System.out.println(e);
        } 
        
    }

  
    /**
     * Este es nuestro metodo para mostrar el mapa
     */
        public void MostrarMapa(){
         Iterator iterador = grafo.entrySet().iterator();
         while (iterador.hasNext()) {
            Map.Entry clave = (Map.Entry) iterador.next();
            System.out.print(clave.getKey());
            
            LinkedList<Pair<String, Arco>> llave = grafo.get(clave.getKey()).conexo();
            Iterator llave2= llave.iterator();
            while(llave2.hasNext()){
                Pair siguiente = (Pair)llave2.next();
                System.out.print(" --> "+(siguiente.getKey()));
            }
            System.out.println();
         }

        }

 }
