import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static int F;
  static int S;
  static int G;
  static int U;
  static int D;
  static int[] floors;
  static Queue<Integer> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    F = Integer.parseInt(str[0]); // 총 층
    S = Integer.parseInt(str[1]); // 지금 있는 층
    G = Integer.parseInt(str[2]); // 목적지
    U = Integer.parseInt(str[3]); // 위로 가는 층 개수
    D = Integer.parseInt(str[4]); // 밑으로 가는 층 개수
    
    floors = new int[F + 1];
    queue.add(S);
    floors[S] = 1; // 첫 층은 맨 처음에 한 번 방문한 것으로 간주함
    
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if (cur + U <= F && floors[cur + U] == 0) { // 다음에 올라갈 위치가 꼭대기층보다 작거나 같을 때 && 다음에 올라갈 위치가 방문하지 않은 층일 때
        floors[cur + U] = floors[cur] + 1; // 버튼을 한번 더 눌러 올라갔다고 생각한다
        queue.add(cur + U);
      }
      if (cur - D >= 1 && floors[cur - D] == 0) { // 다음에 내려갈 위치가 맨 밑 층보다 크거나 같을 때 && 다음에 내려갈 위치가 방문하지 않은 층일 때
        floors[cur - D] = floors[cur] + 1; // 버튼을 한번 더 눌러 내려갔다고 생각한다
        queue.add(cur - D);
      }
    }
    
    if (floors[G] == 0) {
      System.out.println("use the stairs");
    } else {
      System.out.println(floors[G] - 1);
    }
  }
  
}