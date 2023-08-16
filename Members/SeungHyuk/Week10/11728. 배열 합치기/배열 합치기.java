import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(list);
    
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < list.size(); i++) {
      sb.append(list.get(i) + " ");
    }

    System.out.println(sb.toString());
  }
}
