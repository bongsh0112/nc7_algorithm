package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ_5597 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boolean[] students = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(bf.readLine());
            students[n - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!students[i]) System.out.println(i + 1);
        }
    }
}
