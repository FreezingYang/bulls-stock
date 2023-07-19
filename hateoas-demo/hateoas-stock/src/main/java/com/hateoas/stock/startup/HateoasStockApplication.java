package com.hateoas.stock.startup;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hateoas.stock"})
@EntityScan(basePackages = {"com.hateoas.stock"})
@EnableJpaRepositories(basePackages = {"com.hateoas.stock"})
public class HateoasStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(HateoasStockApplication.class, args);
    }

    /**
     * Hibernate的初始化
     * @return
     */
    @Bean
    public Hibernate5Module hibernate5Module(){
        return new Hibernate5Module();
    }

    /**
     * 用于json数据的封装处理
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){

        return builder -> {
            builder.indentOutput(true);
        };
    }



}
