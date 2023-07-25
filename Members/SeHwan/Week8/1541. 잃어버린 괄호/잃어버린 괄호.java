import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    /** 모든 연산자가 + 혹은 - 로 통일되면 괄호를 칠 필요가 없다.
     *  - 뒤에 +가 연속으로 나온다면 그부분만 괄호처리해주면 된다.
     */
    String expression = bufferedReader.readLine();
    String[] temp = expression.split("\\+|-"); // 정규표현식 : +나 -로 문자열을 분리한다.
    List<Integer> nums = new ArrayList<>();
    for (String num : temp) {
      nums.add(Integer.parseInt(num));
    }
    
    temp = expression.split("\\d"); // 정규표현식 : 0~9의 숫자로 문자열을 분리한다.
    List<String> operators = new ArrayList<>();
    for (String operator : temp) {
      if (operator.equals("+") || operator.equals("-")) {
        operators.add(operator);
      }
    }
    
    int answer = 0;
    if (needBracket(operators)) { // 만약 괄호를 쳐야하는 식이라면
      temp = expression.split("-"); // -로 식을 split
      List<Integer> tempArr = new ArrayList<>(); // +로 묶이는 것들과 나머지들을 넣을 tempArr
      for (String s : temp) {
        if (s.contains("+")) { // 밑으로는 +로 묶인 애들을 계산하고 tempArr에 저장
          temp = s.split("\\+");
          int tempSum = 0;
          for (String t : temp) {
            tempSum += Integer.parseInt(t);
          }
          tempArr.add(tempSum);
        } else { // +로 묶이지 않은 애들은 그냥 tempArr에 저장
          tempArr.add(Integer.parseInt(s));
        }
      }
      answer = tempArr.get(0);
      for (int i = 1; i < tempArr.size(); i++) {
        answer -= tempArr.get(i);
      }
    } else { // 괄호를 안쳐도 되는 식이라면
      answer = nums.get(0); // 첫 번째 원소부터 더한다\
      for (int i = 0; i < operators.size(); i++) { // 연산자와 숫자 인덱스의 관계 -> i번째 연산자를 i + 1 숫자에 적용
//        if (operators.get(i).equals("+")) {
//          answer += nums.get(i + 1
//        } else {
//          answer -= nums.get(i + 1);
//        }
        answer = operators.get(i).equals("+") ? answer + nums.get(i + 1) : answer - nums.get(i + 1);
      }
    }
    
    System.out.println(answer);
    
  }
  
  public static boolean needBracket(List<String> list) { // 괄호를 꼭 쳐야하는 식인지 판별한다
    int idx = -1;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals("-")) {
        idx = i;
        break;
      }
    }
    // -가 처음으로 나온 인덱스 구하기
    
    if (idx < 0) { // -가 아예 없는 상황. idx가 -1일 것이다.
      return false; // 괄호를 안쳐도 됨!
    }
    
    boolean b = false; // 만약 - 뒤에 +가 하나라도 나온다면 true
    for (int i = idx + 1; i < list.size(); i++) {
      if (list.get(i).equals("+")) {
        b = true;
        break;
      }
    }
    
    return b;
  }
}