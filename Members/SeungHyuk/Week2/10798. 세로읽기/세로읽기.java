import java.io.*;
// 세로읽기
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    char[][] chArr = new char[5][15];
    //int maxLen = 0;
    for (int i = 0; i < 5; i++) {
      String str = br.readLine();
      //if (maxLen < str.length()) {
      //  maxLen = str.length();
      //}
      for (int j = 0; j < str.length(); j++) {
        chArr[i][j] = str.charAt(j);
      }
    }

    for (int j = 0; j < 15; j++) {
      for (int i = 0; i < 5; i++) {
        if (chArr[i][j] == '\0') continue;
        sb.append(chArr[i][j]);
      }
    }
    
    System.out.println(sb);
  }
}
