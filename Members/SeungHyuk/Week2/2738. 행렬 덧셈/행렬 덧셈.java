import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String[] str = br.readLine().split(" ");
    int ny = Integer.parseInt(str[0]);
    int nx = Integer.parseInt(str[1]);

    int[][] arr = new int[ny][nx];
    
    for (int i = 0; i < ny; i++) {
      String[] str1 = br.readLine().split(" ");
      for (int j = 0; j < nx; j++) {
        arr[i][j] = Integer.parseInt(str1[j]);
      }
    }

    for (int i = 0; i < ny; i++) {
      String[] str2 = br.readLine().split(" ");
      for (int j = 0; j < nx; j++) {
        arr[i][j] += Integer.parseInt(str2[j]);
        sb.append(arr[i][j] + " ");
      }
      sb.append("\n");
    }
    
    System.out.println(sb.toString());

  }
}
