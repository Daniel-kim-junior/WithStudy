# 자바 언어 기초

## 교수님 성함 및 이메일, 자료

김정현  unicodaum@hanmail.net
네이버클라우드(MYBOX) http://naver.me/5cABNvUJ (비밀번호 : 0306)


## 실습 과정

초반에 바로 JPA를 공부하는 것이 아닌 이전의 프레임워크인 JDBC, Servlet&JSP 등을 먼저 공부하고 시작할 것 입니다. 현재 디케이테크인은 JPA를 사용하고 있지만 현재 유지 보수 중인 프로젝트 중에는 이전의 기술을 이용한 것이 있기 때문입니다. 뿐만 아니라 이전의 프레임워크를 학습하고 현재의 기술을 이용하는 것은 기술의 이해와 편의성을 받아들이는 데 중요한 부분입니다. 

본 수업에서 서버 개발에는 java를 중심으로, 웹 클라이언트는 javascript를 중심으로 진행될 것입니다.

### 'Requesting Java AST from selection' has encountered a problem 에러

Eclipse의 JSDT를 사용할 때 나타나는 오류로 프로그램에 영향을 주지 않는 오류라고 합니다.

1. 이클립스 상단의 Window - Preference

2. 좌측의 JavaScript - Editor - Mark Occurrences

3. Mark occurrences of the selected element in the current file.의 체크를 풀어줍니다. 

* spring을 다운로드하며 깔려진 플러그인이라고 예상됩니다.

## 유니코드란?

컴퓨터에서는 문자를 사용할 수 있게 코드 값이 정해져 있습니다. 1963년 영문에 대한 **표준 값**(ASCII, 8859-1)이 정해졌고, 한글은 1987년도에 행정 전산망이 생성되며 **표준 한글 코드 값**(KSC5601(한국 이름): EUC-KR(외국이름), CP949(MS949)(마이크로소프트))이 정해졌습니다. 이전에도 표준 값은 존재했으나 제조사마다 표준 값이 달랐기에 제조사가 다른 컴퓨터를 사용할 때마다 한글이 깨지는 현상이 빈번했습니다. 

영문은 1byte단위면 충분히 구현가능했습니다. 그렇기에 0x00~0x7F까지 ASCII가 세계 표준으로 사용하기로 했기에 다른 나라는 0x80부터 0xFF까지 이용이 가능하게 됐습니다. 한글은 조합형 문자이기에 많은 양의 문자를 담기에는 남은 범위가 적어 2byte 단위를 이용하기로 했습니다.

이후 1990년대 뒤로 남은 범위의 값들이 나라마다 같은 값에 다른 문자를 나타냈기에, 외국에서는 영어와 본인 나라의 언어를 제외하고 문자가 깨지는 문제가 발생했습니다. 이를 해결하기 위해 지구상의 모든 표준 값을 통합하자는 취지로 **UniCode**가 개발되었습니다. 

처음 나와 영향력을 발휘한 것은 **UTF-16**입니다. 해당 표준은 영문, 한글 모두 2byte 체계를 가지고 코드 값을 고정시켰습니다. 영문은 0X0041, 한글은 0XAC00 형식으로 포맷을 작성했습니다. 자바에서 UTF-16을 지원했고 해당 표준이 나온 시기에 개발되었기에 가능한 일이었습니다. 그래서 자바는 char형이 2byte고 c++, c 등은 1bytes의 크기를 가집니다. 다만 실질적으로 값을 나타낼 수 있는 것은 15비트까지였습니다. 가장 앞이 1이면 음수임을 나타내는 이진수의 특징때문이었는데 2의 15승으로는 모든 나라의 언어를 담기에는 한계가 있었습니다.

- 자바는 영문, 한글 모두 2byte를 c와 c++는 한글은 2byte, 영문은 1 bytes

이를 해결하기위해 새로나온 유니코드가 **UTF-8**입니다. 더 많은 나라의 문자를 표현하고 효율적인 데이터의 사용을 위해서는 bytes 절대 크기를 늘리기 보다는 1bytes~4bytes의 범위를 가지게 했습니다. 이후 지구상의 웬만한 문자를 나타낼 수 있게 되었고 웹에서의 표준으로 자리잡게 되었습니다. 

- 아시아는 3bytes를 가지고 표현하였습니다.

* 다만 단독으로 실행하는 자바 에플리케이션인 경우에는 메모리 크기의 효율이나 편의를 위하여 다른 표준을 사용해도 괜찮습니다. 

<p align="center">
	[아스키코드 표]
	<br>
    <img src="/Week2/Day1_JavaBasic/course_document/asciitable.png" width="50%" height="40%"></img>
</p>

## 자바 기본

자바 파일(소스)의 이름과 public class의 이름은 동일해야지만 실행됩니다. public이 아닌 경우는 문제가 없으나 후에 유지 보수를 위해, 이름의 결 혹은 속성이 유사한 이름으로 하는 것이 인식하기에 좋습니다.

public static void main()은 자바 프로그램을 실행시킬때 가장 먼저 실행됩니다. main의 이름이 변경되면 자바는 가장 처음 시작할 메소드를 인식하지 못해 에러가 발생합니다. 

자바는 "" 인용 구호를 사용해야지만 문자열로 인식합니다. 사용하지 않을 경우는 모두 변수명으로 인식됩니다. 설명글이 필요할 시 주석 처리를 위해 한 줄일 경우 // 여러 줄일 경우 /**/를 해주면 됩니다. 


###  자바 표준 규격

자바는 파스칼 표기법과 카멜 표기법을 합친 것을 소스 파일명 및 클래스명의 표준으로 사용합니다. 

ex) FirstApp, CarProperty ...

- 소문자로 해도 기능은 하지만 표준 규격이기에 협업을 위해 이 사항을 꼭 지켜줘야 합니다.

다만 변수의 경우 소문자로 시작하는 카멜 표기법이 관례입니다.
ex) mathScore, sportsCar ...

### 자바 package

패키지는 비슷한 성격의 자바 클래스들을 모아 놓은 자바의 디렉토리입니다. 

package [패키지 이름]; 

형식으로 패키지에 속한 자바 파일의 상단에 명시되어야 하며 package 안의 package는 .을 기준자로 나뉩니다. ex) package day1.1hour;

## 변수와 데이터 타입

### 리터럴(literal)

프로그램에서 사용&작성되는 데이터 값(value)을 리터럴이라고 합니다. 리터럴은 작성 방법에 따라 인식되는 데이터 타입이 달라집니다. 서로 다른 데이터 타입끼리 연산을 실행할 경우 강제로 형 변환이 발생합니다. 개발자는 각 데이터 타입의 특징과 형변환이 되는 것을 인식하고 코드를 작성해야만 합니다.

ex) 1(int), 1.0(double), 1l(long), 1f(float), "1"(string), '1'(char)... 

ex) 1+1 --> 2 | 1 + 1.0 --> 2.0 | '1' + 1 --> 50 | "1" + 1 --> "11" 
* 사람은 예시의 글이 모두 1을 의미하는 것을 알 수 있지만 자바 내부에서는 모두 다르게 데이터 타입을 인식한다는 것입니다.

정수형의 범위 : int(10) 32bit 4byte, long(10L) 64bit 8byte, char 16bit 2byte(양의 값만 처리 가능, unsigned 문자 값을 나타낼때 적절한 타입)
- byte & short 8bit 2byte (리터럴로 표현 안 함) - byte는 코드 변환 short는 c 언어와의 호환을 위해 사용됩니다.

* char c2 = 65; 16진수로 변환하여 A가 입력됩니다. 
* char c3 = '\u0041'; \u는 유니코드임을 나타내고 16진수이기에 A가 입력됩니다. 

실수형의 범위 : float(3.14f) 32bit 4byte, double(3.14) 64bit 8byte 
- double 형의 많이 사용하는데 float을 사용할 경우 이진수 변환 시 연산 내의 오류가 생기기 때문입니다.

* 각 값의 범위를 벗어나면 에러가 발생합니다. 값이 커질 경우 적절한 타입으로 변경하여 사용해야 합니다. (L,F,. ...)
 
문자형 : 'a', 'b', '\n', '\t' ... 문자 리터럴로 한 문자를 나타냅니다. 내부에 반드시 하나의 문자가 무조건 있어야만 합니다. 자바에서 문자 리터럴의 내부 값을 아스키 값이나 UTF-16 값으로 변경합니다.

문자열형 : "100", "가나다", ... 쌍따옴표 안의 값을 모두 문자열형이라고 하며 내부에 값이 없어도 괜찮습니다. (null을 의미합니다)

논리형 : true, false 

객체형 (참조형) : null (참조하는 대상이 없음을 나타냅니다.)

- double > float > long > int > short > byte
- double > float > long > int > char // short와 byte와 char는 비교되지 않습니다.

* 메모리의 크고 작음 만으로 절대적인 데이터의 크고 작음을 나타낼 수는 없습니다. 실수형은 부동소수점이 존재하여 저장할 수 있는 값의 범위가 정수형보다 더 크기 때문에 실수형이 정수형보다 더 크다고 말합니다.

* 실수의 범위를 넘어가고 데이터를 확장하는 api를 사용해도 메모리가 부족할 경우 자바가 아닌 다른 언어를 사용해야 합니다.

- **항상 작은 데이터 타입에서 큰 타입으로는 바로 변경이 가능하지만 큰 타입에서 작은 타입으로의 이동은 형 변환을 꼭 해주어야 합니다.** 
* ex) 두 개의 항 중 하나라도 문자열이라면 문자열이 됩니다. char형의 경우 int와 연산할 경우 아스키 코드값으로 변경됩니다.

### 변수

연산 결과 값 또는 리터럴을 보관하는 메모리 상의 공간을 변수라고 합니다. 변수를 필요한 상황에 직접 생성하여 사용하고 이를 **변수 선언**이라고 합니다. 

1. 변수에 저장할 값의 목적에 따라 변수명을 정합니다.
2. 변수에 저장할 값의 종류에 따라 변수의 데이터 타입을 결정합니다.

``타입 변수명; // 선언 ``

``타입 변수명 = 값;  // 초기화 ``

``int total = 100; // 메모리 상에 4바이트의 크기가 설정되고 그 이름을 total이라고 하며, 내부에는 100라는 값이 들어있음을 나타냅니다. 이렇게 변수에 최초로 값을 할당하는 형식을 초기화라고 합니다.``

``total = 1000; // 이렇게 새로운 값을 넣는 것을 할당 혹은 대입이라고 합니다.  ``

``total = 3.14; // 이러한 경우는 서로 타입이 다르기에 통용이 되지 않습니다. total = (int)3.14라는 강제 형변환을 적용해주어야 합니다.``

대입 연산자는 왼쪽에는 변수(l-value == 방, 장소) 오른쪽에는 변수, 리터럴, 데이터 ... 을 통합하여 식(r-value == 값)이 옵니다.
- 변수(방) = 식 ( 값을 가진 변수(값), 리터럴, 연산식, **리턴값**이 존재하는 메소드의 호출식 ... );
* 변수는 초기화한 상태로만 r-value를 사용할 수 있습니다.

## 자바 기초 내용

### 자바에서 표준 출력 

표준 출력 장치로 출력하는 방법으로 기본적으로 출력되는 곳은 console창입니다.
- System.out.println() (행 바꿈), System.out.print() (행 바꿈 X), System.out.printf() (원하는 데이터의 포맷을 출력하게 도와줌)
* \n은 개행 문자, \t은 탭으로 특정 개수의 칸을 띄웁니다.

### 자바의 연산자

대부분이 특수 문자로 되어 있으며 기능에 따라 **산술 연산자**, **비교 연산자**, **논리 연산자**, **비트 연산자** (자바는 이 기능을 지원하지만 웹프로그래밍에서는 사용하지 않습니다. C의 영향을 받았고, 암호화 프로그래밍과 같은 특수한 경우에 사용할 수 있습니다.), 

**조건 연산자** (if문을 대신하기도 합니다.), **대입 연산자**(복합 대인 연산자도 존재합니다.), **형변환 연산자**, **피연산자(항, operand)의 수에 따라 단항(++, --), 이항(비교, 대입..), 삼항 연산자**가 존재합니다.

단항 연산자 : [+, -] (부호 연산자), (타입), !(논리 부정 연산자), [++, --] (증감 연산자)

산술 연산자 (이항 연산자) : *, / (몫), % (나머지), +, -

비교 연산자 : >, <, >=, >=, ==, !=, instanceof(객체 타입 확인)

논리 연산자 : ||(or), &&(and)

삼항 연산자 : 항1(논리식) ? 항2(참) : 항3(거짓)

대입 연산자 : =, [+=, -=, *=, /=, %=, ..] (복합 대입 연산자)


``int result1 = 10 + 2 + 8;``

``System.out.println("result1: " + result1);``

``// 결합 연산``

``String result2 = 10 + 2 + "8";``

``System.out.println("result2: " + result2);``

``String result3 = 10 + "2" + 8;``

``System.out.println("result3: " + result3);``

``String result4 = "10" + 2 + 8;``

``System.out.println("result4: " + result4);``

``String result5 = "10" + (2 + 8);``

``System.out.println("result5: " + result5);	``	

``result1: 20``

``result2: 128``

``result3: 1028``

``result4: 1028``

``result5: 1010``


해당 결과로 연산의 순서는 보통 왼쪽에서 오른쪽으로 흘러가지만 괄호가 우선순위가 더 높은 것을 알 수 있습니다.

* 자바의 나눗셈과 나머지 연산은 정수일 경우에는 정수가 실수일 경우 실수가 반환됩니다. 무한 소수가 될 경우 자바가 적절히 잘라줍니다.

### 자바 연산자 우선 순위

|순위|연산자|
|--|--------------------------|
|1|( ), [ ]|
|2|!, ~ , ++, --|
|3|형변환 연산자|
|4|*, /, %|
|5|+, -|
|6|<<, >>, >>>|
|7|<, <=, >, >=|
|8|==, !=|
|9|&|
|10|^|
|11|(비트 or 연산자)|
|12|&&|
|13|(논리 연산자)|
|14|? : (삼항연산자)|
|15|=, +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, ~=|


``char munja = 'A';``

``munja = (char)(munja+1); ``

``> B ``

``// 연산자 3가지 = 대입 연산자 , (char) 강제 형변환 연산자, + 더하기 연산자, 괄호를 이용하여 (munja+1)을 먼저 실행 후 강제 형변환`` 
		
``munja = munja+1;``

``munja = (char)munja+1;``

``// Type mismatch: cannot convert from int to char ``

### 진수 표기

    obnn 2진수  02nn 8진수  nnnn 10진수  0xnn 16진수

### 실수형 정밀도 차이

``float var1 = 0.1234567890123456789f;``

``double var2 = 0.1234567890123456789;``

``System.out.println("var1: " + var1);``

``System.out.println("var2: " + var2);``

``System.out.printf("%.3f\n", var1);``	

``System.out.printf("%.6f\n", var1);``

``var1: 0.12345679``

``var2: 0.12345678901234568``

``0.123``

``0.123457``

두 타입의 값을 보면 long형이 float보다 더 길게 나타나는 것을 알 수 있습니다. 

이는 크기의 차이에 의한 것이며 이진수로 소수점 단위를 나타낼 경우의 에러가 데이터의 크기에 따라 어디까지 이어지는 지를 보여줍니다.

에러가 생기는 이유는 부동소수점 계산 시에 생기는 것으로 유추되며 자바 언어의 문제가 아닌 시스템적인 문제이며 자바가 오류를 계산해서 보여주지 않을 뿐입니다. 
 
오류가 없는 연산을 위해서는 계산에 특화된 프로그래밍 언어를 사용하는 것이 바람직합니다.

* double var3 = 3e6; 와 같이 지수 형태로 나타낼 수 있습니다.

#### 코드 작성 팁
동일한 계산을 두 번 이상 할 경우 변수 처리를 하여 사용하는 것이 효율적입니다.

문자열 + 정수 + 문자열 + 정수와 같은 식은 문자열과 정수가 합쳐질 때마다 문자열이 생성되는 식이었으나 현재 최신 버전에서는 효율적인 컴파일러를 제공하여 문제사항을 수정하였습니다. 

다만 printf와 같은 함수를 사용하는 것이 가독성과 효율적인 것이 더 좋다고 말할 수 있습니다.

- 자바 언어의 가장 중요한 특징은 무엇일까?

객체 지향, 가비지 컬렉터가 있었으나 현재 많은 언어들이 이를 충족합니다. 

그렇기에 JVM이 가장 중요한 특징입니다. 운영체제와 무관한 가상 머신을 이용하여 컴파일과 인터프리팅을 하기에 작성 후 어디에서나 사용할 수 있다는 장점이 있습니다.

다만 자체적인 운영체제를 적용하기에 조금 느리다는 단점이 있습니다.
