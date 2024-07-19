# 29. File I/O API 활용하기 II :  데코레이터를 이용한 데이터 변환 자동화

## 학습목표

- GoF의 Decorator 설계 패턴을 이해하고 적용할 수 있다.
- File I/O API의 데코레이터 클래스를 사용하여 Primitive type, String 타입 값을 byte[] 배열로 입출력 할 수 있다.

## 요구사항

- 데이터를 입출력 할 때 File I/O API에서 데코레이터 클래스를 사용

## 실행 결과

- 이전과 같다.

## 작업

- 데이터 로딩 및 저장 코드 변경
  - loadUsers(), saveUsers() 메서드 변경
  - loadProjects(), saveProjects() 메서드 변경
  - loadBoards(), saveBoards() 메서드 변경
- User, Project, Board 클래스 변경
  - getBytes(), valueOf() 메서드 제거
  
## 소스 파일

- App.java
- Board.java
- Project.java
- User.java