import java.io.*;
import java.util.*;

public class BOJ_3003 {
//    킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] found = new int[6];
        int[] cf = new int[6];

        String[] st = br.readLine().split(" ");

        for (int i=0; i<chess.length; i++) {
            System.out.println(st[i]);

            //0 1 2 2 2 8
//0
//1
//2
//2
//2
//8


            found[i]=Integer.parseInt(st[i]);
            cf[i] = chess[i] - found[i];
        }
        for(int i=0; i< cf.length;i++ ) {
            System.out.printf("%d ", cf[i]);
        }
    }
}

//1 0 0 0 0 0


/*
        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        king = king - Integer.parseInt(st.nextToken());
        queen = queen - Integer.parseInt(st.nextToken());
        rook = rook - Integer.parseInt(st.nextToken());
        bishop = bishop - Integer.parseInt(st.nextToken());
        knight = knight - Integer.parseInt(st.nextToken());
        pawn = pawn - Integer.parseInt(st.nextToken());

        System.out.print(king + " ");
        System.out.print(queen + " ");
        System.out.print(rook + " ");
        System.out.print(bishop + " ");
        System.out.print(knight + " ");
        System.out.print(pawn + " ");
    }
}
        */
