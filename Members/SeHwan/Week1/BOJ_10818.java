package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10818 {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(bf.readLine());
            String[] str = bf.readLine().split(" ");

            int[] nums = new int[str.length];
            int f_num = Integer.parseInt(str[0]);
            int min = f_num; int max = f_num;

            for(int i = 0; i < str.length; i++){
                nums[i] = Integer.parseInt(str[i]);
                if(nums[i] > max) {
                    max = nums[i];
                } else {
                    max = max;
                }
                if(nums[i] < min) {
                    min = nums[i];
                }
                else {
                    min = min;
                }
            }

            System.out.printf("%d %d", min, max);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
