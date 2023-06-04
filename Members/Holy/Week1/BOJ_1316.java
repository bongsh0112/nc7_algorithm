import java.io.*;
import java.util.*;


public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수 입력 받기
        int count = 0; // 그룹 단어의 개수를 세는 변수

        for (int i = 0; i < N; i++) {
            String word = br.readLine(); // 단어 입력 받기
            boolean[] visited = new boolean[26]; // 알파벳 방문 여부를 체크하는 배열

            char prev = word.charAt(0); // 이전 문자를 저장할 변수
            visited[prev - 'a'] = true; // 첫 번째 문자 방문 체크

            boolean isGroupWord = true; // 그룹 단어 여부를 판단하는 변수

            for (int j = 1; j < word.length(); j++) {
                char curr = word.charAt(j); // 현재 문자

                if (curr != prev) {
                    // 이전 문자와 다른 문자가 나온 경우
                    if (visited[curr - 'a']) {
                        // 이미 방문한 문자인 경우 그룹 단어가 아님
                        isGroupWord = false;
                        break;
                    } else {
                        // 처음 나온 문자이므로 방문 체크
                        visited[curr - 'a'] = true;
                        prev = curr;
                    }
                }
            }

            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);

    }
}