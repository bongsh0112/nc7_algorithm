import java.util.*;

// 대회 or 인턴
public class Main {
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  int n = sc.nextInt(); // 남자
  int m = sc.nextInt(); // 여자
  int k = sc.nextInt();
  sc.close();

  int team = 0;
  if (n + m > k) {
    team = n / 2 < m ? n / 2 : m;
    k -= (n + m) - team * 3; // rest 제외
    if (k > 0) team -= (k + 2) / 3;
  }
  System.out.println(team);
  }
}