package com.bobo.dao.impl;

import com.bobo.dao.UserDao;
import com.bobo.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author tangkb
 * @create 2019-07-06 15:49
 */
public class UserDaoImpl implements UserDao {

    //注入SqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;
    //使用构造方法或者set方法等形式注入SqlSessionFactory
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws IOException {
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4、SqlSession执行statement，并返回映射结果
        //第一个参数：statement的id，建议：namespace.statementId（确保唯一）
        //第二个参数：入参的值，它的类型要和映射文件中对应的statement的入参类型一致
        User user = sqlSession.selectOne("test.findUserById", id);

        //5、关闭SqlSession
        sqlSession.close();

        return user;
    }

    @Override
    public List<User> findUserListByName(String username) {
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4、SqlSession执行statement，并返回映射结果
        //第一个参数：statement的id，建议：namespace.statementId（确保唯一）
        //第二个参数：入参的值，它的类型要和映射文件中对应的statement的入参类型一致
        List<User> userList = sqlSession.selectList("test.findUserByName", username);

        return userList;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }
}
