import java.util.Scanner;

public class BOJ_10869 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = 0;
    int b = 0;
    a = sc.nextInt();
    b = sc.nextInt();
    
    System.out.println(a+b);
    System.out.println(a-b);
    System.out.println(a*b);
    System.out.println(a/b);
    System.out.println(a%b);

    sc.close();
  }
}
