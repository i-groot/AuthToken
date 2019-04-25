package com.ssm.tokenhelper.rest;

import com.fasterxml.jackson.databind.node.TextNode;
import com.ssm.tokenhelper.dao.inf.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 22:41
 */
@Controller
@RequestMapping("/app/v1/health")
public class HealthController {

    @Autowired
    BookDao dao;

    @GetMapping
    @ResponseBody
    public Object check()
    {
        System.out.println("-----start healthCheck-------");
        dao.healthCheck();
        return new TextNode("Health Check OK!");
    }
}
