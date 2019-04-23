package com.zhangxing.ssm.tokenhelper;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhangxing
 * @Date: 2019/4/23 0:04
 */
public final class ValidatorUtils {
    
    private ValidatorUtils(){}

    public static void checkUuid(String uuid) throws Exception
    {
        if (!StringUtils.isEmpty(uuid)){
            if (uuid.matches("^[a-zA-z0-9\\-\\_]{1,36}$"))
            {
                return;
            }
        }
        System.out.println("uuid is error.");
        throw new Exception("uuid is error.");
    }

}
