package bitcamp.myapp.security04;

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

            // => Spring Security에서 제공하는 기본 암호 인코더를 사용한다.
            // => DB에서 암호를 가져 오면 이 기본 인코더를 사용하여 암호화 해서 보관한다.
//            return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
//                    .username(member.getEmail())
//                    .password(member.getPassword())
//                    .roles("USER")
//                    .build();

            // => 우리가 만든 암호 인코더를 사용한다.
            // => DB에서 가져온 암호를 그대로 보관한다.
            return org.springframework.security.core.userdetails.User.builder()
                    .username(member.getEmail())
                    .password(member.getPassword())
                    .roles("USER")
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("해당 사용자가 존재하지 않습니다.");
        }
    }
}
