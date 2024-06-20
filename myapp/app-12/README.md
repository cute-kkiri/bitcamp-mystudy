# 11. 데이터 식별 번호 부여하기

## 학습목표

- 데이터 식별 번호의 필요성을 설명할 수 있다.
- 스태틱 필드와 인스턴스 필드를 구분하여 다룰 수 있다.
- 특정 필드 값을 기준으로 인스턴스를 찾을 수 있다.

## 요구사항

- 회원 데이터에 식별 번호를 부여
- 프로젝트 데이터에 식별 번호를 부여
- 게시판 데이터에 식별 번호를 부여
- 식별 번호로 데이터를 다루기

## 실행 결과

- 회원
```
메인/회원> 2
[목록]
번호 이름 이메일
1 홍길동 hong@test.com
5 임꺽정 leem@test.com
6 유관순 yoo@test.com
9 안중근 ahn@test.com
메인/회원> 3
[조회]
회원번호? 1
이름: 홍길동
이메일: hong@test.com
연락처: 010-1111-2222
메인/회원> 3
[조회]
회원번호? 7
없는 회원입니다.
메인/회원> 4
[변경]
회원번호? 1
이름(홍길동)? 홍길순
이메일(hong@test.com)? hong2@test.com
암호? 2222
연락처(010-1111-2222)? 010-1111-3333
변경하였습니다.
메인/회원> 4
[변경]
회원번호? 7
없는 회원입니다.
메인/회원> 5
[삭제]
회원번호? 1
삭제하였습니다.
메인/회원> 5
[삭제]
회원번호? 7
없는 회원입니다.
```

## 작업

### 회원 데이터에 식별 번호 부여

- 식별 번호 필드 추가
  - User 클래스 변경
    - seqNo 필드 추가
    - getNextSeqNo() 메서드 추가
- 식별 번호 자동 부여 및 식별 번호로 찾기
  - UserCommand 클래스 변경
    - addUser() 변경
    - listUser() 변경
    - viewUser() 변경
    - findByNo() 변경
    - updateUser() 변경
    - deleteUser() 변경
    - indexOf() 추가

### 게시글 데이터에 식별 번호 부여

- 식별 번호 필드 추가
  - Board 클래스 변경
    - seqNo 필드 추가
    - getNextSeqNo() 메서드 추가
- 식별 번호 자동 부여 및 식별 번호로 찾기
  - BoardCommand 클래스 변경
    - addBoard() 변경
    - listBoard() 변경
    - viewBoard() 변경
    - findByNo() 추가
    - updateBoard() 변경
    - deleteBoard() 변경
    - indexOf() 추가

### 프로젝트 데이터에 식별 번호 부여

- 식별 번호 필드 추가
  - Project 클래스 변경
    - seqNo 필드 추가
    - getNextSeqNo() 메서드 추가
    - containsMember() 메서드 변경
- 식별 번호 자동 부여 및 식별 번호로 찾기
  - ProjectCommand 클래스 변경
    - addBoard() 변경
    - listBoard() 변경
    - viewBoard() 변경
    - findByNo() 추가
    - updateBoard() 변경
    - deleteBoard() 변경
    - indexOf() 추가
    
## 소스 파일

- App.java
- User.java
- UserCommand.java
- Project.java
- ProjectCommand.java
- Board.java
- BoardCommand.java
  
