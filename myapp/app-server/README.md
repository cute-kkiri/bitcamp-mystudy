# 60. 페이지 컨트롤러 및 컴포넌트 자동 생성하기 - IoC 컨테이너 만들기

## 학습목표

- Reflection API를 사용하여 클래스를 찾아서 인스턴스를 자동 생성할 수 있다.
- IoC 컨테이너의 구동 원리를 이해하고 설명할 수 있다.

## 요구사항

- 페이지 컨트롤러를 직접 생성하지 말고 @Controller 애노테이션이 붙은 클래스의 인스턴스를 자동 생성하라.

## 실행 결과

- 이전과 같다.

## 작업

### 1 단계: 페이지 컨트롤러 객체 자동 생성 하기
- 애노테이션 정의 
  - Controller 애노테이션 생성
- 페이지 컨트롤러에 애노테이션 적용
  - XxxController 클래스 변경
- @Controller 애노테이션이 붙은 클래스를 찾아 인스턴스를 자동으로 생성
  - ContextLoaderListener 클래스 변경
  
### 2단계: 객체 생성 기능을 별도의 클래스로 분리하기

- IoC 컨테이너 추가
  - ApplicationContext 클래스 생성
  - ContextLoaderListener가 하던 객체 생성 일을 가져온다.

### 3단계: 객체 생성을 해주는 팩토리 메서드 호출을 자동화하기

- 팩토리 메서드 표시할 때 사용할 애노테이션 정의
  - Bean 애노테이션 생성
- Bean 애노테이션이 붙은 팩토리 메서드 자동 호출하기
  - ApplicationContext 클래스 변경

### 4단계: 팩토리 메서드 정의를 별도의 클래스로 분리하기

- 프로젝트에 종속되는 팩토리를 메서드를 분리하기 
  - AppConfig 클래스 생성
  - ApplicationContext 클래스 변경
  - ContextLoaderListener 클래스 변경

### 5단계: 프론트 컨트롤러 서블릿을 코드로 직접 객체를 생성하여 서블릿 컨테이너에 등록하기

- 서블릿을 직접 서블릿 컨테이너에 등록하기
  - DispatcherServlet 클래스 변경
    - IoC 컨테이너를 의존 객체로 주입
  - CharacterEncodingFilter 클래스 변경
    - encoding 설정을 생성자에서 수행
  - ContextLoaderListener 클래스 변경
    - DispatcherServlet 객체를 직접 생성하여 서블릿 컨테이너에 등록
    - CharacterEncodingFilter 객체를 직접 생성하여 서블릿 컨테이너에 등록

### 6단계: 서비스 객체를 자동 생성하기

- 자동 생성할 객체에 붙일 애노테이션을 정의
  - Component 애노테이션 생성
- 자동 생성할 서비스 클래스에 애노테이션을 붙이기
  - XxxService 클래스 변경
  - AppConfig 클래스 변경
- IoC 컨테이너에서 @Component 애노테이션이 붙은 클래스는 객체를 자동 생성하여 보관
  - ApplicationContext 클래스 변경

## 소스 파일

