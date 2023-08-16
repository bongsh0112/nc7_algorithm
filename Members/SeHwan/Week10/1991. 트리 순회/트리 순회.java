import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int N = Integer.parseInt(bufferedReader.readLine());
    
    Node head = new Node("A", null, null);
    
    for(int i = 0; i < N; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      insertNode(head, str[0], str[1], str[2]);
    }
    
    preorder(head);
    System.out.println();
    inorder(head);
    System.out.println();
    postorder(head);
    System.out.println();
    
  }
  
  static class Node {
    String str;
    Node left;
    Node right;
    
    public Node(String str, Node left, Node right) {
      this.str = str;
      this.left = left;
      this.right = right;
    }
  }
  
  public static void insertNode(Node temp, String root, String left, String right) {
    if (temp.str.equals(root)) {
      temp.left = (left.equals(".") ? null : new Node(left,null,null));
      temp.right = (right.equals(".") ? null : new Node(right,null,null));
    }
    else {
      if(temp.left != null) insertNode(temp.left, root, left, right);
      if(temp.right != null) insertNode(temp.right, root, left, right);
    }
  }
  
  static void preorder(Node node) {
    if (node == null) return;
    System.out.print(node.str);
    preorder(node.left);
    preorder(node.right);
  }
  
  static void inorder(Node node) {
    if (node == null) return;
    inorder(node.left);
    System.out.print(node.str);
    inorder(node.right);
  }
  
  static void postorder(Node node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.str);
  }
  
}