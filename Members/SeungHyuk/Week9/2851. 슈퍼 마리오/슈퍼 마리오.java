import java.io.*;

// 슈퍼 마리오
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int ret = 0;

    for (int i = 0; i < 10; i++) {
      int cur = Integer.parseInt(br.readLine());

      if (sum < 100){
        sum += cur;
        if (Math.abs(ret - 100) > Math.abs(sum - 100)) {
          ret = sum;
        } else if(Math.abs(ret - 100) == Math.abs(sum - 100)) {
          ret = ret > sum ? ret : sum;
        }
      }
    }

    System.out.println(ret);
  }
}