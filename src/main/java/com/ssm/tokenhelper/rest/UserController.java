package com.ssm.tokenhelper.rest;

import com.ssm.tokenhelper.business.inf.UserService;
import com.ssm.tokenhelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        System.out.println("-----start addUser-------");
        return userService.addUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request, @RequestBody User user) throws Exception
    {
        System.out.println("-----start login-------");
        return userService.login(request, user);
    }
}
