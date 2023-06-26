import java.io.*;
import java.util.*;
// 문자열 집합
public class Main {
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 0);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (map.containsKey(br.readLine())) 
              count++;
        }

        System.out.print(count);
    }
}
