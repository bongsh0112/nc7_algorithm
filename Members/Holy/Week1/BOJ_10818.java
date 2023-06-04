import java.io.*;
import java.util.*;

//첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
// 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
public class BOJ_10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // N개의 정수를 공백으로 구분하여 입력 받기
        String[] numbers = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
/*
        System.out.println(N);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);        // 입력 받은 N,정수 배열 출력
        }
 */

        // 최솟값과 최댓값 구하기
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.print(min + " " + max);
        }
    }
