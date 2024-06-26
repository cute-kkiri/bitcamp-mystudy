# bitcamp-study
네이버클라우드캠프 데브옵스 14기 실습 자료 저장소

- 전임강사
  엄진영
  jinyoung.eom@gmail.com

## 웨일온 접속 정보
- 회의실 번호 / 암호: 210 866 3081 / 111222
- 회의링크: https://whaleon.us/o/CSrtk1/84888a51da9d4f939e63eee37248fb28

## 강의자료
- 실습(https://github.com/eomjinyoung/bitcamp-study)
- 강의자료
  - 수업 문서(https://github.com/eomcs/eomcs-docs)
  - 프로그래밍 자료(https://github.com/eomcs/eomcs-java)

## 1일차(2024-05-24,금)
- 소프트웨어 개요
  - 시스템 소프트웨어와 애플리케이션 소프트웨어
  - Standalone과 Client/Server
  - 설치형과 비설치형
  - 애플리케이션의 기본 구조
- GIT 설치
  - 실습 저장소 준비 및 복제

## 2일차(2024-05-27,월)
- GIT 소개
  - 기본 명령 사용법(clone, add, commit, push, pull)
  - 개인 저장소 준비 및 가져오기
    - `$ git clone https://github.com/사용자이름/bitcamp-mystudy`
  - 실습 저장소 가져오기
    - `$ git clone https://github.com/eomjinyoung/bitcamp-study`
  - 수업문서 가져오기
    - `$ git clone https://github.com/eomcs/eomcs-docs`
  - 프로그래밍 자료 가져오기
    - `$ git clone https://github.com/eomcs/eomcs-java`
- 개발 도구 준비
  - 기본 편집기: VSCode
  - Windows gcc 컴파일러 설치
  - VirtualBox 설치
  - Vagrant 설치
- 웹 애플리케이션 구동 원리 소개
  - 웹 애플리케이션의 구성 요소: HTML, CSS, JavaScript, Images, Application
  - 웹 애플리케이션 구현 기술: Java, SQL, HTML, CSS, JavaScript 등
- 애플리케이션 개발 및 실행 과정 실습
  - hello.c 작성 및 컴파일, 실행
- CPU, 기계어, OS의 관계 이해
- 수업 진행 방식 소개

## 3일차(2024-05-28,화)
- 컴파일 방식과 인터프리터 방식, 하이브리드 방식
  - Nodejs 설치 및 실행
    - hello.js
  - JDK 설치 및 실행
    - Hello.java
- Java 컴파일 및 실행 원리
  - 자바컴파일러와 바이트코드
  - JVM
- 자바 제품 소개
  - Java SE(JRE, Server JRE, JDK)
  - Java EE(Servlet/JSP/EL/JSTL, EJB/WebService/REST API 등)
  - Java ME

## 4일차(2024-05-29,수)
- 개발 도구 설정
  - 폰트 설치
    - D2Coding 폰트
  - VSCode 설정
  (구글 포맷 설정 블로그 - https://medium.com/echo-devblog/vscode-java-formatting-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0-56d89ce1ec4d)
  (구글 포맷 xml - https://raw.githubusercontent.com/google/styleguide/gh-pages/eclipse-java-google-style.xml)
    - Font Family: D2Coding
    - Java Formatting: GoogleStyle
    - Format On Save: 활성화
    - Code Lens: 비활성화
    - Inlay Hints: 비활성화
- Java 컴파일과 실행
  - 컴파일 옵션 사용법
  - javac 컴파일 옵션(https://internet-craft.tistory.com/24)
  - JVM 옵션 사용법
- 프로젝트 디렉토리 구조
  - Maven 표준 디렉토리 구조
- 빌드 도구
  - 빌드의 개념
  - 빌드 도구의 소개: Ant, Maven, Gradle
  - Gradle 빌드 도구 설치 및 사용법(gradle.org, Gradle 다운로드)
    - JDK 설정했던 것과 같이 Gradle 환경변수 설정하기.(bin 폴더까지)
    - 자바 프로젝트 디렉토리를 구성하기
    - 자동 생성된 디렉토리 및 파일의 역할 이해
    - Gradle 사용
      - 자바 프로젝트 생성할 디렉토리에서 $gradle init(= gradle 초기화)
      - build 생성부터 자동으로 실행 - $gradle run
      - build 폴더 생성 - $gradle (-i, -d) build
      - build/main 파일 실행 - $gradle (-q) run
      - 처음에 만들어진 example이 아닌 내가 생성하고자 하는 java 컴파일 $gradle compileJava

## 5일차(2024-05-30, 목)
- 직접 Bytecode로 프로그래밍 하기
(코드실행방법 블로그 - https://medium.com/@davethomas_9528/writing-hello-world-in-java-byte-code-34f75428e0ad)
(java specification - https://docs.oracle.com/javase/specs/)
  - HelloWorld.class 파일 제작 및 실행
- 자바 기초 프로그래밍
  - 소스 파일(.java)과 클래스 블록, 클래스 파일(.class)
  - public 클래스와 소스 파일명
  - 애플리케이션 entry point: main() 메서드
  - 애플리케이션 아규먼트 다루는 방법: main(String[] args) 그리고 반드시 String으로 받는다.

## 6일차(2024-05-31, 금)
- atmega128 instruction 검색해봄.(기계어 설명 명세서)
- JVM Bytecode Viewer VSCode 확장프로그램 설치
- 자바 기초 프로그래밍
  - 패키지
  - 데이터 타입과 리터럴
  - 변수와 메모리
  - polyglot - 한프로젝트에 여러 언어로 코드를 작성.

## 7일차(2024-06-03, 월)
- 자바 기초 프로그래밍
  - 문자와 문자집합(계속)
    - ASCII, ISO-8859, MS949, Unicode, UTF-8, UTF-16
  - 숫자를 메모리에 저장
    - 정수
      - Sign-Magnitude, 1의 보수, 2의 보수(java에서 정수를 저장하는 방식)
    - 부동소수점
      - Execess-K

## 8일차(2024-06-04, 화)
- 자바 기초 프로그래밍
  - 변수 선언 의미와 방법
  - 데이터 타입에 따라서 변수에 저장할 수 있는 값의 유효범위
- 개발 도구
  - Eclipse IDE 설치 및 설정(https://www.eclipse.org/)
  - Gradle 빌드 도구로 만든 프로젝트를 Eclipse IDE로 임포트 하는 방법
  - Eclipse 설치를 도와주는 설치 도구가 설치됨.
  - 설정하기.(eoms-docs/devtooluserguide/jdk-eclipse-sttings.md)
- 변수(variables)

## 9일차(2024-06-05, 수)
- 실습 프로젝트 준비
  - myapp 프로젝트 생성 및 빌드, 실행(gradle)
- 개발 도구
  - IntelliJ IDE 설치 및 설정(https://www.jetbrains.com/ko-kr/idea/download/download-thanks.html?platform=windows&code=IIC)
  - cummunity 무료평가판 설치
  - 해시코드 확인방법 링크(https://www.reddit.com/r/Windows10HowTo/comments/107cior/how_to_check_md5_or_sha256_checksum_in_windows_11/?rdt=44064)
    - 해시코드 확인 명령어 ($ certutil -hashfile ideaIC-2024.1.2.exe SHA256) 해당 폴더 경로에서
- md(markdown이라는 문법)

## 10일차(2024-06-07, 금)
- 자바 기초 프로그래밍
  - 연산자
- 실습 프로젝트

## 11일차(2024-06-10, 월)
- 자바 기초 프로그래밍
  - 반복문(for, while 등), 배열, 조건문
  - 레퍼런스와 인스턴스
  - 가비지와 가비지 컬렉터(메모리가 부족할 때)
- 실습 프로젝트
  - 05. 배열을 활용하여 메뉴 목록 다루기
  - 06. 예외 처리하기

## 12일차(2024-06-11, 화)
- 자바 기초 프로그래밍
  - print(), println(), printf() 사용법
  - Scanner 클래스 사용법
- 실습 프로젝트
  - 07. 문자열 비교와 데이터 변환 다루기
  - 08. 기능 단위로 명령문 묶기 : 메서드 사용법

## 13일차(2024-06-12, 수)
- 자바 기초 프로그래밍
  - method
- 실습 프로젝트

## 14일차(2024-06-13, 목)
- 자바 기초 프로그래밍
  - 메서드 사용법
- 실습 프로젝트
 - 09. 자바 기본 문법 활용 연습

## 15일차(2024-06-14,금)
- 자바 기초 프로그래밍
  - 클래스 사용법
    - 사용자 데이터 타입 정의
    - 메서드 분류
- 실습 프로젝트
 - 10. CRUD 구현하기
  - 회원

## 16일차(2024-06-17,월)
- 자바 기초 프로그래밍
  - 클래스 사용법(계속)
    - 사용자 데이터 타입 정의
    - 메서드 분류
    - 생성자
- 실습 프로젝트
 - 10. CRUD 구현하기(계속)

## 17일차(2024-06-18,화)
- 실습 프로젝트
- GRASP 방법론
  - 10. CRUD 구현하기
    - 프로젝트

## 18일차(2024-06-19,수)
- 자바 기초 프로그래밍
  - 클래스 사용법(계속)
  - Method Area, JVM Stack, Heap 복습
- 클래스 정의와 방법론: Design Patterns(GoF)
  - GRASP 방법론, SOLID OOP 설계원칙
- 실습 프로젝트
  - 10. CRUD 구현하기
    - 게시판

## 19일차(2024-06-20,목)
- 자바 기초 프로그래밍
  - 상속
    - 상속 관계와 레퍼런스
- GRASP - High Cohesion 기법
- 실습 프로젝트
  - 11. 데이터 식별 번호 부여하기
  - 12. 인스턴스 목록을 다루는 코드를 분리하기 : GRASP의 High Cohesion 설계 패턴

## 20일차(2024-06-21,금)
- 자바 기초 프로그래밍
  - 상속(계속)
- 실습 프로젝트
  - 13. 스태틱 필드의 한계를 극복하기: 인스턴스 필드 사용
  - 14. 공통코드 분리 및 사용하기: 상속의 일반화(Generalization) 기법.

## 21일차(2024-06-24,월)
- 자바 기초 프로그래밍
  - 기본 클래스 사용법: Object, String Wrapper 클래스 등
- 실습 프로젝트

## 22일차(2024-06-25,화)
- 자바 기초 프로그래밍
  - 기본 클래스 사용법: String, Wrapper 클래스
- 실습 프로젝트
  - 15. 배열 크기 자동 증가시키기: 배열 복제와 문제점
  - 16. LinkedList 자료구조 구현하기: 배열의 한계 단점 극복

## 23일차(2024-06-26,수)
- 자바 기초 프로그래밍
  - 인터페이스 사용법
  - 추상 클래스 사용법
  - 중첩 클래스 사용법
- 실습 프로젝트
  - 17. 인터페이스를 이용한 객체 사용 규칙 정의: 목록을 다루는 규칙
  - 18. 추상 클래스를 이용하여 공통 코드를 서브 클래스에게 상속
  - 19. 특정 클래스에서만 사용되는 클래스는 중첩 클래스로 정의하기