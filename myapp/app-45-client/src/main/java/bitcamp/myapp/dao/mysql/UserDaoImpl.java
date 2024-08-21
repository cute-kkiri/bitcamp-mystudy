package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public boolean insert(User user) throws Exception {
        // user로 parameterType 정보를 알려줌.
        sqlSession.insert("UserDao.insert", user);
        return true;
    }

    @Override
    public List<User> list() throws Exception {
        // "namespace와 id", User.class는 xml안에 resultType에 명시.
        return sqlSession.selectList("UserDao.list");
    }

    @Override
    public User findBy(int no) throws Exception {
        return sqlSession.selectOne("UserDao.findBy", no);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws Exception {
        Map<String, Object> values = new HashMap<>();
        values.put("email", email);
        values.put("password", password);

        // Map 객체를 넘김.
        return sqlSession.selectOne("UserDao.findByEmailAndPassword", values);
    }

    @Override
    public boolean update(User user) throws Exception {
        int count = sqlSession.update("UserDao.update", user);
        return count > 0;
    }

    @Override
    public boolean delete(int no) throws Exception {
        int count = sqlSession.delete("UserDao.delete", no);
        return count > 0;
    }
}
