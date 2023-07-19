package com.hateoas.stock.repository;

import com.hateoas.stock.entity.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface StocksRepository extends JpaRepository<StocksEntity, Long> {

    /**
     * 根据名称查询股票信息
     * @param name
     * @return
     */
    StocksEntity findByName(@Param("name") String name);
}
