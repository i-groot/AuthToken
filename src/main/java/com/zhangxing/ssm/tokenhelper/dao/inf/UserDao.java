package com.zhangxing.ssm.tokenhelper.dao.inf;

import com.zhangxing.ssm.tokenhelper.model.Book;
import com.zhangxing.ssm.tokenhelper.model.User;

import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 22:42
 */
public interface UserDao {
    User login(User user);

    void addUser(User user);
}
