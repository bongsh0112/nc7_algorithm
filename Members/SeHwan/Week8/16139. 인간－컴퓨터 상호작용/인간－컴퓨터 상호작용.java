import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    String str = bufferedReader.readLine();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int len = str.length();
    
    int[][] sumArr = new int[len + 1][26]; // 알파벳 별 누적합 배열
    sumArr[1][str.charAt(0) - 'a']++; // str의 첫 값 누적합 증가
    
    for (int i = 2; i <= len; i++) {
      int idx = str.charAt(i - 1) - 'a'; // 현재 탐색 중인 문자의 sumArr에서의 index
      for (int j = 0; j < 26; j++) {
        int before = sumArr[i - 1][j]; // 각 알파벳 별 이전 누적합 값 받기
        sumArr[i][j] = j == idx ? before + 1 : before; // j(번째 알파벳)와 idx가 같다면 이전 것에 1 더하기
      }
    }
    
    for (int i = 0; i < N; i++) {
      String[] question = bufferedReader.readLine().split(" ");
      int idx = question[0].charAt(0) - 'a'; // 알파벳
      int l = Integer.parseInt(question[1]);
      int r = Integer.parseInt(question[2]);
      stringBuilder.append((sumArr[r + 1][idx] - sumArr[l][idx]) + "\n");
    }
    
    System.out.println(stringBuilder.toString());
    
  }
  
  
}