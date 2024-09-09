# 52. 쿠키 및 세션 활용하기

## 학습목표

- 쿠키의 용도와 동작 원리를 설명할 수 있다.
- 쿠키를 HTTP 프로토콜에서 어떻게 표현하는지 설명할 수 있다. 
- 세션의 용도와 동작 원리를 설명할 수 있다.

## 요구사항

- 로그인 할 때 입력한 이메일을 쿠키로 보관하고 꺼내기
- 여러 페이지에 걸쳐서 프로젝트 정보를 입력 받기(세션 활용)

## 실행 결과

- 이전과 같다.

## 작업

- 프로젝트 입력 폼 분리
  - /project/form1.jsp, /project/form2.jsp, /project/form3.jsp 파일 추가
  - ProjectForm1Servlet, ProjectForm2Servlet, ProjectForm3Servlet 클래스 생성
  - form.jsp 파일 제거
- 로그인 폼 변경
  - /auth/form.jsp 변경

## 소스 파일

