package com.hateoas.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "T_ORDER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity extends BaseEntity{

    /**
     * 用户名
     */
    private String user;

    /**
     * 股票名称
     */
    private String stockName;

    /**
     * 成交数量
     */
    private Integer volume;


    /**
     * 成交价格
     */
    private Double price;

}
