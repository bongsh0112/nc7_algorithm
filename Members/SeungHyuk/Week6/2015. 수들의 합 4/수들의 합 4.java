import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N + 1];

    long ans = 0;
    HashMap<Integer,Long> map = new HashMap<>();

    String[] str = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(str[i - 1]) + arr[i - 1];
      if (arr[i] == K) {
        ans++;
      }
      if (map.containsKey(arr[i] - K)) {
        ans += map.get(arr[i] - K);
      }
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], 1L);
      }
      else
        map.put(arr[i], map.get(arr[i]) + 1);
    }
    System.out.println(ans);
  }
}