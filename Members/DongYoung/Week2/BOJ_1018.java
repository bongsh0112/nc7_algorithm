import java.util.Scanner;

public class BOJ_1018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width, height;

        String [] splitList = scanner.nextLine().split(" ");

        width = Integer.parseInt(splitList[1]);
        height = Integer.parseInt(splitList[0]);

        String [] stringBuffer = new String [height];

        for(int i = 0; i < height; i++) {
            stringBuffer[i] = scanner.nextLine();
        }

        int [][] chessBoard = new int [height][width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(stringBuffer[i].charAt(j) == 'W') {
                    chessBoard[i][j] = 1;
                } else {
                    chessBoard[i][j] = 0;
                }
            }
        }
        int minNum = 64;
        int count = 0;
        for(int i = 0; i <height - 7; i++) {
            for(int j = 0; j < width - 7; j++) {
                //두가지 경우로 나눈다. 첫번째, 체스판 제일 왼쪽위가 W 인경우와 B 인경우로 나눠서 각각 바꾸는데 필요한 수를 산출하여 최소의 값을 저장한다.
                count = 0;
                int sum1;
                int sum2;
                //case1 제일왼쪽 위가 W인경우
                for(int k = 0; k < 8; k++) {
                    for(int l = 0; l < 8; l++) {
                        if( (l + k) % 2 == 0) {
                            count = chessBoard[i+k][j+l] != 1 ? count+ 1: count ; 
                        } else {
                            count = chessBoard[i+k][j+l] != 0 ? count+ 1: count ;
                        }
                    }
                }
                sum1 = count;
                //case2 제일왼쪽 위가 M인경우
                count = 0;
                for(int k = 0; k < 8; k++) {
                    for(int l = 0; l < 8; l++) {
                        if( (l + k) % 2 == 0) {
                            count = chessBoard[i+k][j+l] != 0 ? count+ 1: count ; 
                        } else {
                            count = chessBoard[i+k][j+l] != 1 ? count+ 1: count ;
                        }
                    }
                }
                sum2 = count;
                minNum = Math.min(minNum, Math.min(sum1,sum2));
            }
        }
        System.out.println(minNum);      
    }
}
