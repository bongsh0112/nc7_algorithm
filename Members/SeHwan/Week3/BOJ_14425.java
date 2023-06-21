import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14425 {

//  30824KB	2632ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();

    String[] nums = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(nums[0]); String[] wordsToFind = new String[N];
    int M = Integer.parseInt(nums[1]); String[] wordList = new String[M];

    for (int i = 0; i < N; i++) {
      wordsToFind[i] = bufferedReader.readLine();
    }

    int count = 0;

    for (int i = 0; i < M; i++) {
      String temp = bufferedReader.readLine();
      for (int j = 0; j < N; j++) {
        if (temp.equals(wordsToFind[j])) {
          count++;
        }
      }
    }

    stringBuffer.append(count);
    System.out.println(stringBuffer.toString());

  }

}
