package Members.Holy.Week6;
//https://velog.io/@isohyeon/Java-%EB%B0%B1%EC%A4%80-10986-%EB%82%98%EB%A8%B8%EC%A7%80-%ED%95%A9


import java.io.*;
import java.util.*;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 나누기 할 수
        long result = 0;// M으로 나누어 떨어지는 (i,j) 쌍의 개수
        long[] S = new long[N +1]; // 합의 배열
        long[] cnt = new long[N +1]; // 같은 나머지 인덱스를 카운트 하는 배열

        st = new StringTokenizer(br.readLine());
        for (int i=1; i< N+1; i++) {
            S[i] = (S[i-1] + Integer.parseInt(st.nextToken())) %M ;

            if (S[i] == 0) {
                result++;
            }
            cnt[(int) S[i]]++;
        }

        for (int i=0; i < M; i++) {
        if (cnt[i] > 1) {
            result += (cnt[i]* (cnt[i]-1) / 2); //  nC2와 같은 공식
            }
        }
//        배열 cnt에서 같은 나머지를 가지는 원소의 개수를 카운트한 배열
//        이 코드는 각 나머지별로 나타나는 원소의 개수를 확인하고, 같은 나머지를 가지는 원소의 쌍의 개수를 계산
        System.out.println(result);
    }
}
