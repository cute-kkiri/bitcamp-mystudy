package bitcamp.myapp.dao;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

public class DaoFactory {
    private SqlSession sqlSession;

    public DaoFactory(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public <T> T createObject(Class<T> daoType) throws Exception {

        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{daoType},
                this::invoke // 같은 시그너처라면 기존코드를 재사용한다. 해당 메서드를 던져줌.
                /*
                // this::invoke를 풀어쓴 것. - 아래 코드를 자동 생성
                (Object proxy, Method method, Object[] args) -> {
                            return this.invoke(proxy, method, args)
                }
                */
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        String namespace = proxy.getClass().getInterfaces()[0].getSimpleName();
        String sqlId = method.getName();
        String statement = String.format("%s.%s", namespace, sqlId);

        Object paramValue = null;
        if (args != null) {
            if (args.length == 1) {
                paramValue = args[0];
            } else {
                Parameter[] params = method.getParameters();
                HashMap<String, Object> map = new HashMap<>();
                for (int i = 0; i < args.length; i++) {
                    Param anno = params[i].getAnnotation(Param.class);
                    map.put(anno.value(), args[i]);
                }
                paramValue = map;
            }
        }

        Class<?> returnType = method.getReturnType();

        if (returnType == List.class) {
            return sqlSession.selectList(statement, paramValue);
        } else if (returnType == int.class || returnType == void.class || returnType == boolean.class) {
            Object returnValue = sqlSession.insert(statement, paramValue);
            if (returnType == boolean.class) {
                return ((int) returnValue) > 0;
            } else if (returnType == void.class) {
                return null;
            } else {
                return returnValue;
            }
        } else {
            return sqlSession.selectOne(statement, paramValue);
        }
    }
}
