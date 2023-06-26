
// 14425 문자열 집합
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // st를 통해 입력된 문자열을 공백을 기준으로 분리
    StringTokenizer st = new StringTokenizer(br.readLine());

    // N과 M은 문자열 집합의 크기와 확인할 문자열 개수를 나타냅니다.
    // 첫 번째 토큰을 정수로 변환하여 N에 저장
    int N = Integer.parseInt(st.nextToken());
    // 두 번째 토큰을 정수로 변환하여 M에 저장
    int M = Integer.parseInt(st.nextToken());

    // 변수 count를 0으로 초기화합니다. 이 변수는 문자열 집합에 포함된 문자열의 개수를 세는 데 사용
    int count = 0;
    // HashSet인 arr을 선언합니다. 이 집합은 문자열 집합을 저장하기 위해 사용됩니다. HashSet은 중복을 허용하지 않는 특징
    Set<String> arr = new HashSet<>();

    // N번 반복하면서 arr에 문자열을 추가합니다. 이때, br.readLine()을 통해 문자열을 입력
    for (int i = 0; i < N; i++) {
      arr.add(br.readLine());
    }
    // M번 반복하면서 arr에 특정 문자열이 포함되어 있는지 확인합니다. 입력된 문자열을 br.readLine()을 통해 받고,
    // arr.contains() 메서드를 사용하여 arr에 해당 문자열이 포함되어 있는지 확인합니다. 포함되어 있다면 count를 증가
    for (int i = 0; i < M; i++) {
      if (arr.contains(br.readLine()))
        count++;
    }
    System.out.println(count);

  }
}

// ##1. BufferedReader와 InputStreamReader:
// BufferedReader는 입력 스트림으로부터 텍스트를 읽는 데 사용되는 클래스입니다.
// InputStreamReader는 바이트 기반의 입력 스트림을 문자 기반의 입력 스트림으로 변환해주는 클래스입니다.
// BufferedReader는 InputStreamReader를 감싸고 있으며,
// 버퍼링된 입력을 제공하여 효율적인 읽기 작업을 수행합니다. 이는 입출력 성능을 향상시킵니다.
// InputStreamReader는 System.in과 같은 바이트 기반 입력 스트림을 문자로 변환하기 위해 사용되고,
// BufferedReader는 InputStreamReader로부터 읽은 문자열을 버퍼에 저장하고 반환합니다.

// ##2. HashSet와 Set:
// Set은 자바 컬렉션 프레임워크 인터페이스의 하나로, 중복된 요소를 허용하지 않는 컬렉션을 나타냅니다.
// HashSet은 Set 인터페이스를 구현한 클래스 중 하나로, 해시 테이블을 기반으로 요소를 저장합니다.
// HashSet은 순서를 보장하지 않으며, null 값을 포함할 수 있습니다.
// Set 인터페이스는 중복된 요소를 허용하지 않고 유일한 값만 저장하므로, 집합 연산에 유용합니다.
// HashSet은 효율적인 검색, 삽입, 삭제 작업을 수행합니다.

// ##3. StringTokenizer:
// StringTokenizer는 문자열을 특정 구분자를 기준으로 분리하는 데 사용되는 클래스입니다.
// 문자열을 구분자로 나누어 토큰(token)이라는 부분 문자열로 분리합니다.
// 주어진 문자열을 기준으로 토큰을 추출하기 위해 nextToken() 메서드를 사용합니다.
// 기본적으로 공백 문자를 기준으로 문자열을 분리하지만, 생성자에서 구분자를 지정할 수도 있습니다.
// StringTokenizer는 간단하고 효율적인 문자열 분리 작업에 사용됩니다.