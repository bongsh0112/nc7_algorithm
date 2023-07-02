package Members.DongYoung.Week5;

import java.lang.StringBuffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11660 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        String[] strSplit = br.readLine().split(" ");
        int N = Integer.parseInt(strSplit[0]);
        int M = Integer.parseInt(strSplit[1]);

        int [][] arr = new int[N][N];
        int [][] sumArr = new int[N][N];

        for(int i = 0; i < N; i++) {
            strSplit = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(strSplit[j]);
                if(j == 0) {
                    sumArr[i][j] = arr[i][j];
                } else {
                    sumArr[i][j] = sumArr[i][j-1] + arr[i][j];
                }
            }
        }

        int [] ans = new int[M];

        for(int i = 0; i < M; i++) {
            strSplit = br.readLine().split(" ");
            int x1 = Integer.parseInt(strSplit[0]);
            int y1 = Integer.parseInt(strSplit[1]);
            int x2 = Integer.parseInt(strSplit[2]);
            int y2 = Integer.parseInt(strSplit[3]);
            int sum = 0;
            for(int j = x1; j <= x2; j++) {
                sum += sumArr[j-1][y2-1] - sumArr[j-1][y1-1] + arr[j-1][y1-1];
            }
            sb.append(sum + "\n");
        }
        br.close();

        System.out.print(sb.toString().substring(0,sb.toString().length()-1));
    }

    

}
