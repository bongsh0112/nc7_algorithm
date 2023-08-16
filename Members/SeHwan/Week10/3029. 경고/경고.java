import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    String[] start = bufferedReader.readLine().split(":");
    String[] end = bufferedReader.readLine().split(":");
    
    if (start[0].equals(end[0]) && start[1].equals(end[1]) && start[2].equals(end[2])) {
      System.out.println("24:00:00");
      return;
    }
    
    int h = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
    int m = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
    int s = Integer.parseInt(end[2]) - Integer.parseInt(start[2]);
    
    if (s < 0) {
      s += 60;
      --m;
    }
    if (m < 0) {
      m += 60;
      --h;
    }
    if (h < 0) {
      h += 24;
    }
    
    System.out.printf("%02d:%02d:%02d", h, m, s);
    
  }
  
}