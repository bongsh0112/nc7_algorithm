import java.io.*;
import java.util.*;

public class BOJ_1085 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X1 = Integer.parseInt(st.nextToken());
        int Y1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());
        int Y2 = Integer.parseInt(st.nextToken());

        int minDistance = X1;

//        먼저 minDistance 변수를 초기값으로 x로 설정
//        if 문과 비교 연산자를 사용하여 minDistance보다 작은 값이 있는지 확인
//        후 minDistance를 해당 값으로 갱신

//     1.
        if (minDistance >  Y1) {
            minDistance = Y1;
        }
//     2.
        if (minDistance > X2 -X1 ) {
            minDistance = X2 -X1;
        }
//     3.
        if (minDistance> Y2 - Y1) {
            minDistance = Y2 - Y1;
        }
//      최종 출력
        System.out.println(minDistance);
    }
}