package bitcamp.myapp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    private String encoding;

    public CharacterEncodingFilter(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("encoding") != null) {
            encoding = filterConfig.getInitParameter("encoding");
        }
        System.out.println("CharacterEncodingFilter 객체 준비!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals("POST")) {
            request.setCharacterEncoding(this.encoding);
        }

        chain.doFilter(request, response); // 다음 필터 또는 서블릿 실행
    }
}
