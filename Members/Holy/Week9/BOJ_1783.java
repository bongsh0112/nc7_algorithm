package dontdothat;

//        2칸 위로, 1칸 오른쪽
//        1칸 위로, 2칸 오른쪽
//        1칸 아래로, 2칸 오른쪽
//        2칸 아래로, 1칸 오른쪽
// 가로로 이동이 핵심! => 세로가 3이성아면 가로의 길이에 따라 이동횟수가 4번이상이 될 수 있다.
//오른쪽으로만 이동하는 것과 이동 횟수가 4이상일 경우 모든 조건을 한 번씩 사용해야 핵심
// https://songwonseok.github.io/algorithm/BOJ-1783/
//외안되

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 체스판의 세로 길이
        int M = Integer.parseInt(st.nextToken());//  체스판의 가로 길이

      int result = 0;

      if (N == 1) { // 세로 1면 이동칸수는 1
          result = 1;
      } else if (N == 2) { // 세로 2면 이동칸수는 가로의 길이에 따라
          if (M >8){ // 8이상이면  1번경우 (2칸 위로, 1칸 오른쪽) 가능하기에 4칸
              result = 4;
          } else result = M/2;
      } else if (N >= 3) {
          // M=7 부터 4방향 다 이동 가능
          // 4방향 다 이동한 후에는 y값이 1씩 증가하는 1번,4번 이동을 반복
          // 즉, M-2개의 칸 이동
          if(M < 7) {
              result = Math.min(M, 4);
          }else {
              result = M-2;
          }
      }

// 만약 세로 길이 N이 1이라면, 이동할 수 있는 경우의 수는 1입니다.
// 세로 길이 N이 2라면, 가로 길이 M이 8보다 크다면 1번 조건을 이용하여 이동할 수 있으므로 4칸을 이동합니다. 그렇지 않으면 가로 길이의 절반인 M/2칸을 이동합니다.
// 세로 길이 N이 3 이상이라면, 가로 길이 M이 7 미만이라면 1번 조건과 4번 조건을 최대한 활용하여 이동할 수 있는 칸의 수를 계산합니다. 그렇지 않으면 M-2칸을 이동합니다.



        System.out.println(result);
    }
}
