package com.zhangxing.ssm.tokenhelper.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhangxing
 * @Date: 2019/4/24 0:51
 */
@Controller
@RequestMapping("/app/v1/test")
public class TestController {

    @GetMapping
    @ResponseBody
    public String test()
    {
        System.out.println("-------test--------");
        return "App test ok!";
    }
}
