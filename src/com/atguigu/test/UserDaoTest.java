package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userdao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        System.out.println(userdao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userdao.queryUserByUsernameAndPassword("admin","ad1min"));
    }

    @Test
    public void saveUser() {
        User user=new User(null,"test","test","test@");
        userdao.saveUser(user);
    }
}