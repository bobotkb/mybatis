package com.bobo.dao;

import com.bobo.po.User;

import java.io.IOException;
import java.util.List;

/**
 * @author tangkb
 * @create 2019-07-06 15:31
 */
public interface UserDao {
    //1、根据用户ID查询用户信息
    public User findUserById(int id) throws IOException;

    //2、根据用户名称模糊查询用户列表
    public List<User> findUserListByName(String username);

    //3、添加用户
    public int addUser(User user);
}
