import java.util.Scanner;

public class BOJ_3009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int [][] xyCoordinate = new int[3][2];

        for(int i = 0; i < 3; i++) {
            String [] splitList = scanner.nextLine().split(" ");
            xyCoordinate[i][0] = Integer.parseInt(splitList[0]);
            xyCoordinate[i][1] = Integer.parseInt(splitList[1]);
        }

        int x, y;
        x = 0;
        y = 0;

        if( xyCoordinate[0][0] == xyCoordinate[1][0]) {
            x = xyCoordinate[2][0];
        }
        if( xyCoordinate[1][0] == xyCoordinate[2][0]) {
            x = xyCoordinate[0][0];
        }
        if( xyCoordinate[0][0] == xyCoordinate[2][0]) {
            x = xyCoordinate[1][0];
        }

        if( xyCoordinate[0][1] == xyCoordinate[0][1]) {
            y = xyCoordinate[2][1];
        }
        if( xyCoordinate[1][1] == xyCoordinate[2][1]) {
            y = xyCoordinate[0][1];
        }
        if( xyCoordinate[0][1] == xyCoordinate[2][1]) {
            y = xyCoordinate[1][1];
        }

        System.out.printf("%d %d",x,y);



    }
}
