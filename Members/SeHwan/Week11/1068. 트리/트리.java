import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
  
  static int N;
  static HashMap<Integer, Node> tree = new HashMap<>();
  static int count = 0;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    N = Integer.parseInt(bufferedReader.readLine());
    String[] str = bufferedReader.readLine().split(" ");
    int delNum = Integer.parseInt(bufferedReader.readLine());
    
    for (int i = 0; i < N; i++) {
      tree.put(i, new Node(i));
    }
    
    Node root = null;
    for (int i = 0; i < N; i++) {
      int parent = Integer.parseInt(str[i]);
      if (parent != -1) {
        tree.get(i).parent = tree.get(parent); // 자식 노드의 부모 노드를 parent 번째 노드로 설정
        tree.get(parent).childNodes.add(tree.get(i)); // 부모 노드의 자식 노드에 i번째 Node를 넣어줌
      }
      if (parent == -1) {
        root = tree.get(i);
      }
    }
    
    Node delNode = tree.get(delNum);
    if (root == delNode) {
      System.out.println(0);
      return;
    }
    
    delNode.parent.childNodes.remove(delNode);
    countLeaf(root);
    System.out.println(count);
    
  }
  
  static void countLeaf(Node node) {
    if (node.childNodes.size() == 0) {
      count++;
    } else {
      for (Node child : node.childNodes) {
        countLeaf(child);
      }
    }
  }
  
  static class Node {
    Node parent;
    int value;
    List<Node> childNodes = new ArrayList<>();
    
    public Node(int value) {
      this.value = value;
    }
  }
  
}