import java.util.Scanner;
public class BOJ_2798 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N, M;

        String[] splitList = scanner.nextLine().split(" ");
        N = Integer.parseInt(splitList[0]);
        M = Integer.parseInt(splitList[1]);
        int [] cards = new int [N];

        for(int i = 0; i < N; i++) {
            cards[i] =scanner.nextInt();
        }
        //scanner.nextLine();
        int num = 0;
        loop1: for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    int a1 = cards[i] + cards[j] + cards[k];
                    if(a1 > num && a1 <= M ) {
                        num = a1;
                        if (num == M) {
                            break loop1;
                        }
                    }
                }
            }
        }
        System.out.println(num);
        scanner.close();
    }
}
