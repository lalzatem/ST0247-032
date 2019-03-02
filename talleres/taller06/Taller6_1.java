import java.util.Arrays;
public class Taller6_1{

    public static int[] cambioGreedy(int n, int[] denominaciones){
        int[] respuesta = new int[denominaciones.length];
        Arrays.sort(denominaciones);
        for(int i=denominaciones.length-1; i>=0; i--){
            int cantidad = n/denominaciones[i];
            respuesta[i] = cantidad;
            n = n%denominaciones[i];
        }
        if(n==0)return respuesta;
        else return null;
    }

    public static void main(String[] args) {
        int[] money = {500,200,50};
        int[]a = cambioGreedy(1600, money);
        if(a!=null){
            System.out.print("[");
            for(int i=a.length-1; i>=0; i--){
                System.out.print(a[i]+" ");
            }
            System.out.print("]");
        }
        else{
            System.out.println("No es posible");
        }
    }
}