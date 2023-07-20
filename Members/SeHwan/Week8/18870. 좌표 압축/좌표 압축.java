import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    String[] str = bufferedReader.readLine().split(" ");
    
    TreeSet<Integer> dots = new TreeSet<>();
    int[] dotsArr = new int[N];
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(str[i]);
      dots.add(temp);
      dotsArr[i] = temp;
    }
    
    List<Integer> vertical = new ArrayList<>(dots);
    for (int dot : dotsArr) {
      int idx = Collections.binarySearch(vertical, dot);
      stringBuilder.append(idx + " ");
    }
    
    System.out.println(stringBuilder.toString());
    
  }
}