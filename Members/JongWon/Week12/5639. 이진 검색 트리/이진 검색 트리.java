import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    List<Integer> inputList = new ArrayList<>();
    String line;
    while (true) {
      line = br.readLine();
      if (line == null || line.equals(""))
        break;
      inputList.add(Integer.parseInt(line));
    }

    Node root = new Node(inputList.get(0));
    for (int i = 1; i < inputList.size(); i++) {
      root.insert(inputList.get(i));
    }
    System.out.println(postOrder(new StringBuilder(), root));
  }

  static StringBuilder postOrder(StringBuilder sb, Node node) {
    if (node == null)
      return sb;
    postOrder(sb, node.left);
    postOrder(sb, node.right);
    sb.append(node.num + "\n");
    return sb;
  }

  static class Node {
    int num;
    Node left, right;

    Node(int num) {
      this.num = num;
    }

    Node(int num, Node left, Node right) {
      this(num);
      this.left = left;
      this.right = right;
    }

    void insert(int n) {
      if (n < this.num) {
        if (this.left == null)
          this.left = new Node(n);
        else
          this.left.insert(n);
      } else {
        if (this.right == null)
          this.right = new Node(n);
        else
          this.right.insert(n);
      }
    }
  }

}
