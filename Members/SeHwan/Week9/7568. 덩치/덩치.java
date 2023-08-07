import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(bufferedReader.readLine());
    List<int[]> list = new ArrayList<>();
    
    for (int i = 0; i < N; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int[] person = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
      list.add(person);
    }
    
    int[] rank = new int[N];
    for (int i = 0; i < N; i++) {
      rank[i] = 1;
    }
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1]) {
          rank[i]++;
        } else {
          rank[i] = rank[i];
        }
      }
    }
    
    for (int i : rank) {
      System.out.println(i);
    }
    
  }
  
}