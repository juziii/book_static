package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询信息
     * @param username 用户名
     * @return 返回null说明没有用户
     */
    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username,String password);
    public int saveUser(User user);

}
