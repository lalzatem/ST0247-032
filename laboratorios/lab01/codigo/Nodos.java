import java.util.LinkedList;
import javafx.util.Pair;


/**
 * Este es nuestra clase Nodos, aqui creamos una lista de parejas, y tambien
 * se implementan unos  getters.
 *
 * @author David Alzate Cardona
   @author Laura Alzate Madrid
 */
public class Nodos
{
   private LinkedList<Pair<String, Arco>> siguiente = new LinkedList<Pair<String, Arco>>();
   private String id;
   private String x;
   private String y;
   private String nombre;

    /**
     * Constructor que recibe como parametros:
     * @param id 
     * @param x 
     * @param y 
     * @param nombre 
     */
    public Nodos(String id,String x,String y, String nombre)
    {
        
       this.id=id;
       this.x=x;
       this.y=y;
       this.nombre=nombre;
    }

    public String getX(){
      return this.x;    
     }
     public String getY(){
      return this.y;    
     }
    public String getid(){
     return this.id;    
    }
    
    public String getnombre(){
     return this.nombre;    
    }
        
    public void cercano(String vertice2,Arco arco)
    {
        Pair pareja=new Pair(vertice2,arco);    
       siguiente.add(pareja);
    }
    
    public LinkedList<Pair<String, Arco>> conexo(){return siguiente;}
    
 
    }