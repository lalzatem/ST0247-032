import java.util.ArrayList;
import java.util.Scanner;

public class punto2_1 {

     
    //metodo encargado de recibir por teclado la cantidad de arcos, nodos y el peso que hay entre ellos
    public void nums (){
        Scanner Teclado = new Scanner(System.in);
        String moviento=Teclado.nextLine();
        String[]  inicio=moviento.split(" ");
        int n = Integer.parseInt(inicio[0]);
        int m = Integer.parseInt(inicio[1]);
        Digraph g = new DigraphAM(n + 1);
        for (int i = 0; i < m; i++) {
            String moviento1=Teclado.nextLine();
            String[]  inicio1=moviento1.split(" ");
            int inicial = Integer.parseInt(inicio1[0]);
            int siguiente = Integer.parseInt(inicio1[1]);
            int peso = Integer.parseInt(inicio1[2]);  
            g.addArc(inicial,siguiente, peso);
        }
        System.out.println("digite nodo inicial para llegar hasta" + m);
   int primero=Teclado.nextInt();
        haycamino(g, primero,n);
    }


    public  void haycamino(Digraph g, int o, int d) {
        int [] acumulador = new int[g.size()];
        for(int i=0;i<acumulador.length;i++)
        {
            acumulador[i]=100000000;
        }
        ArrayList <Integer> arreglo = new ArrayList<>();
       acumulador[o]=0;// el nodo origen debe empezar en 0 ya que no lleva nada anterior a el.
        arreglo.add(o);
        ArrayList<Integer> total = new ArrayList<>();
        System.out.println(hayCaminoAux(g,o,d,acumulador,arreglo,total));
      


    }

//metodo que auxiliar que se encarga de dar el arreglo con el recorrido de menor costo
    public   ArrayList<Integer> hayCaminoAux(Digraph g, int o, int d, int[] acumulador, ArrayList<Integer> loquellevo,ArrayList<Integer>eltotal ) {

        if (o == d) 
            { return eltotal = new ArrayList<>(loquellevo);}
        
        ArrayList<Integer> hijos = g.getSuccessors(o); 
        for (Integer hijo : hijos) {
            int costoCamino =g.getWeight(o,hijo)+ acumulador[o]; // se suma el peso actual con lo que llevaba
                if (acumulador[hijo] >= costoCamino) {
                    loquellevo.add(hijo);
                    acumulador[hijo] = costoCamino;
                    eltotal = hayCaminoAux(g, hijo, d, acumulador, loquellevo,eltotal);
                    loquellevo.remove(hijo);
                }
        }

        return eltotal;
    
}



}