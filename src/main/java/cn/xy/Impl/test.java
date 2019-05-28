package cn.xy.Impl;

import cn.xy.Bean.User;
import cn.xy.Dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //sqlSessionFactory.getConfiguration().addMapper(IUser.class);
            //User user = (User) session.selectOne( "com.yiibai.mybatis.models.UserMapper.getUserByID", 1);

            // 用户数据列表
            getUserList();
            // 插入数据
            // testInsert();

            // 更新用户
            //testUpdate();

            // 删除数据
            //testDelete();

        } finally {
            session.close();
        }
    }

    public static void getUserList() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);

            User user = session.selectOne("getUser",123456);
            System.out.println(user.getUserId());
            // 显示User信息
            System.out.println("Test Get start...");
            System.out.println(userDao.getUser(234).getUserId());
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllUserList() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            System.out.println("Test Get start...");
            System.out.println(userDao.getAllUsers().size());
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
