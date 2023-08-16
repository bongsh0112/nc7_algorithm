package dontdothat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://comain.tistory.com/116
public class BOJ_3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // bufferedreader는 무조건 문자열로 받아오기때문에 정수형이나 실수형 변수에 저장하기 위해서는 입력과 형변환을 해줘야한다.

        String first = br.readLine(); // 20 : 00 : 00
        String secound = br.readLine(); // 04 : 00 : 00

        String[] one = first.split(":"); //[20,00,00]
        String[] two = secound.split(":"); // [04,00,00]

        int[] N = new int[3]; // 시간 차를 "시 분 초" 로 저장

        for (int i = 0; i < 3 /*N.length*/; i++) {
            N[i] = Integer.parseInt(two[i]) - Integer.parseInt(one[i]); // [-16 ,00 ,00 ]
        }

        if (first.equals(secound)) { // secound!
            System.out.println("24:00:00"); // 시작하는 시간과 기다리는 시간이 같으면 24시간이 지나감을 출력
        } else {
            if (N[2] < 0) { // 초가 0보다 작으면
                N[2] += 60; // 초에다 1초를 더해주고
                N[1]--;  // 분을 감소
            }
            if (N[1] < 0) { // 분이 0보다 작으면
                N[1] += 60; // 분에다 1분을 더해주고
                N[0]--; // 시를 감소
            }
            if (N[0] < 0) { // 시가 0보다 작으면
                N[0] += 24; // 시간에다 24를 추가  => 08
            } // 어짜피 음수라면 양수 더해 기다린 시간을 매꿈
            System.out.format("%02d:%02d:%02d", N[0], N[1], N[2]); // 2자리씩 출력 => 08 : 00 : 00
        }


        //String.format(포매팅문자열, 인수, ...);


    }
}
