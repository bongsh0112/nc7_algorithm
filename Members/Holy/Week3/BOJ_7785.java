package Algo_study;
import java.io.*;
import java.util.*;


public class BOJ_7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i=0; i< N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];


            if (status.equals("enter")){
                set.add(name);
            } else {
            set.remove(name);
            }
        }
        List<String> list = new ArrayList<>(set); //  sortedList의 요소들을 기본 정렬 순서와 반대로 정렬하여 사전 역순으로 만드는 역할
        Collections.sort(list, Collections.reverseOrder());

        for (String name : list){
            System.out.println(name);
        }


    }
}
