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
    
    TreeSet<Integer> dots = new TreeSet<>(); // 중복제거와 오름차순 정렬을 위한 TreeSet
    int[] dotsArr = new int[N]; // 입력으로 들어온 좌표들을 넣는 int 배열
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(str[i]);
      dots.add(temp); // TreeSet에 저장 
      dotsArr[i] = temp; // dotsArr에 저장
    }
    
    List<Integer> vertical = new ArrayList<>(dots); // TreeSet -> ArrayList. TreeSet의 원소들을 수직선에 놓는다고 생각하면 된다
    for (int dot : dotsArr) {
      int idx = Collections.binarySearch(vertical, dot); // 수직선에서 dotsArr의 원소가 몇 번째인지 알아낸다
      stringBuilder.append(idx + " ");
    }
    
    System.out.println(stringBuilder.toString());
    
  }
}