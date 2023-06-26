import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String string = br.readLine();
      int a = Integer.parseInt(string.split(" ")[0]);
      int b = Integer.parseInt(string.split(" ")[1]);
      bw.write(a + b + "\n");
    }
    bw.flush();
  }
}