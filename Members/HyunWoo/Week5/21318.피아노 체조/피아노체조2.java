import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 악보의 개수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 악보의 난이도 리스트 생성 및 입력 받기
        List<Integer> difficulties = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            difficulties.add(Integer.parseInt(st.nextToken()));
        }

        // 질문의 개수 입력 받기
        int Q = Integer.parseInt(br.readLine());

        // 각 질문에 대한 처리
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int mistakeCount = calculateMistakes(difficulties, x, y);
            System.out.println(mistakeCount);
        }

        br.close();
    }

    // 실수하는 곡의 개수 계산하는 함수
    private static int calculateMistakes(List<Integer> difficulties, int x, int y) {
        int mistakeCount = 0;
        int currentDifficulty = difficulties.get(x - 1); // 첫 번째 악보의 난이도

        for (int i = x; i < y; i++) {
            int nextDifficulty = difficulties.get(i);
            if (currentDifficulty > nextDifficulty) {
                mistakeCount++;
            }
            currentDifficulty = nextDifficulty;
        }

        return mistakeCount;
    }
}

