# 12. 인스턴스 목록을 다루는 코드를 분리하기 : GRASP의 High Cohesion 설계 패턴

## 학습목표

- GRASP 방법론의 High Cohesion 설계 패턴을 적용할 수 있다.
- 캡슐화(encapsulation)를 이해하고 설명할 수 있다.

## 요구사항

- GRASP 방법론의 High Cohesion 설계 패턴에 따라 UserCommand 클래스의 역할을 쪼갠다.
  - UserCommand 클래스는 UI를 처리하는 역할에 집중한다.
- ProjectCommand, BoardCommand 클래스도 UserCommand 클래스처럼 처리한다.

## 실행 결과

- 실행 결과 변경 없음


## 작업

- UserCommand에서 인스턴스 목록을 다루는 역할을 다른 클래스로 분리한다.
  - UserList 클래스 추가: User 인스턴스 목록에 인스턴스를 보관하는 일을 담당한다. 
  - UserCommand 클래스 변경: UserList를 통해 데이터를 처리하고 UI 처리를 전담한다.
- ProjectCommand에서 인스턴스 목록을 다루는 역할을 다른 클래스로 분리한다.
  - ProjectList 클래스 추가: Project 인스턴스 목록에 인스턴스를 보관하는 일을 담당한다.
  - ProjectCommand 클래스 변경: ProjectList를 통해 데이터를 처리하고 UI 처리를 전담한다.
- BoardCommand에서 인스턴스 목록을 다루는 역할을 다른 클래스로 분리한다.
  - BoardList 클래스 추가: Board 인스턴스 목록에 인스턴스를 보관하는 일을 담당한다.
  - BoardCommand 클래스 변경: BoardList를 통해 데이터를 처리하고 UI 처리를 전담한다.
  
## 소스 파일

- App.java
- UserCommand.java
- ProjectCommand.java
- BoardCommand.java
- UserList.java
- ProjectList.java
- BoardList.java
