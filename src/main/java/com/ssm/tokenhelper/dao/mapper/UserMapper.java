package com.ssm.tokenhelper.dao.mapper;

import com.ssm.tokenhelper.model.User;

/**
 * @Author: zhangxing
 * @Date: 2019/4/21 23:48
 */
public interface UserMapper {

    User login(User user);

    void addUser(User user);
}
