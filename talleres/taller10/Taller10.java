public class Taller10 {

  public static int lcs(String a, String b) {
    int uno = a.length() + 1;
    int dos = b.length() + 1;
    int [][] matriz = new int[uno][dos];
    for(int i = 0; i < uno; i++){
      matriz[i][0] = 0;
    }
    for(int j = 0; j < dos; j++){
      matriz[0][j] = 0;
    }
    for(int j = 1; j < uno; j++){ 
        for(int i = 1; i < dos; i++){
            if(a.charAt(i - 1)==b.charAt(j - 1)){
                matriz[i][j] = matriz[i - 1][j - 1]+1;
            }
            else
            {
                matriz[i][j]=Math.max(matriz[i][j-1],matriz[i-1][j]);
            }
    }
    }
    return matriz[uno - 1][dos - 1];
}
  public static void main(String[] args) {
    System.out.println(lcs("AGACTGTC","TAGTCACG"));  
  }
}