package Members.DongYoung.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class BOJ_22864 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bf.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        int C = Integer.parseInt(split[2]);
        int M = Integer.parseInt(split[3]);

        //일을한다 -> M을 넘기지 않는선에서 일하고 쉰다 -> 쉬다가 1시간 일가능하면 일한다
        int totalTired = 0;
        int totalWork = 0;
        for (int i = 0; i < 24; i++) {
            if (totalTired + A <= M) {
                totalTired += A;
                totalWork += B;
                continue;
            } else {
                totalTired = Math.max(0,totalTired - C);
                

            }
        }
        System.out.println(totalWork);
    }
}
