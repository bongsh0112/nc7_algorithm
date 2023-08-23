import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Node root = new Node(Integer.parseInt(bufferedReader.readLine()));
    
    while(true) {
      String str = bufferedReader.readLine();
      if (str == null) break;
      root.insert(Integer.parseInt(str));
    }
    
    postOrder(root);
    
  }
  
  static class Node {
    Node left;
    Node right;
    int key;
    
    public Node(int key) {
      this.key = key;
    }
    
    public void insert(int value) {
      if (this.key > value) { // value가 현재 기준 노드의 key값보다 작으면 왼쪽으로
        if (this.left == null) {
          this.left = new Node(value);
        } else {
          this.left.insert(value);
        }
      } else { // value가 현재 기준 노드의 key값보다 크면 오른쪽으로
        if (this.right == null) {
          this.right = new Node(value);
        } else {
          this.right.insert(value);
        }
      }
    }
  }
  
  static void postOrder(Node node) {
    if (node.left != null) postOrder(node.left);
    if (node.right != null) postOrder(node.right);
    System.out.println(node.key);
  }
  
}