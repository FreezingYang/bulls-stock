package com.bulls.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    /**
     * 提供账户服务接口
     * @return
     * @throws Exception
     */
    @RequestMapping("/account")
    public String account() throws Exception{
        Thread.sleep(150);
        return "account success";
    }



}
