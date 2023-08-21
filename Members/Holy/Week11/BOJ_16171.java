package dontdothat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16171 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String pattern = br.readLine();

        input = input.replaceAll("[0-9]",""); // q w e r t y
        int patLen = pattern.length(); // 6
        boolean flag = false;

        for (int i=0; i< input.length(); i++) {
            if (input.substring(i, patLen).equals(pattern)) {
                flag = true;
            }
        }
        System.out.println(flag ? 1: 0);
    }
}
