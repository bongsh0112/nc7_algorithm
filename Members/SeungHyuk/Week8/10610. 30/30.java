import java.io.*;
import java.util.*;

public class Main {
  static final int MAX = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int[] arr = new int[10];
    long total = 0;
    long len = s.length();

    for (int i = 0; i < len; i++) {
      arr[Integer.parseInt(s.substring(i, i + 1))]++;
      total += Integer.parseInt(s.substring(i, i + 1));
    }

    if(!s.contains("0") || total % 3 != 0) {
        System.out.println("-1");
        return;
    }
    
    StringBuilder sb = new StringBuilder();
    for(int i = 9; i >= 0; i--) {
        while(arr[i] > 0) {
            sb.append(i);
            arr[i]--;
        }
    }
    System.out.println(sb.toString());
  }
}