import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] strList = new String[5];
      String temp = null;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < 5; i++) {
        temp = br.readLine();
        strList[i] = temp;
        max = Math.max(max, temp.length());
      }

      // 최대 계산 5 * 15;
      for (int i = 0; i < strList.length; i++) {
        temp = strList[i];
        if (temp.length() - max < 0) {
          String space = "";
          int loopNum = Math.abs(temp.length() - max);
          for (int j = 0; j < loopNum; j++) {
            space += " ";
          }
          strList[i] = temp + space;
        }
      }

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < max; i++) {
        for (int j = 0; j < strList.length; j++) {
          char c = strList[j].charAt(i);
          sb.append(c == ' ' ? "" : String.valueOf(c));
        }
      }
      System.out.println(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
