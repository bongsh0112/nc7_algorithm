import java.io.*;
// 블랙 잭
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);

    int[] card = new int[n];
    int sum = 0;
    int ret = 0;

    String[] str2 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      card[i] = Integer.parseInt(str2[i]);
    }

    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        for(int k = j+1; k < n; k++) {
          sum = card[i] + card[j] + card[k];
          if(sum <= m && ret < sum) {
            ret=sum;
          }
        }
      }
    }
    System.out.println(ret);
  }
}
