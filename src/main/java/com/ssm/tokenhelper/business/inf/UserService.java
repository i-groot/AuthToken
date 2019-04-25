package com.ssm.tokenhelper.business.inf;

import com.ssm.tokenhelper.model.User;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:26
 */
public interface UserService {

    User addUser(User user) throws Exception;

    Object login(HttpServletRequest request, User user) throws Exception;

}
