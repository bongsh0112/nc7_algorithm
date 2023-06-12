import java.util.Scanner;

public class BOJ_1978 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int No;

    No = Integer.parseInt(scanner.nextLine());

    int[] arr = new int[No];

    String[] splitList = scanner.nextLine().split(" ");
    for (int i = 0; i < splitList.length; i++) {
      arr[i] = Integer.parseInt(splitList[i]); // 분류할 수 입력
    }
    boolean isDecimal = true; // 소수 판별 결과를 알려주는 flag변수
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      isDecimal = true;
      // 밑에 for 구문에서 다음과같이 짜는이유 설명
      // 어떤수 a가 1이아닌수 b * c로 표현이되면,(공약수 존재)
      // b는 루트a보다 같거나 작고, c는 루트a보다 같거나 크다.
      // 두 수의 곱이 a가 된다 할 때,
      // 두 수가 같으면 그 수는 루트 a가 되며,
      // 두 수가 같지 않으면, 둘중 하나는 루트 a보다 작고, 나머지는 루트 a보다 크다
      // 따라서, a가 공약수가 존재하는 순간, 루트a보다 작은 공약수가 존재하기 떄문에,
      // a까지 공약수 확인을 할 필요없이, 루트 a까지만 공약수 확인을 해도 된다.
      // 따라서 j * j <= arr[i] 가 뜻하는바는 j의 제곱이 a보다 같거나 작다는 의미고
      // 다시 말해 j 는 루트 a보다 같거나 작다는 조건을 의미한다.
      for (int j = 2; j * j <= arr[i]; j++) {
        if (arr[i] % j == 0) {
          isDecimal = false;
        }
      }
      // 1은 소수가 아니기 때문에, 위의 조건을 만족해도 제외 시켜야한다.
      if (arr[i] == 1) {
        isDecimal = false;
      }
      if (isDecimal) {
        result++;
      }
    }
    System.out.println(result);
    scanner.close();
  }
}
