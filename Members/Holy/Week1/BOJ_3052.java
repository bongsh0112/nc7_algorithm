import java.io.*;
import java.util.*;


public class BOJ_3052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[42]; // 0부터 41까지의 인덱스를 사용하여 나머지 값을 체크
        int count = 0; // 서로 다른 나머지의 개수를 세는 변수

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine()); // 숫자 입력 받기
            int remainder = num % 42; // 나머지 계산

            if (!visited[remainder]) {
                // 해당 나머지가 처음 등장하는 경우
                visited[remainder] = true;
                count++;
            }
        }

        System.out.println(count);

        }
}