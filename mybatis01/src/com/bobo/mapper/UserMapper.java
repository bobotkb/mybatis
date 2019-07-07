package com.bobo.mapper;

import com.bobo.po.User;
import java.util.List;

/**
 * @author tangkb
 * @create 2019-07-06 16:52
 */
public interface UserMapper {
    //1、根据用户ID查询用户信息
    public User findUserById(int id);

    //2、根据用户名称模糊查询用户列表
    public List<User> findUserListByName(String username);

    //3、添加用户
    public int addUser(User user);
}
