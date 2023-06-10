import java.util.Scanner;
import java.lang.Math;

public class BOJ_1085 {
    public static void main(String [] Args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        int w;
        int h;

        String[] splitList = scanner.nextLine().split(" ");
        x = Integer.parseInt(splitList[0]);
        y = Integer.parseInt(splitList[1]);
        w = Integer.parseInt(splitList[2]);
        h = Integer.parseInt(splitList[3]);

        //가로 기준 최소
        int rowMin = Math.min(x, w-x);
        //세로 기준 최소
        int columnMin = Math.min(y, h - y);

        //경계선까지 가는 최소
        int minDistance = Math.min(rowMin,columnMin);

        System.out.println(minDistance);

    }
}
