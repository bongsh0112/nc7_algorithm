import java.io.*;

public class Main {
  static int r,c;
  static char[][] map = new char[501][501];
  static final int[] dx = { -1, 0, 1, 0 };
  static final int[] dy = { 0, -1, 0, 1 };
  static boolean flag = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String[] str = br.readLine().split(" ");
    r = Integer.parseInt(str[0]);
    c = Integer.parseInt(str[1]);

    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {

        if (map[i][j] == 'W') {
          for (int dir = 0; dir < 4; dir++) {
            int cx = i + dx[dir];
            int cy = j + dy[dir];
            if (cx < 0 || cy < 0 || cx >= r || cy >= c) {
              continue;
            }
            else if (map[cx][cy] == 'S') {
              flag = true;
              break;
            }
          }
        } else if (map[i][j] == 'S') {
          continue;
        } else if(map[i][j] == '.'){
          map[i][j] = 'D';
        }
      }
    }

    if (flag) sb.append(""+ 0 + "\n");
    else {
      sb.append(""+ 1 + "\n");
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          sb.append(""+ map[i][j]);
        }
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }
}
