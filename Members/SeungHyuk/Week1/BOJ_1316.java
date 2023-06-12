import java.io.*;

public class BOJ_1316 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    int cnt = 0;

    for (int i = 0; i < tc; i++) { // tc 별 시작
      int[] alpha = new int[26];
      String str = br.readLine();

      for (int j = 0; j < str.length(); j++) {
        if (j == str.length() -1) { // 끝 -1까지
          cnt++; // 완료시 체크, 이건 그룹단어임!
          break;
        }
        // int cur = str.charAt(j) - 97;
        // int next = str.charAt(j+1) - 97;
        alpha[str.charAt(j) - 97] = 1; // 현재 단어를 체크하자

        if (str.charAt(j) - 97 == str.charAt(j+1) - 97) { // 둘이 같으면 검사 x
          continue;
        }

        if (alpha[str.charAt(j+1) - 97] == 1){ // 만약 있던 단어라면, 그룹단어 아니다~
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}