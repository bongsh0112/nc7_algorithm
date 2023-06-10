import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것

public class Main { // Main 이라는 공개 클래스를 정의
  public static void main(String[] args) { // 프로그램 시작점
    Scanner sc = new Scanner(System.in); // 'Scanner' 객체를 생성하는 코드 & System.in은 표준 입력 스트림

    int num = sc.nextInt(); // 들어오는 단어의 수
    int cnt = num; // 단어의 수를 초기값으로 그룹단어가 아닐 시 -1을 하는 구조이다.

    for (int roop = 0; roop < num; roop++) { // 입력받은 던어의 수만큼 반복한다.
      String st = sc.next(); // 문자열 입력
      boolean test[] = new boolean[26]; // 알파벳 배열을 만들어서 이미 체크한 알파벳은 true로 바꿔준다. (boolean 배열의 초기값은 false)

      for (int i = 0; i < st.length() - 1; i++) { // i와 i+1을 비교하는 과정이므로 <st.length()-1 을 해주었다.
        if (st.charAt(i) != st.charAt(i + 1)) { // i와 i+1이 다른경우 (현재 알파벳과 다음 알파벳을 비교)
          if (test[st.charAt(i + 1) - 97] == true) { // 이미 한번 체크된 알파벳일 경우 그룹단어가 되지 못하는 점
            cnt--; // 그룹단어가 아니라고 판단 될 경우 초기값인 단어의 수에서 1씩 빼준다. 전체-그룹단어가 아닐경우 = 그룹단어인 경우
            break; // 그룹단어가 아니라고 판단될 시 즉시 break로 빠져나온다. 이것을 안해 줄시 결과값이 -1,-3 등의 결과가 생길 수 있다. 여러번
                   // 반복해서 -1 되기떄문
          }
        }
        test[st.charAt(i) - 97] = true; // 위의 처리가 다 끝났으면 해당 알파벳을 true처리 해주어 다음번에 반복되는경우 제외되도록 처리한다. -97은 아스키코드로 a가 97이니
                                        // -97해주어 a를 0으로 나오게함
      }
    }
    System.out.println(cnt); // 최종 cnt를 출력하여 그룹단어의 숫자를 출력한다.
    sc.close();
  }
}