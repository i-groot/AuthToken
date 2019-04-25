package com.ssm.tokenhelper.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.ssm.tokenhelper.business.inf.UserService;
import com.ssm.tokenhelper.dao.inf.UserDao;
import com.ssm.tokenhelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) throws Exception {
        System.out.println("-----start add user service-----");
        checkUser(user);
        user.setId(UUID.randomUUID().toString());
        userDao.addUser(user);
        user.setPassword(null);
        return user;
    }

    @Override
    public Object login(HttpServletRequest request, User user) throws Exception {
        checkUser(user);
        User user1 = userDao.login(user);
        if (null == user1)
        {
            System.out.println("login failed.");
            throw new Exception("login failed.");
        }
        String token = user1.getId() + "_" + user1.getName() + System.currentTimeMillis();
        HttpSession session = request.getSession();
        session.setAttribute("X-User-Token", token);
        return new TextNode("Login Success.");
    }

    private void checkUser(User user) throws Exception
    {
        if (null == user)
        {
            System.out.println("User is null.");
            throw new Exception("user is null.");
        }
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword()))
        {
            System.out.println("name or password is empty.");
            throw new Exception("name or password is empty.");
        }
    }
}
