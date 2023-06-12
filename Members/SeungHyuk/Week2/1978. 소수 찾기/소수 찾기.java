import java.io.*;
// 소수 찾기
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    int n = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    int count = 0;
    for (int i = 0; i < n; i++) {
      boolean isPrime = true;
      int num = Integer.parseInt(str[i]);
      
      if (num == 1) continue;
      
      for (int j = 2; j <= Math.sqrt(num); j++) {
        if(num % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) count++;
    }
    System.out.println(count);
  }
}
