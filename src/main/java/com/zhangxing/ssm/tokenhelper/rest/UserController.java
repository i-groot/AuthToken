package com.zhangxing.ssm.tokenhelper.rest;

import com.zhangxing.ssm.tokenhelper.business.inf.UserService;
import com.zhangxing.ssm.tokenhelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 0:20
 */
@Controller
@RequestMapping("/app/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public Object addUser(@RequestBody User user) throws Exception
    {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody User user) throws Exception
    {
        return userService.login(user);
    }
}
