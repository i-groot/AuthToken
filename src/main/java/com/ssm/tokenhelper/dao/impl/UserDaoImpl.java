package com.ssm.tokenhelper.dao.impl;

import com.ssm.tokenhelper.dao.inf.UserDao;
import com.ssm.tokenhelper.model.User;
import com.ssm.tokenhelper.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:21
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper mapper;

    @Override
    public User login(User user) {
        return mapper.login(user);
    }

    @Override
    public void addUser(User user) {
        System.out.println("-----start add user dao-----");
        mapper.addUser(user);
    }
}
