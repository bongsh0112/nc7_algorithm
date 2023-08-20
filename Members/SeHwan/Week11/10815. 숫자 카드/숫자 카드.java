import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  
  static List<Integer> cards;
  static List<Integer> arr;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    String[] str = bufferedReader.readLine().split(" ");
    cards = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      cards.add(Integer.parseInt(str[i]));
    }
    cards.sort((a, b) -> a - b); // 오름차순 정렬
    
    int M = Integer.parseInt(bufferedReader.readLine());
    str = bufferedReader.readLine().split(" ");
    arr = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      arr.add(Integer.parseInt(str[i]));
    }
    
    for (int i = 0; i < M; i++) {
      int start = 0;
      int end = cards.size() - 1;
      stringBuilder.append(myBinarySearch(arr.get(i), start, end) + " ");
    }
    
    System.out.println(stringBuilder.toString());
    
  }
  
//  static int myBinarySearch(int n, int start, int end) {
//    if (start > end) return 0;
//
//    int mid = (start + end) / 2;
//    if (n < cards.get(mid)) {
//      end = mid - 1;
//      return myBinarySearch(n, start, mid - 1);
//    } else if (n > cards.get(mid)) {
//      start = mid + 1;
//      return myBinarySearch(n, start, mid + 1);
//    } else {
//      return 1;
//    }
//  }
  
  static int myBinarySearch(int n, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (cards.get(mid) == n) {
        return 1;
      } else if (cards.get(mid) > n) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return 0;
  }
  
}