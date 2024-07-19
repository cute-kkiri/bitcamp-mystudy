# 30. File I/O API 활용하기 III :  객체 직렬화/역직렬화

## 학습목표

- Serialize/Deserialize를 이해하고 설명할 수 있다.
- File I/O API의 데코레이터 클래스를 사용하여 객체를 입출력 할 수 있다.

## 요구사항

- File I/O API의 데코레이터를 사용하여 객체를 직접 입출력 하기

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