import java.io.*;
// 네 번째 점
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[] xArr = new int[3];
    int[] yArr = new int[3];

    for (int i = 0; i < 3; i++) {
      String[] str = br.readLine().split(" ");
      xArr[i] = Integer.parseInt(str[0]);
      yArr[i] = Integer.parseInt(str[1]);
    }
    int x = 0;
    int y = 0;

    if(xArr[0] == xArr[1]) {
      x = xArr[2];
    } else {
      x = (xArr[0] == xArr[2]) ? xArr[1] : xArr[0];
    }

    if(yArr[0] == yArr[1]) {
      y = yArr[2];
    } else {
      y = (yArr[0] == yArr[2]) ? yArr[1] : yArr[0];
    }

    sb.append(x + " " + y);
    System.out.println(sb);
  }
}
