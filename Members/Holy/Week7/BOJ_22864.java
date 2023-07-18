import java.io.*;
import java.util.*;

public class BOJ_22864 {
public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int tired =0, count = 0, result = 0;

        while(count != 24) {
            if (tired + A <= M){
                result += B;
                tired += A;
            } else {
                tired = tired- C <0 ? 0 : tired-C; // 피로도에서 휴식을 뺸것이 0보다 작으면 0!, 그렇지 않으면 계속 휴식!
            }
            count++;
        }
        System.out.print(result);


         }
}

