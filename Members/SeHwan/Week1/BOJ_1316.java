package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 { // 구글의 도움을 받았습니다..

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(bf.readLine());
        int cnt = n; // 현재 단어의 갯수. 여기에서 하나씩 빼면서 그룹 단어의 갯수를 뽑아낼 예정

        for(int i = 0; i < n; i++) {
            boolean[] words = new boolean[26]; // 이미 나타난 알파벳 체크
            String word = bf.readLine();
            words[(int)word.charAt(0) - 97] = true; // 주어진 word의 첫 알파벳은 나타났다고 체크
            for(int j = 1; j < word.length(); j++) {
                if(word.charAt(j - 1) == word.charAt(j)) { // 현재 검사하고 있는 글자와 이전 글자와 같다면 다음 과정 생략
                    continue;
                }
                if(words[(int)word.charAt(j) - 97]) { // 현재 검사하고 있는 글자가 나타났던 글자라면 cnt 감소, 반복문 해제
                    cnt--;
                    break;
                }
                words[(int)word.charAt(j) - 97] = true; // 현재 검사하고 있는 글자가 이전 글자와도 같지 않고 나타났던 글자도 아니라면 나타났던 글자라고 체크
            }
        }

        sb.append(cnt);
        System.out.println(cnt);

    }

}
