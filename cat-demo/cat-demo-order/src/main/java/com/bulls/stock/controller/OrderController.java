package com.bulls.stock.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Transaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    Account账户服务
    @Value("${service3.address:localhost:8083}")
    private String serviceAddress3;
//    stock库存服务
    @Value("${service3.address:localhost:8084}")
    private String serviceAddress4;
//    异常测试端口
    private static final int MOCK_PORT = 8765;

    /**
     * 提供下单接口
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/order")
    public String service2MethodInController() throws InterruptedException {
        Thread.sleep(200);
//        调用账号服务以及库存服务
        String service3 = restTemplate.getForObject("http://" + serviceAddress3 + "/account", String.class);
        String service4 = restTemplate.getForObject("http://" + serviceAddress4 + "/stock", String.class);
        return String.format("Calling order service[order success] ==> Calling Account Service [%s] ==> Calling Customer Service [%s]", service3, service4);
    }

    /**
     * 模拟异常超时接口
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/timeout")
    public String connectionTimeout() throws InterruptedException{
        Transaction t = Cat.newTransaction(CatConstants.TYPE_CALL, "connectionTimeout");
        Thread.sleep(500);
        try{
            log.info("Calling a missing service");
            restTemplate.getForObject("http://locahost:" + MOCK_PORT + "/timeout", String.class);
            return "Should blow up";
        }catch (Exception e){
            t.setStatus(e);
            Cat.getProducer().logError(e);
            throw e;
        }finally {
            t.complete();
        }
    }

}
