# 41. 외부키(Foreign Key) 사용하기

## 학습목표

- 외부 키를 이용하여 테이블 데이터 간의 관계를 설정할 수 있다.
- 부모/자식 테이블의 데이터를 다룰 수 있다.

## 요구사항

- 프로젝트의 멤버를 별도의 테이블로 분리하여 저장하라.

## 실행 결과

- 이전과 같다.

## 작업

- DDL 및 예제 데이터 입력
  - 프로젝트 테이블 정의 변경(myapp_projects)
  - 프로젝트 멤버 테이블 추가(myapp_project_members)
- ProjectDao 인터페이스 변경
  - insertMembers() 메서드 규칙 추가
  - getMembers() 메서드 규칙 추가
  - deleteMembers() 메서드 규칙 추가
- ProjectDaoImpl 클래스 변경
  - insertMembers() 메서드 구현
  - getMembers() 메서드 구현
  - deleteMembers() 메서드 구현
- ProjectAddCommand 클래스 변경
- ProjectViewCommand 클래스 변경
- ProjectUpdateCommand 클래스 변경
- ProjectDeleteCommand 클래스 변경


## 소스 파일

