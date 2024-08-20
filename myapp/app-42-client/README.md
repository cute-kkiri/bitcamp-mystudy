# 42. 로그인/로그아웃 적용하기

## 학습목표

- .properties 파일의 프로퍼티 값을 읽을 수 있다.
- 로그인/로그아웃을 구현할 수 있다.
- 로그인 정보를 이용하여 데이터를 다룰 수 있다.

## 요구사항

- 애플리케이션의 설정 정보를 .properties 파일에 보관하라.
- 로그인/로그아웃을 구현하라.
- 게시글을 입력/변경/삭제할 때 로그인 사용자의 정보를 활용하라.

## 실행 결과

- 이전과 같다.

## 작업

- JDBC 접속 정보를 .properties 파일에 저장
  - app.properties 파일 생성
  - InitApplicationListener에서 app.properties 파일의 설정 정보를 로딩하여 사용
- 로그인 기능 구현
  - AuthApplicationListener 에서 로그인을 구현
- 게시글에 로그인 사용자 정보 추가
  - myapp_boards 테이블 변경 및 예제 데이터 변경
  - Board 클래스 변경
  - BoardDaoImpl 클래스 변경
  - BoardListCommand 클래스 변경
  - BoardViewCommand 클래스 변경
  - BoardAddCommand 클래스 변경
  - BoardUpdateCommand 클래스 변경
  - BoardDeleteCommand 클래스 변경

## 소스 파일

