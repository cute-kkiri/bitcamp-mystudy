package bitcamp.myapp.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor // 기본 생성자 추가.
@EqualsAndHashCode(of = {"no"}) // no 프로퍼티에 대해서 같은지 equals 생성.
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int no;
    private String name;
    private String email;
    private String password;
    private String tel;
    private String photo;

    public User(int no) {
        this.no = no;
    }
}
