# 32. File I/O API 활용하기 V : JSON 형식의 텍스트로 입출력

## 학습목표

- JSON 파일 포맷으로 객체를 표현할 수 있다.
- Google gson 라이브러리를 사용하여 객체를 JSON 형식으로 직렬화/역직렬화 할 수 있다.

## 요구사항

- 데이터를 JSON 포맷으로 파일에 저장하고 읽기

## 실행 결과

- 이전과 같다.

## 작업

- Google gson 라이브러리 추가
  - build.gradle 변경
- 데이터 로딩 및 저장 코드 변경
  - loadJson(), saveJson() 메서드 추가
  - loadData(), saveData() 메서드 변경
  - loadUsers(), saveUsers() 메서드 삭제
  - loadProjects(), saveProjects() 메서드 삭제
  - loadBoards(), saveBoards() 메서드 삭제
- User, Project, Board 클래스 변경
  - SequenceNo 인터페이스 정의
  - User, Project, Board 클래스 SequenceNo 구현
  - 데이터 로딩 후 일련 식별 번호 초기화: initSeqNo() 메서드 추가
 
## 소스 파일

- App.java
- SequenceNo.java 추가
- Board.java
- Project.java
- User.java