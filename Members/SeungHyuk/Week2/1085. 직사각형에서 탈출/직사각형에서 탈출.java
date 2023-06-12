import java.io.*;
// 직사각형에서 탈출
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");

    int x = Integer.parseInt(str[0]);
    int y = Integer.parseInt(str[1]);
    int w = Integer.parseInt(str[2]);
    int h = Integer.parseInt(str[3]);

    int xMin = Math.min(x, w - x);
    int yMin = Math.min(y, h - y);
    
    System.out.println(Math.min(xMin, yMin));
  }
}
