package bitcamp.myapp.annotation;

import bitcamp.myapp.vo.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    System.out.println("LoginUserArgumentResolver.supportsParameter() 호출됨!");
    // 파라미터에 대해 이 해결사를 동원할 수 있는지 여부를 알려준다.
    // 즉, 다음 두 가지 조건을 만족해야만 이 해결사가 파라미터 값을 줄 수 있다.
    // - 해당 파라미터에 @LoginUser 애노테이션이 붙어 있어야 한다.
    // - 해당 파라미터는 User 객체를 받을 수 있는 타입이어야 한다.
    //
    return parameter.hasParameterAnnotation(LoginUser.class) &&
            parameter.getParameterType().isAssignableFrom(User.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    System.out.println("LoginUserArgumentResolver.resolveArgument() 호출됨!");
    // 파라미터 값을 리턴한다.
    // 즉, 로그인 사용자 정보(User 객체)를 세션에서 꺼내 리턴한다.
    HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
    HttpSession session = request.getSession();
    return session.getAttribute(parameter.getParameterName());
  }
}
