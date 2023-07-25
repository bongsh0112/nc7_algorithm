package src;

import java.io.*;
import java.util.*;

public class BOJ_18870 {

    class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public class Main {
        public void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Pair[] arr = new Pair[N];
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i] = new Pair(value, i);
            }

            Arrays.sort(arr);

            int[] result = new int[N];
            int cnt = 0;
            result[arr[0].index] = cnt;
            for (int i = 1; i < N; i++) {
                if (arr[i].value != arr[i - 1].value) {
                    cnt++;
                }
                result[arr[i].index] = cnt;
            }

            for (int i = 0; i < N; i++) {
                bw.write(result[i] + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }}