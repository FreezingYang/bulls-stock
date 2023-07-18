package com.bulls.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    /**
     * 提供库存接口
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/stock")
    public String stock() throws InterruptedException{
        Thread.sleep(150);
        return "stock success";
    }

}
