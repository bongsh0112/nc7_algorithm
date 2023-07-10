import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);
    
    int[] arr = new int[N + 1]; // 누적합 배열
    str = bufferedReader.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(str[i - 1]) + arr[i - 1]; // str은 0부터 시작해야함.
    }
    
    long count = 0; // K와 같은 경우 +1
    HashMap<Integer, Integer> sum = new HashMap<>(); // arr[i] 값이 몇개가 있는지 키-값 쌍으로 관리
    for (int i = 1; i <= N; i++) {
      if (arr[i] == K) { // 만약 누적합의 값이 K와 같다면 그냥 count 증가
        count++;
      }
      
      if (sum.containsKey(arr[i] - K)) { // 누적합에서 K를 뺀 값이 키값으로 있다면 (i - 1) ~ i 사이의 합이 5라는 것. => 15 - 5 = 10 에서 15도 arr에 있고 10도 arr에 있는 경우.
        count += sum.get(arr[i] - K);
      }
      
      if (sum.containsKey(arr[i])) { // map에 값을 저장하는 로직. arr[i]가 이미 키값으로 있다면
        sum.put(arr[i], sum.get(arr[i]) + 1); // arr[i] 키의 값을 이전 value값(초기값은 0)+1 으로 value를 설정한다.
      } else {
        sum.put(arr[i], 1); // arr[i]가 키 값으로 없다면 새로 put
      }
      
    }
    
//    시간초과 나는 코드
//    int count = 0;
//    for (int i = 0; i < N; i++) {
//      int sum = 0;
//      for (int j = i; j < N; j++) {
//        sum = arr[i] + arr[j];
//        if (sum == K) count++;
//      }
//    }
    
    stringBuffer.append(count);
    System.out.println(count);
    
  }
  
}