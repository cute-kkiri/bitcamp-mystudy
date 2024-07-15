# 20. 리팩토링: Map 컬렉션과 의존성 주입

## 학습목표

- GRASP 설계 지침에서 Low Coupling을 이해하고 적용할 수 있다.
- SOLID 설계 원칙에서 DIP(Dependency Inversion Principle)를 이해하고 적용할 수 있다.
- Map 컬렉션 객체를 사용하여 객체를 저장하고 조회할 수 있다.

## 요구사항

- 의존 객체를 다룰 때 DIP 설계 원칙을 적용

## 실행 결과

- 이전과 같다.

## 작업

### Command 구현체 저장 및 실행

- Map 컬렉션 객체를 사용하여 Command 구현체를 저장
  - App 클래스: 생성자 추가
- 메뉴에 대한 Command 구현체를 찾아 실행
  - App 클래스: processMenu() 변경

### 의존 객체를 외부에서 주입하기(SOLID의 DIP 적용)

- UserCommand, ProjectCommand, BoardCommand 클래스의 의존 객체를 외부에서 주입
  - 생성자 변경
- Command 객체가 사용할 List 객체 준비
  - App 클래스 변경: 생성자 변경

## 소스 파일

- UserCommand.java
- ProjectCommand.java
- BoardCommand.java
- App.java