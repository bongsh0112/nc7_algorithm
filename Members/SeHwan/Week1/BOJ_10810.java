package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10810 {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {

            String[] nm = bf.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int[] baskets = new int[n];

            for(int i = 0; i < m; i++) {
                String[] nums = bf.readLine().split(" ");
                int start_index = Integer.parseInt(nums[0]);
                int end_index = Integer.parseInt(nums[1]);
                int ball = Integer.parseInt(nums[2]);

                for(int j = start_index - 1; j < end_index; j++) {
                    baskets[j] = ball;
                }
            }

            for(int i = 0; i < n; i++) {
                System.out.printf("%d ", baskets[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
