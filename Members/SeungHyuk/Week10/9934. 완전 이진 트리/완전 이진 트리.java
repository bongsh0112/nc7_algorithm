import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    Queue<Point> queue = new LinkedList<>();
    int qSize, mid;
    Point cur;

    int K = Integer.parseInt(br.readLine());
    int num = (int) Math.pow(2, K) - 1;
    int[] list = new int[num];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < num; i++) {
        list[i] = Integer.parseInt(st.nextToken());
    }

    queue.add(new Point(0, num - 1));

    while (!queue.isEmpty()) {
      qSize = queue.size();

      for (int i = 0; i < qSize; i++) {
        cur = queue.poll();
        mid = (cur.left + cur.right) / 2;
        sb.append(list[mid]).append(" ");

        if (cur.left != cur.right) {
          queue.add(new Point(cur.left, mid - 1));
          queue.add(new Point(mid + 1, cur.right));
        }
      }

      sb.append("\n");
    }

    System.out.print(sb);

  }

  public static class Point{
    int left, right;

    Point(int left, int right) {
        this.left = left;
        this.right = right;
    }
  }

}