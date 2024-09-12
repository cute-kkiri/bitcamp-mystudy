# 54. 파일 업로드 다루기 - multipart/form-data POST 요청 처리

## 학습목표

- Servlet API를 이용하여 multipart/form-data 파라미터를 다룰 수 있다.

## 요구사항

- 게시글에 첨부 파일 기능을 추가하라.

## 실행 결과

- 이전과 같다.

## 작업

- 첨부 파일 데이터를 저장할 테이블 정의
  - myapp_board_files 테이블 정의
- 게시글 입력폼에 첨부파일 선택 기능 추가
  - /board/form.jsp 변경
  - /board/view.jsp 변경
- 첨부파일 도메인 클래스 추가
  - AttachedFile 클래스 생성
  - Board 클래스에 첨부파일 필드 추가
- BoardDao 클래스 변경
  - insertFiles() 메서드 추가
  - getFile() 메서드 추가
  - deleteFile() 메서드 추가
  - deleteFiles() 메서드 추가
- BoardDaoMapper 파일 변경
  - resultMap "BoardMap" 변경
  - resultMap "AttachedFileMap" 추가 
  - "findBy" SQL 문 변경
  - "insertFiles" SQL 문 추가
  - "getFile" SQL 문 추가
  - "deleteFile" SQL 문 추가
  - "deleteFiles" SQL 문 추가
- 서블릿 파일 변경 
  - BoardAddServlet 변경
  - BoardViewServlet 변경
  - DownloadServlet 추가
  - BoardUpdateServlet 변경
  - BoardDeleteFileServlet 추가
  - BoardDeleteServlet 변경
## 소스 파일

