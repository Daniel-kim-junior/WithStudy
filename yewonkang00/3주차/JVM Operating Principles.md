## 🖥️ Java 프로그램 실행 과정
1. 프로그램이 실행되면 JVM은 OS로부터 이 프로그램이 필요로 하는 메모리를 할당받는다. <br>
   JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다. <br>
   
2. Java 컴파일러(javac)가 Java 소스코드(.java)를 읽어 들여 Java 바이트코드(.class)로 변환시킨다. <br>

3. Class Loader를 통해 class 파일들을 JVM으로 로딩한다. <br>

4. 로딩 된 class 파일들은 Execution engine을 통해 해석된다. <br>
 
5. 해석된 바이트코드는 Runtime Data Areas에 배치되어 실질적인 수행이 이루어지게 된다. <br>

<br>

### JVM 동작 원리
![image](https://user-images.githubusercontent.com/54140431/232287501-4c378cb1-ee8e-46e2-a53a-b440dbba138d.png)

▪️자바 소스코드를 작성

▪️자바 컴파일러가 byte code라고 불리는 .class 파일로 번역

▪️JVM이 기계어 코드로 번역

<br>

<b>JDK > JRE > JVM 포함관계를 가진다.</b>

▪️JDK : 컴파일러, 디버거, JRE가 있다

▪️JRE : JVM과 라이브러리가 있다.

▪️JVM : JVM 내부에는 Class Loader, Runtime Data Areas, Execution Engine 등이 있다.

![image](https://user-images.githubusercontent.com/54140431/232287540-3e891190-1212-4c7c-be7a-804f6229976e.png)

<br>

### 1️⃣ Class Loader

▪️바이트 코드(.class)를 받아서 필요한 클래스를 가져와 JVM의 메모리에 로드하고, 링킹하고 초기화하는 과정을 수행

▪️자바는 컴파일 타임에 모든 클래스를 로드하는 방식이 아닌, 런타임에 클래스가 필요하면 클래스를 로드하고 링킹하는 동적로드를 한다.

<br>

<b>클래스 로딩 과정</b>

▪️클래스 로더가 아직 로드되지 않은 클래스를 찾을 때, 로딩 -> 링킹 -> 초기화 과정을 거침

▪️로딩 : 클래스 파일을 가져와서 JVM 메모리에 로드

▪️링킹

  - 검증 : 자바, JVM의 명세에 맞게 작성 되어 있는지 확인

	- 준비 : 클래스가 필요로하는 메모리를 할당 (필드, 메소드 등)

	- 분석 : 클래스의 상수 풀 내의 심볼릭 레퍼런스를 다이렉트 레퍼런스로 변경

      - 클래스 파일은 JVM이 프로그램을 실행할 때 필요한 API를 Link할 수 있도록 심볼릭 레퍼런스를 가진다. 
    
      - 심볼릭 레퍼런스를 런타임 시점에 메모리 상에서 실제로 존재하는 물리적인 주소로 대체하는 Linking 작업이 일어난다.
 
      - 심볼릭 레퍼런스는 참조하는 대상의 이름을 지칭하고, 클래스 파일이 JVM에 올라가게 되면 심볼릭 레펀선스는 실제 메모리 주소가 아닌 이름에 맞는 객체의 주소를 찾아서 연결하는 작업을 수행한다.
    
	- 초기화 : 클래스 변수들을 초기화한다. → static 필드들을 설정된 값으로 초기화 한다.

<br>

### 2️⃣ Runtime Data Areas

▪️JVM이 OS위에서 실행되면서 할당받아 사용하는 메모리 영역이다. - 6개 영역으로 구분된다.

![image](https://user-images.githubusercontent.com/54140431/232304576-8a66a5d4-3b9b-4a74-9137-c63c0f1af777.png)

▪️쓰레드 마다 생성

  - <b>PC Register</b>

    - 현재 수행 중인 JVM의 명령어 주소

  - <b>JVM Stack</b>

    - 쓰레드가 시작될 때 생성

    - 스택 프레임을 저장하는 스택이다.

      - 메소드 스택

        - 지역변수, 매개변수, 반환 주소 등

  - <b>Native Method Stack</b>

    - 자바 외의 언어로 작성된 네이티브 코드를 위한 스택

<br>

▪️모든 쓰레드가 공유

  - <b>Heap</b>

    - 인스턴스를 저장하는 공간

    - 가비지 컬렉션 대상

  - <b>Method Area</b>

    - JVM이 시작될 때 생성된다.

    - JVM이 읽어 들인 각각의 클래스와 인터페이스에 대한 런타임 상수 풀, 필드와 메소드 정보, static 변수, 메소드의 바이트 코드 등이 포함된다.

  - <b>Runtime Constant Pool</b>

    - Method Area에 포함되는 영역이다.

    - JVM에서 가장 핵심적인 역할 수행

    - 클래스와 인터페이스의 상수, 메소드, 필드에 대한 모든 레퍼런스를 담고 있는 테이블

    - 메소드나 필드를 참조할 때, 이 테이블을 통해 실제 메모리상의 주소를 찾는다.

<br>

### 3️⃣ Execution Engine
▪️JVM의 메모리에 올라온 바이트 코드들을 명령어 단위로 하나씩 실행한다.

▪️바이트 코드(.class)를 JVM 내부에서 실행할 수 있는 형태(기계어?)로 바꾼다.

▪️바꾸는 방법이 2가지가 있다

  - <b>인터프리터</b>

    - 바이트 코드 명령어를 하나씩 읽고 해석해서 실행한다.

    - 하나하나의 해석은 빠르지만 전체 실행 결과는 느리다.

    - 바이트 코드는 기본적으로 인터프리터 방식으로 동작한다.

  - <b>JIT(Just In Time)</b>

    - 인터프리터의 단점을 보완하기 위해 도입된 JIT 컴파일러 이다.

    - 바이트 코드 전체를 컴파일하여 네이티브 코드로 변경한다.

      - 전체를 컴파일하는 과정이 인터프리터 보다 느리다.

      - 따라서 한 번만 실행되는 코드라면 컴파일 하지 않는다.

      - JIT 컴파일러를 사용하는 JVM들은 내부적으로 컴파일하려는 메소드가 얼마나 자주 실행되는지 체크하고 일정 수준 이상일 때 컴파일을 한다.

<br>

[출처]
https://yoonda.tistory.com/12
