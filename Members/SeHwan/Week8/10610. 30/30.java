import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
  
  static ArrayList<Integer>[] graph;
  static int[] arr;
  static int N;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    String num = bufferedReader.readLine();
    String[] numArr = num.split("");
    List<Integer> numList = new ArrayList<>();
    
    int sum = 0;
    for (String s : numArr) {
      sum += Integer.parseInt(s);
      numList.add(Integer.parseInt(s));
    }
    
    if (sum % 3 == 0 && num.contains("0")) { // (끝자리에 무조건 0이 와야하므로) 0을 포함하며 각 자리의 숫자가 3의 배수라면 30의 배수이다.
      numList.sort((a, b) -> b - a);
      for (Integer integer : numList) {
        stringBuilder.append(integer);
      }
      System.out.println(stringBuilder.toString());
    } else {
      System.out.println(-1);
    }
    
  }
  
}