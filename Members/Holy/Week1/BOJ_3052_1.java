import java.io.*;
import java.util.*;

//방문 여부를 체크하는 visited 배열의 값을 출력하는 코드
public class BOJ_3052_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[42]; // 0부터 41까지의 인덱스를 사용하여 나머지 값을 체크

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine()); // 숫자 입력 받기
            int remainder = num % 42; // 나머지 계산

            visited[remainder] = true;
        }

        // visited 배열 출력
        for (boolean value : visited) {
            System.out.println(value ? 1 : 0);
        }
        }
}

//42
//84
//252
//420
//840
//126
//42
//84
//420
//126

//1
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0

//39
//40
//41
//42
//43
//44
//82
//83
//84
//85

//1
//1
//1
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//0
//1
//1
//1