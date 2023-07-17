package com.bull.stock.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service2.address:localhost:8082}")
    private String serviceAddress;

    /**
     * 模拟正常的请求
     * @return
     * @throws Exception
     */
    @RequestMapping("/gateway")
    public String gateway() throws Exception{
        Thread.sleep(100);
        String response = restTemplate.getForObject("http://" + serviceAddress + "/order", String.class);
        return "gateway response ==>" + response;
    }

    /**
     * 模拟一个请求异常
     * @return
     * @throws Exception
     */
    @RequestMapping("/timeout")
    public String timeout() throws Exception{
        Transaction t = Cat.newTransaction(CatConstants.TYPE_URL, "timeout");
        try{
            Thread.sleep(100);
            String response = restTemplate.getForObject("http://" + serviceAddress + "/timeout", String.class);
            return "gateway response ==>" + response;
        }catch (Exception e){
            Cat.getProducer().logError(e);
            t.setStatus(e);
            throw e;
        }finally {
            t.complete();
        }
    }


}
