import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;

public class punto2 {
  public static int moneyDue(int total, int d, int r) {

    if (total > d) {
      int r1 = total - d;
      return r1 * r;
    } else {
      return 0;
    }
  }

  public static void validar(String[] cadena, int n) {

    if (cadena.length != n) {
      System.out.println("cadena invalida");
      System.exit(0);
    }

  }

  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Integer> resultadodia = new ArrayList<Integer>();
    String aux = "";
    while (true) {
      aux = teclado.nextLine();
      String[] entrada = aux.split(" ");

      int n = Integer.parseInt(entrada[0]);
      int d = Integer.parseInt(entrada[1]);
      int r = Integer.parseInt(entrada[2]);

      if ((n >= 1 && n <= 100) && (d >= 1 && d <= 10000) && (r >= 1 && r <= 5)) {
        String horadia = teclado.nextLine();
        String[] horaD = horadia.split(" ");
        validar(horaD, n);
        String horatarde = teclado.nextLine();
        String[] horaT = horatarde.split(" ");
        validar(horaD, n);
        int[] total = new int[n];
        for (int i = 0; i < n; ++i) {
          total[i] = Integer.parseInt(horaD[i]) + Integer.parseInt(horaT[i]);
        }
        int gastoExtra = 0;
        for (int i = 0; i < n; ++i) {
          gastoExtra += moneyDue(total[i], d, r);
        }
        resultadodia.add(gastoExtra);
      }
      if (n == 0 && d == 0 && r == 0) {
        break;
      }
    }
    

    for (int i = 0; i < resultadodia.size(); ++i) {
      System.out.println("Dia " + i + ": " + resultadodia.get(i));
    }
  }
}
