package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3003 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int[] chess = {1, 1, 2, 2, 2, 8};
        String[] str = bf.readLine().split(" ");
        int[] foundPieces = new int[6];
        for(int i = 0; i < 6; i++) {
            foundPieces[i] = Integer.parseInt(str[i]);
            chess[i] = chess[i] - foundPieces[i];
        }

        for(int i = 0; i < 6; i++) {
            sb.append(chess[i] + " ");
        }
        System.out.println(sb.toString());
    }


}
