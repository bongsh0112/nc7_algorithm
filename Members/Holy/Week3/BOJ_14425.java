package Algo_study;

import java.io.*;
import java.util.*;

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        HashSet<String> sets = new HashSet<>();
        //HashSet을 사용하여 집합 S의 문자열들을 저장하고, 입력받은 문자열들이 집합 S에 속하는지 검사하여 개수를 계산
        for (int i=0; i<N; i++) {
            sets.add(br.readLine());
        }

        int count = 0;
        for (int i=0; i<M; i++){            // 카운트는 M
            if (sets.contains(br.readLine())){
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        // StringBuilder를 사용하여 문자열을 누적시키고, 마지막에 한 번에 출력함으로써 성능을 향상
        sb.append(count + "\n");

        System.out.println(sb);



    }


}
