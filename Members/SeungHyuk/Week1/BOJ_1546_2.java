import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1546_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m = 0;
    double ret = 0.0;

    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    m = arr[arr.length-1];

    for(int i = 0; i < n; i++) {
      ret += ((arr[i] / (double) m) * 100);
    }
    
    ret /= n;
    System.out.println(ret);
  }
}
