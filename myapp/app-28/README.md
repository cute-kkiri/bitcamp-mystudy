# 27. 각각의 메뉴 처리 기능을 객체화 하기: GoF의 Command 패턴 적용하기

## 학습목표

- GoF의 Command 설계 패턴의 구동 원리를 이해하고 적용할 수 있다.

## 요구사항

- 각각의 메뉴 처리 기능을 별도의 객체로 분리하여 캡슐화 하기 

## 실행 결과

- 이전과 같다.

## 작업

- Command 객체의 각 메서드를 클래스로 분리

## 소스 파일

- ProjectCommand.java(삭제)
  - ProjectAddCommand.java(추가)
  - ProjectListCommand.java(추가)
  - ProjectViewCommand.java(추가)
  - ProjectUpdateCommand.java(추가)
  - ProjectDeleteCommand.java(추가)
  - ProjectMemberHandler.java(추가)
- UserCommand.java(삭제)
  - UserAddCommand.java(추가)
  - UserListCommand.java(추가)
  - UserViewCommand.java(추가)
  - UserUpdateCommand.java(추가)
  - UserDeleteCommand.java(추가)
- BoardCommand.java(삭제)
  - BoardAddCommand.java(추가)
  - BoardListCommand.java(추가)
  - BoardViewCommand.java(추가)
  - BoardUpdateCommand.java(추가)
  - BoardDeleteCommand.java(추가)
- App.java