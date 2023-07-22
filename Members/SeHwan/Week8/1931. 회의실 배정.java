import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
  
  static int N;
  
  static List<TimeStamp> timeList = new ArrayList<>();
  static List<Integer> startArr = new ArrayList<>(); // 회의 시작시간
  static List<Integer> endArr = new ArrayList<>(); // 회의 끝시간
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());
    int[] counts = new int[N]; // 시작시간마다 따져보는 가능한 회의의 개수
    for (int i = 0; i < N; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int start = Integer.parseInt(str[0]);
      int end = Integer.parseInt(str[1]);
      startArr.add(start);
      endArr.add(end);
      timeList.add(new TimeStamp(start, end));
    }
    
    int maxTime = Collections.max(endArr); // 끝 시간
    startArr.sort((a, b) -> a - b);
    timeList.sort((a, b) -> a.getStart() - b.getStart());
    
    /**
     * for (TimeStamp t : timeList) {
     *   System.out.println(t);
     * }
     * timeStamp = TimeStamp{start=0, end=6}
     * timeStamp = TimeStamp{start=1, end=4}
     * timeStamp = TimeStamp{start=2, end=13}
     * timeStamp = TimeStamp{start=3, end=5}
     * timeStamp = TimeStamp{start=3, end=8}
     * timeStamp = TimeStamp{start=5, end=7}
     * timeStamp = TimeStamp{start=5, end=9}
     * timeStamp = TimeStamp{start=6, end=10}
     * timeStamp = TimeStamp{start=8, end=11}
     * timeStamp = TimeStamp{start=8, end=12}
     * timeStamp = TimeStamp{start=12, end=14}
     */
    
    for (int i = 0; i < N; i++) {
      int start = startArr.get(i);
      int end = timeList.get(i).getEnd();
      int count = 1;
      boolean b = true;
      while (true) {
        start = getMinTime(end);
        if (start < 0) {
          break;
        }
        end = timeList.get(startArr.indexOf(start)).getEnd();
        count++;
      }
      
      counts[i] = count;
    }

    List<Integer> result = IntStream.of(counts).boxed().toList();
    System.out.println(Collections.max(result));
    
  }
  
  static int getMinTime(int t) {
    List<Integer> tempStartArr = new ArrayList<>(startArr);
    List<Integer> list = new ArrayList<>();
    startArr.sort((a, b) -> a - b);
    for (int i = 0; i < tempStartArr.size(); i++) {
      if (tempStartArr.get(i) >= t) {
        list.add(tempStartArr.get(i));
      }
    }
    
    if (list.isEmpty()) {
      return -1;
    } else {
      return Collections.min(list);
    }
  }
  
  static class TimeStamp {
    private int start;
    private int end;
    
    public TimeStamp(int start, int end) {
      this.start = start;
      this.end = end;
    }
    
    public int getStart() {
      return start;
    }
    
    public int getEnd() {
      return end;
    }

//    @Override
//    public String toString() {
//      return "TimeStamp{" +
//              "start=" + start +
//              ", end=" + end +
//              '}';
//    }
  }
}