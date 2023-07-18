import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    List<Integer> A = new ArrayList<>();
    List<Integer> B = new ArrayList<>();
    
    String[] str = bufferedReader.readLine().split(" ");
    for (int i = 0; i < str.length; i++) {
      A.add(Integer.parseInt(str[i]));
    }
    
    str = bufferedReader.readLine().split(" ");
    for (int i = 0; i < str.length; i++) {
      B.add(Integer.parseInt(str[i]));
    }
    
    // A는 오름차순, B는 내림차순으로 배열한다면 가장 작은 값이 나올 것이다.
    Collections.sort(A);
    Collections.sort(B, (a, b) -> b - a); // Comparator : b - a의 return 값이 0이라면 둘이 같고 양수라면 b > a 음수라면 a > b.
    // 따라서 B는 내림차순 정렬이 될 것.
    
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += A.get(i) * B.get(i);
    }
    System.out.println(sum);
    
  }
  
}