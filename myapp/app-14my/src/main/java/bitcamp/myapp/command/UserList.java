package bitcamp.myapp.command;

import bitcamp.myapp.vo.User;

public class UserList extends ArrayList {
    public User findByNo(int userNo) {
        for (int i = 0; i < size(); i++) {
            // ArrayList에서 Object로  리턴하기 때문에 컴파일러에게 User 객체라는걸 알려주어야한다.
            User user = (User) get(i);
            if (user.getNo() == userNo) {
                return user;
            }
        }
        return null;
    }
}
