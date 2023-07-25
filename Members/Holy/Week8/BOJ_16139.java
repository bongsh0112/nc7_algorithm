package src;



//예제
//seungjaehwang
//        4
//        a 0 5
//        a 0 6
//        a 6 10
//        a 7 10


import java.util.*;
        import java.io.*;
 public class BOJ_16139{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // seungjaehwang
        int[][] sum = new int[S.length()][26]; // [몇번째 문자인지][어떤 알파벳이 추가됐는지] : 영어 알파벳은 총 26개


        // 1번째 초기화
        sum[0][S.charAt(0) - 'a']++; // 첫 번째 문자를 알파벳 인덱스로 변환하여 해당 인덱스의 누적합을 증가

//        sum[0][18] = 1 // 's'
//        sum[1][4] = 1  // 'e'
//        sum[2][20] = 1 // 'u'
//        sum[3][13] = 1 // 'n'
//        sum[4][6] = 1  // 'g'
//        sum[5][9] = 1  // 'j'
//        sum[6][0] = 1  // 'a'
//        sum[7][4] = 2  // 'e'
//        sum[8][7] = 1  // 'h'
//        sum[9][22] = 1 // 'w'
//        sum[10][0] = 1 // 'a'
//        sum[11][13] = 2 // 'n'
//        sum[12][6] = 2 // 'g'



//            sum[0][18] = 1 // 's'

//            sum[1][4] = 1  // 'e'
//            sum[2][20] = 1 // 'u'
//            sum[3][13] = 1 // 'n'
//            sum[4][6] = 1  // 'g'
//            sum[5][9] = 1  // 'j'
//            sum[6][0] = 1  // 'a'
//            sum[7][4] = 2  // 'e'
//            sum[8][7] = 1  // 'h'
//            sum[9][22] = 1 // 'w'
//            sum[10][0] = 1 // 'a'
//            sum[11][13] = 2 // 'n'
//            sum[12][6] = 2 // 'g'


        // 1~끝까지 누적합 구하기
        for(int i = 1; i < S.length(); i++) {
            int tmp = S.charAt(i) - 'a';




            for(int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j]; // 이전 누적합을 현재 누적합으로 갱신하기 위해서
                // 구간 [0, i - 1]과 구간 [0, i] 사이의 알파벳 j의 등장 횟수가 동일
            }

//i => 1
//sum[1][0] = sum [0][0]
//sum[1][1] = sum [0][1]
//sum[1][2] = sum [0][2]
//sum[1][3] = sum [0][3]
//sum[1][4] = sum [0][4]
//sum[1][5] = sum [0][5]
//sum[1][6] = sum [0][6]
//sum[1][7] = sum [0][7]
//sum[1][8] = sum [0][8]
//sum[1][9] = sum [0][9]
//sum[1][10] = sum [0][10]
//sum[1][11] = sum [0][11]
//sum[1][12] = sum [0][12]
//sum[1][13] = sum [0][13]
//sum[1][14] = sum [0][14]
//sum[1][15] = sum [0][15]
//sum[1][16] = sum [0][16]
//sum[1][17] = sum [0][17]
//sum[1][18] = sum [0][18]
//sum[1][19] = sum [0][19]
//sum[1][20] = sum [0][10]
//sum[1][21] = sum [0][21]
//sum[1][22] = sum [0][22]
//sum[1][23] = sum [0][23]
//sum[1][24] = sum [0][24]
//sum[1][25] = sum [0][25]


//        i= 1 > 2

//sum[2][0] = sum [1][0]
//sum[2][1] = sum [1][1]
//sum[2][2] = sum [1][2]
//sum[2][3] = sum [1][3]
//sum[2][4] = sum [1][4]
//sum[2][5] = sum [1][5]
//sum[2][6] = sum [1][6]
//sum[2][7] = sum [1][7]
//sum[2][8] = sum [1][8]
//sum[2][9] = sum [1][9]
//sum[2][10] = sum [1][10]
//sum[2][12] = sum [1][12]
//sum[2][12] = sum [1][12]
//sum[2][13] = sum [1][13]
//sum[2][14] = sum [1][14]
//sum[2][15] = sum [1][15]
//sum[2][16] = sum [1][16]
//sum[2][17] = sum [1][17]
//sum[2][18] = sum [1][18]
//sum[2][19] = sum [1][19]
//sum[2][20] = sum [1][20]
//sum[2][21] = sum [1][21]
//sum[2][22] = sum [1][22]
//sum[2][23] = sum [1][23]
//sum[2][24] = sum [1][24]
//sum[2][25] = sum [1][25]

// i => 3
//sum[3][0] = sum [2][0]
//sum[3][1] = sum [2][1]
//sum[3][2] = sum [2][2]
//sum[3][3] = sum [2][3]
//sum[3][4] = sum [2][4]
//sum[3][5] = sum [2][5]
//sum[3][6] = sum [2][6]
//sum[3][7] = sum [2][7]
//sum[3][8] = sum [2][8]
//sum[3][9] = sum [2][9]
//sum[3][10] = sum [2][10]
//sum[3][11] = sum [2][11]
//sum[3][12] = sum [2][12]
//sum[3][13] = sum [2][13]
//sum[3][14] = sum [2][14]
//sum[3][15] = sum [2][15]
//sum[3][16] = sum [2][16]
//sum[3][17] = sum [2][17]
//sum[3][18] = sum [2][18]
//sum[3][19] = sum [2][19]
//sum[3][20] = sum [2][20]
//sum[3][22] = sum [2][21]
//sum[3][23] = sum [2][22]
//sum[3][23] = sum [2][23]
//sum[3][24] = sum [2][24]
//sum[3][25] = sum [2][25]

            sum[i][tmp]++;
        }

        int q = Integer.parseInt(br.readLine()); //질문의 수
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char find = st.nextToken().charAt(0); // a : 찾으려는 알파벳
            int s = Integer.parseInt(st.nextToken()); // 0 : 문자열에서 시작하는 인덱스
            int e = Integer.parseInt(st.nextToken()); // 5 : 문자열에서 끝나는 인덱스

            if(s == 0) {
                sb.append(sum[e][find - 'a']).append('\n');
            }
            else {
                sb.append(sum[e][find - 'a'] - sum[s - 1][find - 'a']).append('\n');
            }

//            만약 사용자가 s에 1을 입력하고 e에 6을 입

//            sum[6][0] - sum[1 - 1][0] = sum[6][0] - sum[0][0] = 1 - 0 = 1 // 'a'
//            따라서, sb에는 1이 추가

//            sum[0][18] = 1 // 's'
//            sum[1][4] = 1  // 'e'
//            sum[2][20] = 1 // 'u'
//            sum[3][13] = 1 // 'n'
//            sum[4][6] = 1  // 'g'
//            sum[5][9] = 1  // 'j'
//            sum[6][0] = 1  // 'a'
//            sum[7][4] = 2  // 'e'
//            sum[8][7] = 1  // 'h'
//            sum[9][22] = 1 // 'w'
//            sum[10][0] = 1 // 'a'
//            sum[11][13] = 2 // 'n'
//            sum[12][6] = 2 // 'g'

        }

        System.out.println(sb);
    }
}
