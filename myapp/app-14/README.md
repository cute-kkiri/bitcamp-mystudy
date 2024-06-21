# 14. 공통 코드 분리와 사용하기: 상속의 일반화(generalization) 기법

## 학습목표

- 상속의 기법 중 일반화(generalization)를 수행할 수 있다.

## 요구사항

- 공통 코드를 분리하여 재사용 하기 쉽도록 리팩토링 하기

## 실행 결과

- 이전과 같다.


## 작업

- UserList, ProjectList, BoardList 클래스에서 공통 코드를 분리하여 별도의 클래스로 정의한다.
  - ArrayList 클래스 추가
  - UserList 클래스 변경
  - UserCommand 클래스 변경
  - ProjectList 클래스 변경
  - ProjectCommand 클래스 변경
  - BoardList 클래스 변경
  - BoardCommand 클래스 변경
  - Project 클래스 변경

## 소스 파일

- App.java
- ArrayList.java
- UserList.java
- BoardList.java
- ProjectList.java
- UserCommand.java
- ProjectCommand.java
- BoardCommand.java
- Project.java
