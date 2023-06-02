package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String word = bf.readLine();

        int n = word.length() / 2;

        for(int i = 0; i < n; i++) {
            if (word.charAt(i) == word.charAt(word.length() - 1 - i)) {
                continue;
            } else {
                sb.append(0);
                System.out.println(sb.toString());
                return;
            }
        }

        sb.append(1);
        System.out.println(sb.toString());

    }
}
