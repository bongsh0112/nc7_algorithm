import java.io.*;
import java.util.*;

//팰린드롬인지 확인하기 성공


public class BOJ_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();			// 문자열을 입력받는다.
        int result = 1;					// 결과를 출력할 result 선언

        int i;
        for(i=0; i<a.length(); i++) {
            char A = a.charAt(i);			// A에는 a를 순차적으로 저장

            char B = a.charAt(a.length()-1-i);	// B에는 역순으로 저장

            if( A != B ) {				// A와 B가 다를 경우
                result = 0;			// 0 저장
            }
        }
          System.out.println(result);
    }
}

//l
//l
//e
//e
//v
//v
//e
//e
//l
//l