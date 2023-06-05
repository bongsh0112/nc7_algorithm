package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2438 {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        {
            try {
                int num = Integer.parseInt(bf.readLine());

                for(int i = 0; i < num; i++) {
                    for(int j = 0; j <= i; j++) {
                        System.out.print('*');
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
