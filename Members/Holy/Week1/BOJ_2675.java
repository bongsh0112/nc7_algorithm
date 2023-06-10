import java.io.*;
import java.util.*;

public class BOJ_2675 {
//    문자열 반복
//문제
//문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
//
//QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sf = new StringBuffer();

        int T = Integer.parseInt(br.readLine());    //앞줄 숫자 저장

        for (int i=0; i<T; i++) {
            String[] st = br.readLine().split(" "); // 맨 앞 숫자 저장 string 형식으로 저장 후 문자열 쪼갬

            int R = Integer.parseInt(st[0]);       //int 형식 변환한 첫번쨰 숫자 저장
//            String S = st[1]; //두번째 단어 string 형식으로 저장

            for(int j=0; j < st[1].length(); j++){      //각 문자 출력 횟수 지정
                for (int k=0; k< R; k++) {  //R로 지정 횟수로 출력하는 for문
                    sf.append(st[1].charAt(j));
                        }
            } sf.append("\n");
//charAt()은 String타입의 문자열에서
//해당 위치에 있는 문자만을 char타입으로 변환해
//사용할 수 있게 만들어주는 녀석
//   char = 문자열!

        }System.out.println(sf.toString());
/*
//        ---------------------------------------------

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for(int i = 0; i < T; i++) {

            int R = in.nextInt();
            String S = in.next();

            for(int j = 0; j < S.length(); j++) {
                for(int k = 0; k < R; k++) {
                    System.out.print(S.charAt(j));
                }
            }

            System.out.println();

        }

        */
        br.close();
    }
}