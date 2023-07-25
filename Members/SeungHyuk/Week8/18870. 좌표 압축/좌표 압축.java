import java.io.*;
import java.util.*;

// 좌표 압축
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] sorted = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(sorted);
    int rank = 0;
    HashMap<Integer, Integer> HashRank = new HashMap<Integer, Integer>();
    
    for (int i = 0; i < N; i++) {
      if (!HashRank.containsKey(sorted[i])) {
        HashRank.put(sorted[i], rank++);
      }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(HashRank.get(arr[i])).append(' ');
    }

    System.out.println(sb);
  }
}