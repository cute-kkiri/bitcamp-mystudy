package bitcamp.myapp.command;

import bitcamp.myapp.vo.User;

public class UserList {

    private static final int MAX_SIZE = 100;
    private User[] users = new User[MAX_SIZE];
    private int userLength = 0;

    public void add(User user) {
        this.users[this.userLength++] = user;
    }

    public User delete(int userNo) {
        User deletedUser = findByNo(userNo);
        if (deletedUser == null) {
            return null;
        }
        int index = indexOf(deletedUser);
        for (int i = index + 1; i < this.userLength; i++) {
            this.users[i - 1] = this.users[i];
        }
        this.users[--this.userLength] = null;
        return deletedUser;
    }

    public User[] toArray() {
        User[] arr = new User[this.userLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.users[i];
        }
        return arr;
    }

    public User findByNo(int userNo) {
        for (int i = 0; i < this.userLength; i++) {
            User user = this.users[i];
            if (user.getNo() == userNo) {
                return user;
            }
        }
        return null;
    }

    public int indexOf(User user) {
        for (int i = 0; i < this.userLength; i++) {
            if (this.users[i] == user) {
                return i;
            }
        }
        return -1;
    }
}
