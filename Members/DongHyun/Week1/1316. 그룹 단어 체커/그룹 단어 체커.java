import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        int cnt = N; // cnt 변수 추가 및 초기화

        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) == word.charAt(j + 1)) {
                    continue;
                } else if (word.substring(j + 1).contains(String.valueOf(word.charAt(j)))) {
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt); // cnt 값 출력
    }
}
