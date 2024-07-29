# 35. 데이터 접근 로직을 캡슐화하기 : DAO 객체 도입

## 학습목표

- DAO 객체의 역할을 이해하고 프로젝트에 적용할 수 있다.

## 요구사항

- XxxCommand 객체에서 데이터 접근 로직을 별도의 클래스로 캡슐화 하라.

## 실행 결과

- 이전과 같다.

## 작업

- User 데이터 접근 로직을 캡슐화 하기
  - UserDao 인터페이스 정의
  - MapUserDao 구현체 추가
  - ListUserDao 구현체 추가
- Board 데이터 접근 로직을 캡슐화 하기
  - BoardDao 인터페이스 정의
  - MapBoardDao 구현체 추가
  - ListBoardDao 구현체 추가
- Project 데이터 접근 로직을 캡슐화 하기
  - ProjectDao 인터페이스 정의
  - MapProjetDao 구현체 추가
  - ListProjectDao 구현체 추가
- XxxCommand 클래스 변경
  - DAO를 사용하여 데이터 처리
- SequenceNo 인터페이스 삭제
  - 도메인 클래스 변경
- App 클래스 변경
  - DAO 생성 및 Command 객체에 주입
  - DAO의 데이터를 저장
  
## 소스 파일

- App.java
- BoardXxxCommand.java 
- ProjectXxxCommand.java
- UserXxxCommand.java
- ProjectMemberHandler.java
- BoardDao.java
- MapBoardDao.java
- UserDao.java
- MapUserDao.java
- ProjectDao.java
- MapProjectDao.java
- SequenceNo.java (삭제)