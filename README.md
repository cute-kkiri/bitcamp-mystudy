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
  - HelloWorld.class 파일 제작 및 실행
- 자바 기초 프로그래밍
  - 소스 파일(.java)과 클래스 블록, 클래스 파일(.class)
  - public 클래스와 소스 파일명
  - 애플리케이션 entry point: main() 메서드
  - 애플리케이션 아규먼트 다루는 방법: main(String[] args) 그리고 반드시 String으로 받는다.