import java.io.*;
import java.util.*;

public class BOJ_2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int days = (V - B -1) / (A - B) + 1;
//        (V - B -1)  :  달팽이가 막대의 높이에 도달하는데 필요한 총 높이 차이
//        / (A - B) : 달팽이가 하루에 올라갈 수 있는 높이 차이
//        + 1; : 팽이가 막대의 높이에 도달하는 직전 날까지 걸린 일수 + 1


        System.out.println(days);

    }
}