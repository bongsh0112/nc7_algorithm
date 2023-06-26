import java.util.Scanner;

public class BOJ_8393 {
  public static void main(String[] args) {
    int n, ret;
    n = ret = 0;
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    for(int i = 1; i < n+1; i++) {
      ret += i;
    }
    System.out.println(ret);
    sc.close();
  }
}
