package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1152 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int count = 0;
        for (String s : str) {
            if (!s.equals("")) {
                count++;
            }
        }

        System.out.println(count);
    }

}
