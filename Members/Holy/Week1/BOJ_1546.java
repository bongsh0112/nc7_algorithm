import java.io.*;
import java.util.*;

//평균

//문제
//        세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
//
//        예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
//
//        세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.


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

//입력된 점수들은 모두 실수 형태로 계산되기 때문에, 평균을 계산할 때 실수 형태로 나누고 곱하는 것이 중요
// 따라서 sum과 max 변수를 double 형태로 선언하고, 평균을 계산한 결과도 double 형태로 저장