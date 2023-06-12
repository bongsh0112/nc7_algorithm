import java.io.*;
// 분해합
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int ret = 0;

    for (int i = 0; i < n; i++) {
      int num = i;
      int sum = 0;

      while (num != 0) {
        sum += num % 10;
        num /= 10;
      }
      
      if (sum + i == n) {
        ret = i;
        break;
      }
    }
    System.out.println(ret);
  }
}
