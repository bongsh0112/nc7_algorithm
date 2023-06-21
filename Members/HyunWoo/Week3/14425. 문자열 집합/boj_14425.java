import java.util.Scanner;

public class boj_14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리
        
        String[] S = new String[N];
        
        for (int i = 0; i < N; i++) {
            S[i] = sc.nextLine();
        }
        
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            if (isIncluded(S, str)) {
                count++;
            }
        }
        
        System.out.println(count);
        
        sc.close();
    }
    
    private static boolean isIncluded(String[] S, String str) {
        for (String s : S) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}

// 시간 초과 
