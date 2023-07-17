import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] A = new int[n];
    int[] B = new int[n];
    
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st1.nextToken());
      B[i] = Integer.parseInt(st2.nextToken());
    }
    Arrays.sort(A);
    Arrays.sort(B);
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += A[i] * B[n - i - 1];
    }
    System.out.println(sum);
  }
}