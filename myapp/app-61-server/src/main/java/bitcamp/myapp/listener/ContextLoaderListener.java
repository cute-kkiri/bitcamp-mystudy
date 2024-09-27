package bitcamp.myapp.listener;

import bitcamp.myapp.config.AppConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.EnumSet;

@WebListener // 서블릿 컨테이너에 이 클래스를 배치하는 태그다.
public class ContextLoaderListener implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent sce) {

    try {
      ServletContext ctx = sce.getServletContext();

      AnnotationConfigWebApplicationContext iocContainer = new AnnotationConfigWebApplicationContext();
      iocContainer.register(AppConfig.class);
      iocContainer.setServletContext(ctx);
      iocContainer.refresh();

      ctx.setAttribute("sqlSessionFactory", iocContainer.getBean(SqlSessionFactory.class));

      // 프론트 컨트롤러 역할을 수행할 서블릿 객체 생성
      DispatcherServlet dispatcherServlet = new DispatcherServlet(iocContainer);
      ServletRegistration.Dynamic servletRegistration = ctx.addServlet("app", dispatcherServlet);
      servletRegistration.addMapping("/app/*"); // URL 매핑
      servletRegistration.setLoadOnStartup(1); // 웹애플리케이션 시작할 때 객체 자동 생성
      servletRegistration.setMultipartConfig(new MultipartConfigElement( // 멀티파트 설정
              new File("./temp/").getAbsolutePath(), // 업로드 파일을 임시 보관할 폴더
              1024 * 1024 * 20,
              1024 * 1024 * 100,
              1024 * 1024 * 1));

      // 필터 객체 생성
      CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
      FilterRegistration.Dynamic filterRegistration = ctx.addFilter("characterEncodingFilter", characterEncodingFilter);
      filterRegistration.addMappingForServletNames(
              EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD), // 필터를 어떤 상황에서 동작하도록 할 것인지 지정
              false, // web.xml 에 설정된 매핑 정보를 적용한 후에 필터 정보를 설정할 것인지
              "app" // 필터를 적용할 서블릿의 별명
      );

      // 현재 IoC 컨테이너에 들어 있는 빈(자바 객체)을 조회
      System.out.println("빈 개수: " + iocContainer.getBeanDefinitionCount());
      String[] beanNames = iocContainer.getBeanDefinitionNames();
      for (String beanName : beanNames) {
        Object bean = iocContainer.getBean(beanName);
        System.out.println(beanName + " ==> " + bean.getClass().getCanonicalName());
      }

    } catch (Exception e) {
      System.out.println("서비스 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }


}
