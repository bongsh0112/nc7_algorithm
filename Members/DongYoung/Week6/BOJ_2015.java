package Members.DongYoung.Week6;

import java.util.Scanner;
import java.util.HashMap;

public class BOJ_2015 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        String[] splitStr = scanner.nextLine().split(" ");
        long answer = 0;
        int [] sum = new int [splitStr.length+1];
        HashMap <Integer,Long> map = new HashMap<>();

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(splitStr[i-1]);
            //부분합 구하기
            if( sum[i] == K) {
                answer++;
            }

            if (map.containsKey(sum[i] - K)) {
                answer+= map.get(sum[i]-K);
            }

            if (!map.containsKey(sum[i])) {
                map.put(sum[i], 1L);
            } else {
                map.put(sum[i],map.get(sum[i]) + 1);
            }

        }

        System.out.println(answer);
        scanner.close();
    }
}
