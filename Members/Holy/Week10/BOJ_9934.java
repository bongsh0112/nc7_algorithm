package dontdothat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
//https://nato-blog.tistory.com/162


public class BOJ_9934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = pint(br.readLine());
        int[] node = new int[(int) Math.pow(2, N) - 1];
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new LinkedList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < node.length; i++) {
            node[i] = pint(st.nextToken());
        }

        rec(list, node, 0, node.length, 0);

        for (int i = 0; i < N; i++) {
            for (Integer e : list.get(i)) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
//개인별 검정장소 조회방법: 08월 14일(월) 09시부터 [홈페이지]-[마이페이지]-[접수내역]-[상세보기]에서 개별확인(수험표출력 가능)
    static void rec(ArrayList<LinkedList<Integer>> list, int[] node,
                    int fst, int lst, int depth) {

        if (fst == lst) return;
        int mid = (fst + lst) / 2;

        list.get(depth).add(node[mid]);

        rec(list, node, fst, mid, depth + 1);//left
        rec(list, node, mid + 1, lst, depth + 1);//right
    }


    static int pint(String s) {
        return Integer.parseInt(s);
    }


}

