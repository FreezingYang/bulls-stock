package com.bulls.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 测试访问接口
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome bulls stock platform !";
    }
}
