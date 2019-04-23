package com.zhangxing.ssm.tokenhelper.business.inf;

import com.zhangxing.ssm.tokenhelper.model.User;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:26
 */
public interface UserService {

    User addUser(User user) throws Exception;

    User login(User user) throws Exception;
}
