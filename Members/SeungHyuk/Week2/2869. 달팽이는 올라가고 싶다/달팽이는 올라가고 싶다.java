import java.io.*;
// 달팽이는 올라가고 싶다
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String str[] = br.readLine().split(" ");
    int A = Integer.parseInt(str[0]);
    int B = Integer.parseInt(str[1]);
    int V = Integer.parseInt(str[2]);

    int day = (V - A) / (A - B);
    if ((V - A) % (A - B) != 0) day++;
    
    sb.append(day + 1 + " ");
    System.out.println(sb.toString());
  }
}