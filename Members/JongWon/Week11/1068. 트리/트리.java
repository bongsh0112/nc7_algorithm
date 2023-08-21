import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int count = 0;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Map<Integer, Node> tree = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    Node root = null;
    for (int i = 0; i < N; i++) {
      tree.put(i, new Node(i));
    }
    for (int i = 0; i < N; i++) {
      int parent = Integer.parseInt(st.nextToken());
      if (parent != -1) {
        tree.get(i).parent = tree.get(parent);
        tree.get(parent).child.add(tree.get(i));
      }
      if (parent == -1)
        root = tree.get(i);
    }

    // 삭제노드가 Root면 전부 삭제기떄문
    Node delNode = tree.get(Integer.parseInt(br.readLine()));
    if (root == delNode) {
      System.out.println(0);
      return;
    }
    delNode.parent.child.remove(delNode);
    counting(root);
    System.out.println(count);
  }

  private static void counting(Node n) {
    if (n.child.size() == 0) {
      count++;
    } else {
      for (Node child : n.child) {
        counting(child);
      }
    }
  }

  static class Node {
    Node parent;
    int num;
    List<Node> child = new ArrayList<>();

    Node(int num) {
      this.num = num;
    }
  }
}
