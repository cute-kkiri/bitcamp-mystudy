package bitcamp.myapp.security03;

import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DbUserDetailsService implements UserDetailsService {

    private static final Log log = LogFactory.getLog(DbUserDetailsService.class);

    // DBMS에서 사용자 정보를 찾아주는 서비스 객체
    UserService userService;

    public DbUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User member = userService.get(email);
            if (member == null) {
                throw new UsernameNotFoundException("해당 사용자가 존재하지 않습니다.");
            }
            log.debug(member);

            // 해당 이메일을 가진 사용자가 존재한다면
            // 그 사용자 정보를 UserDetails 객체에 담아서 리턴한다.
            // 그러면 Spring Security는 리턴된 UserDetails의 username/password 와
            // 클라이언트가 보낸 username/password를 비교하여 로그인 처리를 수행한다.
            return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                    .username(member.getEmail())
                    .password(member.getPassword())
                    .roles("USER")
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("해당 사용자가 존재하지 않습니다.");
        }
    }
}
