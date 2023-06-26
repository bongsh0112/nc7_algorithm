import java.io.*;
// 영화감독 숌
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = (br.readLine());
    int n = Integer.parseInt(str);
    int start = 666;

    while (true) {
      if (String.valueOf(start).contains("666")) {
        if (n == 1) {
          System.out.println(start);
          break;
        }
        else n--;
      }
      start++;
    } 
  }
}