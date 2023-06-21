import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10814 {

//  177840KB	4108ms

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine());
    Person[] people = new Person[N];

    for (int i = 0; i < N; i++) {
      String[] words = bufferedReader.readLine().split(" ");
      Person p = new Person(Integer.parseInt(words[0]), words[1]);
      people[i] = p;
    }

    // 나이순으로 정렬
    Arrays.sort(people, (s1, s2) -> s1.getAge() - s2.getAge());

    for (int i = 0; i < people.length; i++) {
      System.out.printf("%d %s\n", people[i].getAge(), people[i].getName());
    }
  }

  public static class Person {
    int age;
    String name;

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public String getName() {
      return name;
    }
  }

}
