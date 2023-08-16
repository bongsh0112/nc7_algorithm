import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);
    
    List<Integer> A = new ArrayList<>();
    List<Integer> B = new ArrayList<>();
    
    str = bufferedReader.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      A.add(Integer.parseInt(str[i]));
    }
    str = bufferedReader.readLine().split(" ");
    for (int i = 0; i < M; i++) {
      B.add(Integer.parseInt(str[i]));
    }
    
    List<Integer> answer = new ArrayList<>();
    int idxA = 0;
    int idxB = 0;
    while (idxA < N && idxB < M) {
      if (A.get(idxA) < B.get(idxB)) {
        answer.add(A.get(idxA));
        idxA++;
      } else {
        answer.add(B.get(idxB));
        idxB++;
      }
    }
    // idx들에 ++만 해줘도 되는 이유는 이미 주어진 배열들이 정렬되어있기 때문이다.
    
    // 다 돌고나서 나머지 숫자들도 넣어주기
    while(idxA < N) {
      answer.add(A.get(idxA));
      idxA++;
    }
    while(idxB < M) {
      answer.add(B.get(idxB));
      idxB++;
    }
    
    for (int i : answer) {
      stringBuilder.append(i + " ");
    }
    
    System.out.println(stringBuilder.toString());
  }
  
}