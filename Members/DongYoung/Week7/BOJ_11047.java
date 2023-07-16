package Members.DongYoung.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String[] splitStr= str.split(" ");
        int N = Integer.parseInt(splitStr[0]);
        int M = Integer.parseInt(splitStr[1]);
        int [] moneys = new int [N];
        for ( int i = 0; i < N; i++) {
            moneys[N-1-i] = Integer.parseInt(bf.readLine());
        }

        int ans  = 0;
        for (int i = 0; i < moneys.length; i++) {
            ans += M / moneys[i];
            M = M %moneys[i];
        }
        System.out.println(ans);
        bf.close();

    }
}
