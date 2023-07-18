import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken()); // 피로
    int B = Integer.parseInt(st.nextToken()); // 일처리
    int C = Integer.parseInt(st.nextToken()); // --피로도, 음수면 0
    int M = Integer.parseInt(st.nextToken()); // 피로도 이거 넘으면 안됨

    int fati = 0; // 피로도
    int work = 0; // 일의양
   
    for (int i = 0; i < 24; i++) {
      if (fati + A <= M) {
        fati += A;
        work += B;
      } else {
        if (fati - C >= 0) 
          fati -= C;
        else 
          fati = 0;
      }
    }
    System.out.println(work);
  }
}
