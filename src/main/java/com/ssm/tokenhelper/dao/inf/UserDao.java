package com.ssm.tokenhelper.dao.inf;

import com.ssm.tokenhelper.model.User;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 22:42
 */
public interface UserDao {
    User login(User user);

    void addUser(User user);
}
