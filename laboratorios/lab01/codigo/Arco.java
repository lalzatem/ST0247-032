/**
 * Este es nuestra clase Arco, aqui creamos una lista de parejas, y tambien
 * se implementan unos  getters.
 *
 * @author David Alzate Cardona
   @author Laura Alzate Madrid
 */

public class Arco
{

    private String vertice1;
    private String vertice2;
    public  double distancia;
    private String nombre;

    /**
     * Constructor que recibe como parametros:
     * @param vertice1
     * @param vertice2
     * @param distancia
     * @param nombre
     */
    public Arco(String vertice1,String vertice2, double distancia, String nombre )
        {
            this.vertice1=vertice1;
            this.vertice2=vertice2;
            this.distancia=distancia;
            this.nombre=nombre;

        }
        public String GetVertice1(){return this.vertice1;}
        public String GetVertice2(){return this.vertice2;}
        public Double GetDistancia(){return this.distancia;}
        public String GetBombre(){return this.nombre;}

}
