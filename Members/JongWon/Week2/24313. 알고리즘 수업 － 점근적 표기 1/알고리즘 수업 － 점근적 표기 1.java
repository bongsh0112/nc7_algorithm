import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] a = br.readLine().split(" ");
      int a1 = Integer.parseInt(a[0]);
      int a2 = Integer.parseInt(a[1]);
      int c = Integer.parseInt(br.readLine());
      int n0 = Integer.parseInt(br.readLine());

      int num1 = a1 * n0 + a2;
      int num2 = c * n0;

      System.out.println(num1 <= num2 && a1<=c? 1 : 0);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
