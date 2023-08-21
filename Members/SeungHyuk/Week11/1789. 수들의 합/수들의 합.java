import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextLong();
    long sum = 0L;
    int cnt = 0;
    sc.close();
    
    int i = 0;
    while(true) {
      sum += ++i;
      if (sum > n) break;
      cnt++;
    }
    System.out.println(cnt);
  }
}
