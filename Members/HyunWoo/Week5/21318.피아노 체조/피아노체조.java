import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 악보의 개수 입력 받기
        int N = scanner.nextInt();

        // 악보의 난이도 배열 생성 및 입력 받기
        int[] difficulties = new int[N];
        for (int i = 0; i < N; i++) {
            difficulties[i] = scanner.nextInt();
        }

        // 질문의 개수 입력 받기
        int Q = scanner.nextInt();

        // 각 질문에 대한 처리
        for (int i = 0; i < Q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int mistakeCount = calculateMistakes(difficulties, x, y);
            System.out.println(mistakeCount);
        }

        scanner.close();
    }

    // 실수하는 곡의 개수 계산하는 함수
    private static int calculateMistakes(int[] difficulties, int x, int y) {
        int mistakeCount = 0;
        int currentDifficulty = difficulties[x - 1]; // 첫 번째 악보의 난이도

        for (int i = x; i < y; i++) {
            int nextDifficulty = difficulties[i];
            if (currentDifficulty > nextDifficulty) {
                mistakeCount++;
            }
            currentDifficulty = nextDifficulty;
        }

        return mistakeCount;
    }
}

// 시간초과 
