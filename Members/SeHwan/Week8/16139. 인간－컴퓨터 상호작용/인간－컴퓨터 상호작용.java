import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  static String str;
  
  static int[] sumArr;
  
  static String target;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    str = bufferedReader.readLine();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    
    for (int i = 0; i < N; i++) {
      String[] question = bufferedReader.readLine().split(" ");
      target = question[0];
      int l = Integer.parseInt(question[1]);
      int r = Integer.parseInt(question[2]);
      String temp = str.substring(l, r + 1);
      sumArr = getSumArr(temp);
      stringBuilder.append(sumArr[r - l + 1] - sumArr[0] + "\n");
    }
    
    System.out.println(stringBuilder.toString());
    
  }
  
  static int[] getSumArr(String str) {
    sumArr = new int[str.length() + 1];
    for (int i = 1; i <= str.length(); i++) {
      if (str.charAt(i - 1) == target.charAt(0)) {
        sumArr[i] = sumArr[i - 1] + 1;
        continue;
      }
      sumArr[i] = sumArr[i - 1];
    }
    return sumArr;
  }
  
}