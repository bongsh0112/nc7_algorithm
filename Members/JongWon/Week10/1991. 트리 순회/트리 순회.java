import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static class Node {
    char left;
    char right;

    Node(char left, char right) {
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Map<Character, Node> tree = new HashMap<>();

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      tree.put(st.nextToken().charAt(0),
          new Node(st.nextToken().charAt(0), st.nextToken().charAt(0)));
    }
    StringBuilder sb = new StringBuilder()
        .append(preorder(tree, 'A', new StringBuilder())).append("\n")
        .append(inorder(tree, 'A', new StringBuilder())).append("\n")
        .append(postorder(tree, 'A', new StringBuilder()));

    System.out.println(sb);

  }

  private static StringBuilder preorder(Map<Character, Node> tree, char root, StringBuilder sb) {
    if (root == '.')
      return sb;
    sb.append(root);
    preorder(tree, tree.get(root).left, sb);
    preorder(tree, tree.get(root).right, sb);
    return sb;
  }

  private static StringBuilder inorder(Map<Character, Node> tree, char root, StringBuilder sb) {
    if (root == '.')
      return sb;
    inorder(tree, tree.get(root).left, sb);
    sb.append(root);
    inorder(tree, tree.get(root).right, sb);
    return sb;
  }

  private static StringBuilder postorder(Map<Character, Node> tree, char root, StringBuilder sb) {
    if (root == '.')
      return sb;
    postorder(tree, tree.get(root).left, sb);
    postorder(tree, tree.get(root).right, sb);
    sb.append(root);
    return sb;
  }

}
