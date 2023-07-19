package com.hateoas.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "T_STOCKS")
@AllArgsConstructor
@NoArgsConstructor
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
