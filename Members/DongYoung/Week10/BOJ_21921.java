package Members.DongYoung.Week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_21921 {
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []split = br.readLine().split(" ");
        int X = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        int sum = 0;
        int cnt = 1;

        String [] arr = br.readLine().split(" ");
        int [] sumArr = new int [X+1];
        for (int i = 1; i <= X; i++) {
            sumArr[i] += sumArr[i-1] + Integer.parseInt(arr[i-1]);
        }
        for (int i = 0; i <= X; i++) {
            if (i+N > X) {
                break;
            }
            int num = sumArr[i+N] - sumArr[i];
            if (sum == num) {
                cnt ++;
            } else if (sum < num) {
                sum = num;
                cnt = 1;
            }
        }

        if (sum == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(sum);
        System.out.println(cnt);
        
    }
}
