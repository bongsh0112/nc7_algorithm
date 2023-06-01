package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11382 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = new String[3];
        try {
            str = br.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int a = Integer.parseInt(str[0]);

        int b = Integer.parseInt(str[1]);

        int c = Integer.parseInt(str[2]);

        System.out.println(a + b + c);
    }
}
