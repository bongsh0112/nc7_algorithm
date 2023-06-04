import java.io.*;
import java.util.*;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 과목 개수 입력 받기
        String[] scores = br.readLine().split(" "); // 각 과목의 점수 입력 받기

        double sum = 0;
        double max = Integer.parseInt(scores[0]);

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(scores[i]);
            sum += score;

            if (score > max) {
                max = score;
            }
        }

        double average = (sum / max) * 100 / N;
        System.out.println(average);

        }

    }

//입력된 점수들은 모두 실수 형태로 계산되기 때문에, 평균을 계산할 때 실수 형태로 나누고 곱하는 것이 중요합니다.
// 따라서 sum과 max 변수를 double 형태로 선언하고, 평균을 계산한 결과도 double 형태로 저장합니다.