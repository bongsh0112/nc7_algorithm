# CS면접 자주나오는 질문 리스트

## 주의

> 심심할떄만 본인만의 답지를 적어 보세요.(이거 당장 급한건 아님)

## 자주 받는 질문 (기술질문은 아님)

1. 개발자가 되려는 이유
   1. 개발자가 무엇이라 생각하는지
   2. 어떤 방향의 개발자가 되고 싶은건가
2. (경험이 있는 경우) 전회사에서 어떤 경험을 해봤는지

---

## Back

### 상식

1. `모놀리식`이 무엇인가요?
2. `마이크로 서비스 아키텍처(MSA)`란 무엇인가요?
3. `모놀리틱과 MSA의 차이점`은 무엇인가요
4. HashTable이란 무엇이며 어떤 상황에서 활용이 가능할까요?

### 어디에 둬야할지 몰라서 만만한 Back에 놓은 질문들

1. `Docker란` 무엇인가요?
   1. `Container`, `Image의` 개념에 대해서 말해보세요
      1. `Container와 Virtual Machine의 차이점`에 대해서 설명해 보시오
   2. `Docker의 장점`이 무엇인가요?
   3. Docker를 사용하는 이유는 무엇일까요?
      1. BackEnd에서 Docker를 활용하는 이유는?
   4. `HOST OS`란?
2. `Scale Up, Scale Out에 대해서` 들어본적이 있나요? 설명해보시겠어요?

### Java

1. 자바의 `특징`
2. `가비지 컬렉션(GC)`란?
   1. `GC의 알고리즘 종류`를 알고 있는가?
   2. 성능에 어떤 영향을 미치는가 (여기까진 잘 안물어보긴 해요)
3. `객체지향 프로그래밍(OOP)`이란?
4. `동등성`과 `동일성`이란?
   1. `equals`, `==`, `hashcode`를 엮어서 설명해 보세요
   2. `깊은 복사(Deep Copy)`와 `얕은 복사(Shallow Copy)`를 엮어서 설명해 보세요
5. `JVM의 메모리 구조`에 대해 설명해보시오
   1. `JVM의 동작원리`는 어떻게 되나요?
6. `String a = "a";` 와 `String a = new String("a");`의 차이점을 설명해 보시오
   1. `String Constant Pool`과 `JVM Heap`영역을 연관지어서 설명해 보시오
   2. `String`, `StringBuilder`, `StringBuffer`에 대해서 설명 및 차이점을 말해보세요
   3. String의 `Immutable`을 엮어서 설명해보세요
      1. `불변객체`란?
7. `동기`, `비동기`, `블록킹`, `논블록킹`에 대해 JAVA에서 어떻게 활용하는지를 설명해 보시오
   1. CS지식에서도 해당 부분과 연관지어 설명하면 유용합니다.
8. `HashMap`과 `LinkedHashMap`의 `차이와 장단점`, 병목현상의 원인과 해결법
9. `Collection`의 `Map`, `Set`, `List`의 특징과 차이점들에 대해서 나열해 보세요.
   1. `Stack`과 `Queue`에 대해서도 설명하면 좋을 듯 합니다
   2. `Interface를 상속받아 구현`한 내용들도 같이 넣으면 좋을것 같기도 합니다.
10. `final`에 대해서 `Class`, `Method`, `Variable`에 선언시 각각 어떻게 작동이 되는지를 설명해 보세요.
11. `Override`와 `Overloading`에 대해서 설명하시오
12. `Constructor`에 대해서 설명해 보시겠어요?, 생성자는 왜 필요한가요
13. `static`과 `non-static`의 차이점에 대해서 설명해주세요.
    1. Memory와 엮어서 설명해보기 바랍니다.
14. `Primitive`과 `Wrapper`의 차이점에 대해서 설명해 보세요.
    1. `Primitive Type`과 `Reference Type`을 에 대해서 차이점을 설명해보기 바랍니다.
       1. JVM Memory와 역어서 질문을 Dive해보기 바랍니다.
15. `접근 지정자`에 대해서 각 `종류별로 설명`해보세요
    1. public
    2. default
    3. protected
    4. default
16. `제네릭(Generic)`이 무엇인가요?
    1. 사용방법은 어떻게 되나요?
17. `extends`와 `implement`의 차이점에 대해서 설명해보세요
    1. `interface`와 `abstract class`를 사용하는 이유는?
    2. 사용하는 방법은 어떻게 되나요?
18. `Optional`이란?
    1. 왜 사용할까요?
       1. `Null에서 안전하게 개발하는 방법`은 어떻게 될까요?
19. 자바에서의 Thread를 동기화 하고 `Thread-safe하게 개발하는 방법`에 대해서 종류별로 나열하고 각각의 장단점을 얘기해 보세요
    1. `synchronized` 예약어
    2. `ReentrantLock` 클래스
    3. `volatile` 변수타입
    4. `AtomicInteger`, `AtomicReference`
    5. `synchronized` 블록, `wait/notify/notifyAll` Method
20. `직렬화(Serialization)와 역직렬화(De-Serialization)`에 대해서 설명하세요
    1. `SerialVersionUID와` 엮어서 설명해보세요
    2. `transient`예약어도 같이 설명해주면 좋을 듯
21. `CheckedException과 UnCheckedException에` 대해서 설명해 보세요
22. `final`, `finally`, `finallize()`의 차이점? (이거 유사단어로 인한 말장난임...)
    1. finallize의 경우 GC와 연관해서 설명해보세요
23. `Stream`, `Lambda`좋아하시나요? 설명해보시겠어요?
24. `Thread`와 `ThreadPool`의 개념과 사용하는 이유
25. `Java Bean`에 대해서
26. `Annotation`이란?
27. `Java8`에서 변화된 내용들은 무엇이 있을까요?
28. `try-catch-finally`의 활용 방법, 왜 사용하는지?
    1. `try-with-resource`를 사용하는 이유는? 어떻게 사용하는가
29. `Enum`쓰시나요? 설명해보시겠어요

### Spring

1. `SOLID 원칙`에 대해서
2. `세션`과 `쿠키`의 차이점
   1. 실제 물리적으로 어디에 보관하고 있을까요?
3. `스프링의 3대 요소`에 대해서 설명해 보세요
   1. IoC(Inversion Of Control) / DI(Dependency Injection) 란?
      1. IOC?
         1. POJO에 대해서
      2. DI?
   2. AOP (Aspect Oriented Programming)
   3. PSA (Portable Service Abstraction)
4. `TDD(Test Driven Development)`가 무엇인지? 어떤 장점이 되는지?
   1. 꼭 TDD로만 개발해야 하나요?
   2. TestCase가 필요한 이유는?
5. `트랜잭션(Transaction)`이란?
6. Spring에서 `Request요청이 들어오는 경우 이뤄지는 작업`을 순서대로 나열해 보세요.
   1. Filter와 Interceptor, AOP의 차이점에 대해서 설명하시오
7. 멀티쓰레딩이란 무엇이며, 어떤 이점이 있는가
   1. Spring과 엮어서 설명하면 좋을 듯 합니다.
8. HTTP 통신을 Spring에서 진행할 때 사용되는 모듈이 무엇인가요?
   1. RestTemplate와 WebFlux?
   2. WebFlux를 쓰면 무엇이 좋은지?
9. `@Component`와 `@Bean`에 대해서
   1. `@Component`의 경우 `@Controller`, `@Service`, `@Repository`와 엮어서 설명하면 좋음
      1. `@Configuration`은 무엇인가요?
   2. `@Bean`을 주입받는 방식은 무엇이 존재하나요, 또한 권장되는 방식은 무엇인가요
      1. 필드 주입
      2. 생성자 주입
      3. Setter주입
10. `Dispatcher Servlet`에 대해서
11. `MVC패턴`에 대해서 설명해보세요.
12. `분산환경에서 Session의 사용을 하는 방법`에 대해서
13. `도메인 주도 개발(Domain Driven Design)`이란?
14. `캐시(Cache)`에 대해서 설명해 보세요
15. 실제 운영 경험, `모니터링`을 해본 경험이 있으신가요?
    1. `부하테스트`를 해본 경험이 있으신가요?
       1. JMeter, nGrider등등

#### JPA

1. JPA를 ORM이라 칭합니다. `ORM이란` 무엇인가요?
2. `영속성 컨텍스트`에 대해서 설명해 보세요
   1. 영속성의 이점에 대해서 설명해 주세요
3. `1차캐시와 더티체킹, 스냅샷`에 대해서 설명해주세요
4. `JPA`와 `Spring Data Jpa`에 대해서 설명해주세요
5. flush에 대해서
6. `지연 로딩`에 대해서 설명하고 왜 사용하는지 말해보세요
7. N:N의 문제점에 대해서 설명해 보세요
8. 연관관계를 설정하는 방법
9. `N+1` 문제에 대해서 알고 있는지 ?
   1. 발생원인에 대해서 설명해 보시오
   2. 해결방법은?
      1. QueryDSL
10. 왜 `MyBatis를 사용하지 않고 JPA를 활용`하나요?
    1. MyBatis를 사용해야 하는 경우는 어떤 경우일까요?
11. `@Transcational (readOnly = true)`의 사용이유
    1. 언제 사용할 생각인가요?
    2. 속도가 빠르다면 왜 좀더 빠른가요?

---

## Front

### 상식

1. `인터넷 주소창에서 https://naver.com을 입력`을 하게 되면 무슨 작업이 이루어 지게 되나요? (기본CS로도 가능)
   1. DNS, HTTPS 통신, Rendering
2. `SSR과 CSR의 동작원리와 차이점`에 대해 설명해 보세요
   1. Server Side Rendering, Client Side Rendering
3. JavaScript는 Prototype언어라고도 칭합니다. 왜그럴까요?
   1. Class와 Prototype을 엮어서 설명해보시겠어요?
4. `비동기 통신`은 어떻게 해야하나요?

---

## Network

1. `DNS란` 무엇이며 어떻게 작동하는가?
2. `OSI 7계층`이란?
   1. IP, Mac, Port등등 모든걸 엮어서 `통신과정 전체`를 엮어서 설명하면 더 좋지 않을까 생각듦
3. `TCP / UDP`의 차이
   1. `3 Way HandShake`란?
   2. `4 Way Handshake`란?
      1. `TCP를 해제시 사용하는 이유`에 대해서 설명해 보세요
4. `HTTP`와 `HTTPS의 차이`점, HTTPS가 `생겨나게 된 이유`
   1. `SSL Handshake`?
5. `3-1,2의 Handshake`와 엮어서 `커넥션 풀의 필요 이유`에 대하여 설명해 보세요
6. `RESTful API`란?
7. `HTTP Method의 멱등성`이란?
8. `CORS(Cross-Origin Resource Sharing)`에 대해 설명해 보세요.
9. `Http상태코드`에 대해서 아는대로 말해보세요
10. `공인IP`와 `사설IP`에 대해서 설명해 보세요

---

## DataBase

1. `DB의 종류`에 대해서 나열해 보세요
   1. RDB
   2. NoSQL
   3. InMemory
2. `NoSQL과 RDB의 차이`점은 무엇인지?
3. 데이터베이스에서 `인덱스`란 무엇인지?, 어떻게 작동되는지? 사용하는 이유는?
4. `정규화`에 대해서 설명해 보세요.
   1. 진행해본적이 있으신가요? 작업을 어떻게 진행하나요?
5. `View`에 대해서 설명해 보세요.
   1. 질문자 본인이라면 어떤 경우에 활용 할 것 같습니까?
6. `동시성` 제어가 이뤄지는 과정, `동시성` 제어 기법을 활용 할 수 있는 종류
7. `트리거(Trigger)`에 대해서 설명하세요
8. `함수(Function)`과 `프로시저(Procedure)`에 대해서 설명하세요
   1. 차이점에 대해서 설명하세요
9. `쿼리튜닝`이 무엇인지? 경험이 있는지?
   1. `쿼리 플랜`을 떠본적이 있는지?
10. `조인(Join)`에 대해서 종류들에 대해서 설명, 작성방법
    1. Inner Join, Outer Join등등
11. `트랜잭션`에 대해서 설명해 보세요
    1. `commit`과 `rollback`에 대해서 설명해보세요
12. `Redis`에 대해서 간단히 설명해주세요
    1. `Redis`와 `Memcached`의 차이에 대해서 설명해주세요.
13. `Elastic Search`에 대해서 설명해 보세요
    1. 왜 사용할까요?
14. `PK`, `UK`, `FK` 각각에 대해서 설명 및 차이점을 얘기해 보세요
15. `SQL Injection`에 대해서 설명해 보세요
    1. 방어하는 방법은?
16. 데이터의 무결성에 대해서

---

## CS

1. `OS(운영체제)`에 대해서 설명하시오
2. `Context Switching`에 대해서
3. `프로세스`와 `쓰레드`에 대해서 설명하시오
   1. `멀티 프로스세`와 `멀티 쓰레드`에 대해서 설명하고 차이점을 말해보세요
4. `프로세스 구조`와 `쓰레드 구조`에 대해서 설명후 차이점을 말해보시오
   1. 개발을 진행할떄 본인은 어떤 경우에 프로세스를 사용하고, 쓰레드를 사용할지 생각해 보세요
   2. 쓰레드로 통신이 이뤄질 때 발생할 수 있는 이슈사항은 무엇이 있을까요?
5. `JWT(JSON Web Token)이란` 무엇인가?
6. `로드 밸런싱`이란 무엇인가?
   1. `Round Robin(라운드 로빈)`이란?
7. `동기, 비동기, 블록킹, 논블록킹`에 대해 설명하시오.
8. `메세지 브로커(Message Broker)란` 무엇이며, 어떤 경우에 사용되는 것인가?
9. `동시성`과 `병렬성`의 차이점에 대해 설명
10. `Web Server와 Web Application Server의 차이점`은 무엇인가요?
11. `가상 메모리`란 무엇인가?
    1. 동작방식은 어떻게 되나요?
12. `CI / CD`가 무엇인가요?
    1. 왜 하는건가요?
       1. `자동화`를 하면 좋은 점은 무엇인가요?
          1. 실제 환경 구축을 해본 경험이 있으신가요?
          2. 어떻게 진행했었나요
       2. `CI, CD의 툴`에 대해서 아는 부분을 설명해 주세요
       3. `무중단 배포`를 진행해본 경험이 있으신가요?
          1. `Blue / Green 전략`과 같이 엮어서 설명해보쎄요
13. `교착상태(Deadlock)`이란?
    1. 4가지 조건
14. `프록시와 리버스 프록시`에 대해서 설명해 주세요
