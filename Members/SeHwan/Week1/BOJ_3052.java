package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3052 {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] mods = new int[42];
        Arrays.fill(mods, 0);

        for (int i = 0; i < 10; i++) {

            int n = Integer.parseInt(bf.readLine());
            int mod = n % 42;
            mods[mod] = 1;

        }

        int cnt = 0;

        for(int i = 0; i < 42; i++) {
            if(mods[i] > 0) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}
