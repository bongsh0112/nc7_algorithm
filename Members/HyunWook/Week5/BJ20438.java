// 20438 출석체크

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N + 3];
    // 졸고 있는 학생 - 2
    // 출첵한 학생 - 1
    // 아무것도 안한 학생 - 0
    // st를 사용하여 K만큼 반복하면서 출석한 학생의 인덱스를 입력 받고, 해당 위치의 arr 값을 2로 설정합니다.
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      int idx = Integer.parseInt(st.nextToken());
      arr[idx] = 2;
    }

    // st를 사용하여 출석 체크를 할 학생의 인덱스를 입력 받습니다.
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Q; i++) {
      int idx = Integer.parseInt(st.nextToken());
      int n = 1; // n은 해당 학생이 체크되는 횟수를 나타내는 변수
      // 만약 arr[idx] 값이 2가 아닌 경우, 해당 학생이 졸고 있지 않은 경우에만 아래의 반복문을 실행합니다.
      if (arr[idx] != 2) {
        for (int idx2 = idx; idx2 < N + 3; idx2 += idx) {
          if (arr[idx2] != 2)
            arr[idx2] = 1;
          n++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    // 다음으로 M만큼 반복하면서 구간별로 출석하지 않은 학생의 수를 계산합니다.
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      // count는 출석하지 않은 학생의 수를 세는 변수입니다
      int count = 0;
      // start부터 end까지 반복하면서 arr[j] 값이 0 또는 2인 경우에만 count를 증가시킵니다.
      for (int j = start; j <= end; j++) {
        if (arr[j] == 0 || arr[j] == 2)
          count++;
      }
      // 구간별로 출석하지 않은 학생의 수를 StringBuilder인 sb에 추가합니다.
      sb.append(count).append("\n");
    }

    // 마지막으로 sb에 저장된 출석하지 않은 학생의 수를 출력합니다.
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
