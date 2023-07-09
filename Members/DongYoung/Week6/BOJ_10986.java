package Members.DongYoung.Week6;

import java.util.Scanner;
import java.util.HashMap;

public class BOJ_10986 {
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        String [] splitStr = scanner.nextLine().split(" ");

        int [] sum = new int [N+1];

        HashMap <Integer, Integer> map = new HashMap<>();
        long answer = 0;
        for( int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(splitStr[i-1]) % M;
            if (sum[i] % M == 0) {
                answer++;
            }
             
            if (map.containsKey(sum[i] % M)) {
                answer += map.get(sum[i] % M);
            }

            
            if (!map.containsKey(sum[i] % M)) {
                map.put(sum[i] % M, 1);
            } else {
                map.put(sum[i] % M, map.get(sum[i]% M) + 1);
            }
        }
        System.out.println(answer);
    }
}   
