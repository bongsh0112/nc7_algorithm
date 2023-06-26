import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] xywh = br.readLine().split(" ");
      int x = Integer.parseInt(xywh[0]);
      int y = Integer.parseInt(xywh[1]);
      int w = Integer.parseInt(xywh[2]);
      int h = Integer.parseInt(xywh[3]);

      int numX = Math.min(x, w - x);
      int numY = Math.min(y, h - y);

      System.out.println(Math.min(numX, numY));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
