package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8393 {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            long l = Long.parseLong(bf.readLine());
            long result = 0;

            for(int i = 0; i < l; i++) {
                result += l - i;
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
