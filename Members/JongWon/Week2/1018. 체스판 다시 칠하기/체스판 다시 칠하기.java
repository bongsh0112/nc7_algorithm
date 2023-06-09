import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int SIZE = 7; // <로 비교하기 위함

    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);
    char[][] board = new char[N][M];

    for (int i = 0; i < N; i++)
      board[i] = br.readLine().toCharArray();

    int min = Integer.MAX_VALUE;
    for (int i = 0; i + SIZE < N; i++) {
      for (int j = 0; j + SIZE < M; j++) {
        // 왼쪽 상단이 W일때, B일떄 2가지 케이스를 동시에 진행해야한다. 그냥 있는 그대로 잘라버리게 되면 왼쪽 하단을 안바꿔도 되는데 바꾸는
        // 값으로 나올 수가 있슴.
        char[][] newBoard1 = new char[SIZE + 1][SIZE + 1]; // 맨 왼쪽이 'W'일떄
        char[][] newBoard2 = new char[SIZE + 1][SIZE + 1]; // 맨 왼쪽이 'B일때'
        int cnt1 = 0;
        int cnt2 = 0;

        for (int y = 0; y <= SIZE; y++) {
          for (int x = 0; x <= SIZE; x++) {
            char orgC = board[y + i][x + j]; // 기존 보드에 입력된 값
            newBoard1[y][x] = orgC;
            newBoard2[y][x] = orgC;
            if (x == 0) { // 각 문자열들의 0번째 인덱스인 경우 윗라인과 대조
              if (y == 0) { // (0,0) 첫번쨰 보드판 셋팅
                if (newBoard1[y][x] == 'B') {
                  cnt1++;
                  newBoard1[y][x] = 'W';
                } else {
                  cnt2++;
                  newBoard2[y][x] = 'B';
                }
              } else {
                if (newBoard1[y][x] == newBoard1[y - 1][x]) {
                  cnt1++;
                  newBoard1[y][x] = newBoard1[y][x] == 'W' ? 'B' : 'W';
                }
                if (newBoard2[y][x] == newBoard2[y - 1][x]) {
                  cnt2++;
                  newBoard2[y][x] = newBoard2[y][x] == 'W' ? 'B' : 'W';
                }
              }
            } else { // 각 문자열들의 1번째~체스판의 끝까지
              if (newBoard1[y][x] == newBoard1[y][x - 1]) {
                cnt1++;
                newBoard1[y][x] = newBoard1[y][x] == 'W' ? 'B' : 'W';
              }
              if (newBoard2[y][x] == newBoard2[y][x - 1]) {
                cnt2++;
                newBoard2[y][x] = newBoard2[y][x] == 'W' ? 'B' : 'W';
              }
            }

          }
        }
        int tempMin = Math.min(cnt1, cnt2);
        if (tempMin == 0) {
          System.out.println(0);
          return;
        } else {
          min = Math.min(min, tempMin);
        }
      }
    }
    System.out.println(min);
  }
}