# 61. Spring Framework 도입하기

## 학습목표

- Spring IoC 컨테이너와 Spring WebMVC 프레임워크를 프로젝트에 적용할 수 있다.

## 요구사항

- 프로젝트에 Spring Framework를 적용하라.

## 실행 결과

- 이전과 같다.

## 작업

- Spring WebMVC 라이브러리 가져오기
  - 'spring-webmvc' 라이브러리를 프로젝트에 포함
  - build.gradle 변경
- 기존 클래스를 스프링 프레임워크에서 제공하는 것으로 교체 
  - IoC 컨테이너 클래스 교체
  - DispatcherServlet 서블릿 클래스 교체
  - CharacterEncodingFilter 필터 클래스 교체
  - 애노테이션 교체
- AppConfig 클래스 변경
- 서비스 클래스 변경
- 페이지 컨트롤러 클래스 변경
  - 파라미터와 리턴타입 변경
- 뷰 컴포넌트 URL 다루기
  - JSP를 /WEB-INF 배치 폴더로 옮김
    - 외부에서 직접 접근 차단
  - InternalResourceViewResolver 설정
    - AppConfig 클래스 변경
  - 페이지 컨트롤러 클래스 변경
  - JSP 파일 변경
- Mybatis를 스프링 프레임워크와 연동하기
  - 'mybatis-spring' 라이브러리를 프로젝트 추가
  - 'spring-jdbc' 라이브러리를 프로젝트에 추가
  - AppConfig 클래스 변경
  - mybatis-config.xml 파일 삭제
  - XxxMapper.xml 파일의 네임스페이스 변경
  - DaoFactory 클래스 삭제
  - Param 애노테이션 삭제
  - SqlSessionFactoryProxy 클래스 삭제
  - XxxService 클래스 변경

## 소스 파일

