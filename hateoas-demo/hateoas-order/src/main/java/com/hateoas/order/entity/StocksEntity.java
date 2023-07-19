package com.hateoas.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "T_STOCKS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StocksEntity extends BaseEntity{

    /**
     * 股票名称
     */
    private String name;

    /**
     * 股票价格
     */
    private Double price;

}
