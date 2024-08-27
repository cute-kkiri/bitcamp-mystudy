# 47. Application Server 아키텍처로 전환하기

## 학습목표

- Application Server 아키텍처의 구동 원리를 이해하고 구현할 수 있다.

## 요구사항

- 서버 애플리케이션 아키텍처로 변경하라.

## 실행 결과

- 이전과 같다.

## 작업

- app-client 프로젝트를 복제하여 app-server 프로젝트를 만든다.
- app-server 프로젝트를 변경한다.
  - 클라이언트가 접속할 수 있도록 네트워킹 기능을 추가한다.
    - ServerApp 클래스 생성
  - 클라이언트와 입출력 할 수 있도록 변경한다.
    - bitcamp.net.Prompt 클래스 생성
    - Command 인터페이스와 Command 구현 클래스 변경
    - InitApplicationListener 클래스 변경
  - 로그인 기능을 서버에서 처리하도록 변경
    - ServerApp 클래스 변경
    - AuthApplicationListener 클래스 삭제


## 소스 파일

