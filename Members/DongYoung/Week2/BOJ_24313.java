import java.util.Scanner;

public class BOJ_24313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 함수 정리하면,  모든  (c - a1)n >= n0 * (c - a1) 에 대하여,   n(a1 - c) <= - a0  == > (c - a1)n >= a0 / 
        // 정리과정 1.     모든 n >= n0에 대하여,  f(n) <= c * g(n)인 상수 c와 n0 존재
        // 여기서 앞에  n >= n0 를 1번부등호    f(n) <= c*g(n) 을 2번 부등호 라 하면,
        // 위의 말을 해석해보면, 1번 부등호를 만족하는 n에 대하여, 2번 부등호를 만족시키는 c와 n0가 존재 --> 즉, c와 n0가 주어질때  1번 부등호를 만족하면 2번 부등호도 만족한다는 의미이다.
        // 2. 2번식을 보면, f(n) = a1 * n + a0 ,  g(n) 에 대해서는 문제 조건에서 g(n)에 대한 설명이 없지만 두개의 예시에 전부 g(n) = n 이라 하고있으므로 g(n) = n 이라 하자
        // 3. 1번 부등호조건과 2번 부등호 조건을 위의 함수 표현식을 이용해 적용하면 1) : n >= n0   2) : a1 * n + a0 <= c * n 이다.
        // 4. 2번 부등식을 n기준으로 변경하면 --> (a1 * n)  -  (c * n) <= - a0
        // 5. 2번 부등식에 양변에 -1을 곱하면, n * (c - a1) * n >= a0  이다.  여기서, 부등식에 음수를 곱하면 부호 방향이 바뀌는걸 인지하고 있어야한다.
        // 6. 2번 부등식과 1번 부등식을 비교하기 좋게 하기위해  (c-a1) 을 1번 부등식 양변에 곱해주면, (이때  c - a1 이 음수일떄와 음수가 아닐때 나눠야한다);
        // 첫줄의 정리된 함수 형태가 나온다.

        // 여기서 1번식이 만족하면 2번식도 만족해야 하는데 O(g(n)) 의 성립 조건 이므로,   2번식이 1번식의 범위를 포함해야한다.
        // 따라서 a0가 n0 * (c - a1) 보다 같거나 작아야한다.

        int a1;
        int a0;

        String []splitList = scanner.nextLine().split(" ");
        a1 = Integer.parseInt(splitList[0]);
        a0 = Integer.parseInt(splitList[1]);

        int c = scanner.nextInt();
        scanner.nextLine();

        int n0 = scanner.nextInt();
        scanner.nextLine();

        
        // 함수식을 보면 n이 1차 함수(선형) 이기때문에 한번 a0 보다 커지면 그 이후는 무조껀 a0 보다 커진다

        // 즉 n0일떄 해당 부등식을 만족하면 1, 만족하지 못하면 0이다

        if( a0 <= n0 * (c - a1) && c >= a1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        scanner.close();
    }
}
