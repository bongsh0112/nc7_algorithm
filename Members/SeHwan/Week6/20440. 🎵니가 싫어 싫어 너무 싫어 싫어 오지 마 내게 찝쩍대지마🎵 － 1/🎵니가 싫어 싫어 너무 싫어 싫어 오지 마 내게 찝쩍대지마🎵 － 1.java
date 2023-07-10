import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int[] startArr = new int[N]; // 모기가 들어온 시간
    int[] endArr = new int[N]; // 모기가 나간 시간
    TreeSet<Integer> timestamp = new TreeSet<>(); // 좌표 압축을 위해 오름차순 + 중복제거 보장되는 TreeSet 이용
    
    for (int i = 0; i < N; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int start = Integer.parseInt(str[0]);
      int end = Integer.parseInt(str[1]);
      startArr[i] = start;
      endArr[i] = end;
      timestamp.add(start);
      timestamp.add(end);
    }
    
    ArrayList<Integer> indexes = new ArrayList<>(timestamp); // TreeSet을 ArrayList로 변환 -> 2, 4, 6, 10, 16
    int[] sum = new int[indexes.size()];
    for (int i = 0; i < N; i++) {
      int x = Collections.binarySearch(indexes, startArr[i]); // Collections의 탐색일 바이너리서치로 startArr[i], endArr[i]의 값을 가진 인덱스를 indexes에서 찾아서
      int y = Collections.binarySearch(indexes, endArr[i]);
      for (int j = x; j < y; j++) {
        sum[j]++; // sum 배열의 x~y 인덱스에 +1
        /**
         * 0 ~ 4
         * 1 ~ 1
         * 2 ~ 2
         * sum = {1, 2, 2, 1, 0}
         */
      }
    }
    
    int max = 0; // 모기가 가장 많은 시간대의 모기 수
    int maxidx = Integer.MIN_VALUE; // 모기가 가장 많은 시간대의 시작 시간
    int maxendidx = Integer.MIN_VALUE; // 모기가 가장 많은 시간대의 끝 시간
    for (int i = 0; i < sum.length; i++) {
      if (sum[i] > max) {
        maxidx = i;
        maxendidx = i;
        max = sum[i];
      }
      if (sum[i] == max && i - 1 == maxendidx) { // 바로 이전 것도 maxendidx라면?
        maxendidx = i; // 현재의 값을 maxendidx로
      }
    }
    
    System.out.println(max + "\n" + indexes.get(maxidx) + " " + indexes.get(maxendidx + 1)); // j < y 로 sum을 채워서 1 2 2 1 0 이기 때문에 maxendidx + 1
  }
  
}