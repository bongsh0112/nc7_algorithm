
// 24266 알고리즘 수업 - 알고리즘의 수행 시간 5
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 'StringBuilder'는 문자열 연결, 문자열 추가, 문자열 수정 등의 작업을 효율적으로 수행
    StringBuilder sb = new StringBuilder(); // sb = 문자열을 효율적으로 처리하기 위해 사용
    // 'StringTokenizer'는 문자열을 지정된 구분자(delimiter)를 기준으로 분리하는 역할을 수행하는 클래스
    StringTokenizer st; // st = 문자열을 특정 구분자로 분리하는 데 사용

    // br.readLine()을 사용하여 한 줄을 읽고,
    long n = Long.parseLong(br.readLine());

    System.out.println(n * n * n);
    System.out.println(3);
  }
}

// 3중 for문

// throws Exception : 예외 처리
// main 메서드에서 발생하는 모든 예외는 해당 메서드를 호출한 부분에서 처리해야 합니다.
// 이는 예외가 발생할 수 있는 상황에서 대응하기 위해 예외 처리를 담당하는 부분으로 예외를 던질 수 있도록 합니다.
// 단점 : 예외 처리를 간단히 하지만 예외에 대한 세부 정보를 제공하지 않는 대신, 예외 처리를 다른 부분으로 미룰 수 있습니다.

// BufferedReader : 문자열을 읽기 위한 기능을 제공하는 클래스
// 입력 스트림에서 문자를 읽어들이고 버퍼에 저장하여 효율적인 입출력을 지원합니다.

// InputStreamReader : 입력 스트림을 문자 기반의 입력 스트림으로 변환해주는 클래스
// System.in으로부터 입력된 바이트 스트림을 InputStreamReader를 사용하여 문자로 변환