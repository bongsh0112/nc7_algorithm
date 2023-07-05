package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);
    
    int[] sum = new int[N + 1];
    str = bufferedReader.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i - 1] + Integer.parseInt(str[i - 1]);
    }
    
    /**
     * sum[i] - sum[j] 로 부분 누적합을 구할 때 sum[i], sum[j] 둘 다 M으로 나누어 떨어지면 조건이 성립한다.
     */
    
    BigInteger count = BigInteger.ZERO;
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    
    for (int i = 1; i <= N; i++) {
      int mod = sum[i] % M;
      set.add(mod);
      if (mod == 0) { // 누적합을 나눴을 때 나머지가 0이라면 count 증가
        count = count.add(BigInteger.ONE);
      }
      
      if (!map.containsKey(mod)) { // 누적합의 나머지가 map에 key로 없다면 넣어주기
        map.put(mod, 1);
      } else {
        map.put(mod, map.get(mod) + 1); // 누적합의 나머지가 이미 map에 key로 있다면 value 1 증가
      }
      
    }
    
    // 부분합 배열을 이용하여 누적합 값을 구할 때 나머지가 같은 값끼리 빼기 계산을 한다면 나머지가 0이다.

//    List<Integer> list = set.stream().toList();
    List<Integer> list = new ArrayList<>();
    list = set.stream().collect(Collectors.toList());
    
    for (int i = 0; i < list.size(); i++) {
      count = count.add(combination(map.get(list.get(i)), 2));
    }
    
    System.out.println(count.toString());
    
  }
  
  static BigInteger combination(int n, int k) {
    BigInteger a = factorial(BigInteger.valueOf((long)n));
    BigInteger b = factorial(BigInteger.valueOf((long)(n-k)));
    BigInteger c = factorial(BigInteger.valueOf((long)(k)));
    return a.divide(b.multiply(c));
  }
  
  static BigInteger factorial(BigInteger n) {
    if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
      return BigInteger.ONE;
    }
    return n.multiply(n.subtract(BigInteger.ONE));
  }
//    8 5
//    2 3 5 7 4 3 1 2
//    => 9

}