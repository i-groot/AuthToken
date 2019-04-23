package com.zhangxing.ssm.tokenhelper.rest;

import com.zhangxing.ssm.tokenhelper.dao.mapper.BookMapper;
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
    BookMapper mapper;

    @GetMapping
    @ResponseBody
    public String check()
    {
        mapper.healthCheck();
        return "success";
    }
}
