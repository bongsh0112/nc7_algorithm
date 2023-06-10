package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(bf.readLine());
        for(int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");
            int repeat = Integer.parseInt(str[0]);

            for(int j = 0; j < str[1].length(); j++) {
                for(int k = 0; k < repeat; k++) {
                    sb.append(str[1].charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

}
