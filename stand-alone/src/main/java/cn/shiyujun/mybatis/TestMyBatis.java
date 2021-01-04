package cn.shiyujun.mybatis;

import cn.shiyujun.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author jsf
 * @description:
 * @date 1/4/2021 10:03 AM
 */
public class TestMyBatis {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public static void main(String[] args) {
        testAdd();
        getUser();
    }

    public static void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(1, "lisi", new Integer(25));

            userMapper.insertUser(user);

            User user2 = new User(2, "zhangsan", new Integer(25));
            userMapper.insertUser(user2);
            sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
        } finally {
            sqlSession.close();
        }
    }

    public static void getUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser("zhangsan");
            System.out.println("name: " + user.getName() + "|age: "
                    + user.getAge());
        } finally {
            sqlSession.close();
        }
    }
}
