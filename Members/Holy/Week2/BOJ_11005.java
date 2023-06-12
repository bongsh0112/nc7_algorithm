import java.io.*;
import java.util.*;

public class BOJ_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Character> list = new ArrayList<>(); //  새로운 ArrayList 객체를 참조하기 위한 변수

        while (N > 0) {
            int remainder = N % B;
            if (remainder < 10) {
                list.add((char)(remainder + '0'));
           } else {list.add((char)(remainder -10 +'A')); // 10 이상의 나머지 값에 대해 해당하는 문자를 구하기 위한 코드, 'A' = 65 ~ 'Z' = 90
        }
            N /= B;
        }
        for (int i = list.size()-1; i >=0; i--) {
            System.out.print(list.get(i));
        }

    }
}