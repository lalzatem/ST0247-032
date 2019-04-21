import java.util.ArrayList;

public class punto1 {

    public static int agenteViajero(Digraph g, int inicio) {
        boolean[] visitados = new boolean[g.size()];
        return caminoCorto(g, inicio, visitados);
    }

    private static int caminoCorto(Digraph g, int inicio, boolean[] visitados) {
        int[] resultado = new int[g.size];
        int costoCamino = 0;
        ArrayList<Integer> hijos = new ArrayList<Integer>();
        for (int i = 1; i <= g.size(); i++) {
            int costoMinimo = Integer.MAX_VALUE;
            int cercano = -1;
            visitados[inicio] = true;
            if (i == g.size()) {
                visitados[0] = false;
            }
            try {
                hijos = g.getSuccessors(inicio);
                for (Integer hijo : hijos) {
                    if (!visitados[hijo] && hijo != inicio && (g.getWeight(inicio, hijo) < costoMinimo)) {
                        costoMinimo = g.getWeight(inicio, hijo);
                        cercano = hijo;
                    }
                }
                inicio = cercano;
                costoCamino += costoMinimo;
            } catch (Exception e) {
            }
        }
        return costoCamino;
    }

    static int testCostoMinimo() {
        int n = 5;
        DigraphAM g1 = new DigraphAM(n);
        g1.addArc(0, 1, 2);
        g1.addArc(0, 2, 2);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 4);
        g1.addArc(1, 0, 2);
        g1.addArc(1, 2, 3);
        g1.addArc(1, 3, 2);
        g1.addArc(1, 4, 3);
        g1.addArc(2, 0, 2);
        g1.addArc(2, 1, 3);
        g1.addArc(2, 3, 2);
        g1.addArc(2, 4, 2);
        g1.addArc(3, 0, 1);
        g1.addArc(3, 1, 2);
        g1.addArc(3, 2, 2);
        g1.addArc(3, 4, 4);
        g1.addArc(4, 0, 4);
        g1.addArc(4, 1, 3);
        g1.addArc(4, 2, 2);
        g1.addArc(4, 3, 4);

        int a = agenteViajero(g1, 0);
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Recorrido (TSP) -> " + testCostoMinimo());
    }
}